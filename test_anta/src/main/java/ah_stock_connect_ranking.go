package main

import (
	"fmt"
	"log"
	"os"
	"path/filepath"
	"runtime"
	"strings"
	"time"

	"github.com/globalsign/mgo/bson"
	"golang.org/x/net/context"

	"hk-collector/config"
	"hk-collector/database/mongo"
	"hk-collector/database/redis"
	"hk-collector/database/rpc"
	pb "hk-collector/service/stock"
	"hk-collector/utils"
	"hk-collector/utils/redisutils"
	"hk-collector/utils/rpcutils"
)

// https://gitlab.huanshoulv.com/DOCS/oschina-wiki/blob/master/%E6%A0%87%E7%AD%BE%E4%BD%8D%E6%95%B0%E5%AF%B9%E5%BA%94%E5%85%B3%E7%B3%BB-special_marker.md
// https://gitlab.huanshoulv.com/DOCS/oschina-wiki/blob/master/ah_stock_connect_ranking.md
const (
	PREFIX           = "ahStockConnect:"         // ahStockConnect:
	BUY_SELL_MAP     = PREFIX + "BuySellMap"     // ahStockConnect:BuySellMap 沪深股通 可买可卖
	BUY_SELL_ARR     = PREFIX + "BuySellArr"     // ahStockConnect:BuySellArr 沪深股通 可买可卖
	MARGIN_SHORT_MAP = PREFIX + "MarginShortMap" // ahStockConnect:MarginShortMap 融资融券
	MARGIN_SHORT_ARR = PREFIX + "MarginShortArr" // ahStockConnect:MarginShortArr 融资融券
	T0_MAP           = PREFIX + "T0Map"          // ahStockConnect:T0Map T+0
	T0_ARR           = PREFIX + "T0Arr"          // ahStockConnect:T0Arr T+0
)

var logger *log.Logger

type surgeLimitReal struct {
	StockCode string `bson:"stock_code" json:"stock_code"`
	StockType int    `bson:"stock_type" json:"stock_type"`
	Type      int    `bson:"type" json:"type"`
}

func init() {
	mongo.Init()
	rpc.Init()
	redispool.Init()
}

var fields = []string{
	"prod_code",         // 股票代码
	"prod_name",         // 股票名称
	"finance_mic",       // 市场类型
	"special_marker",    // 标签
	"last_px",           // 最新价
	"px_change_rate",    // 涨幅
	"amplitude",         // 振幅
	"turnover_ratio",    // 换手率
	"ddx",               // 换手率DDX
	"ddy",               // 换手率DDY
	"inflow",            // 今日主力净买额
	"inflow_3_day",      // 三日主力净买额
	"inflow_5_day",      // 五日主力净买额
	"business_balance",  // 成交额
	"business_amount",   // 成交量
	"min5_chgpct",       // 五分钟涨速
	"limit_gene",        // 涨停基因
	"oyo_surged_rate",   // 近一年涨停封板成功率
	"oyh_surged_days",   // 近一年触碰涨停
	"oy_surged_days",    // 近一年涨停
	"market_value",      // 总市值
	"circulation_value", // 流通市值
}

var firstTime = true

func main() {
	// 设置 logger
	_, filePath, _, ok := runtime.Caller(0)
	if ok == false {
		fmt.Println("获取文件名失败")
		os.Exit(-1)
	}
	fileName := filepath.Base(filePath)
	fileName = strings.Split(fileName, ".")[0]
	logName := strings.Join([]string{fileName, "log"}, ".")

	err := os.Mkdir("logs", os.ModePerm)
	if err != nil {
		if os.IsExist(err) {
		} else {
			log.Fatalf("os.Mkdir(...), err: %v\n", err)
		}
	}

	file, err := os.OpenFile(filepath.Join("logs", logName), os.O_RDWR|os.O_CREATE|os.O_APPEND, 0666)
	if err != nil {
		log.Fatalf("os.OpenFile(...), err: %v\n", err)
	}

	logger = log.New(file, "", log.LstdFlags|log.Lmicroseconds|log.Lshortfile)

	// 更新redis逻辑
	logger.Println("start...", time.Now().Format(config.StandardTimeFormat))
	defer logger.Println("end...", time.Now().Format(config.StandardTimeFormat))

	// 定时器3秒
	ticker := time.NewTicker(config.DefaultConfig.AhStockConnectRanking.Interval * time.Second)
	defer func() {
		logger.Println("ticker.Stop()")
		ticker.Stop()
	}()

	updateRanking()
	for {
		select {
		case v := <-ticker.C:
			logger.Println("当前时间:\t", v)
			updateRanking()
		}
	}
}

// 更新
func updateRanking() {
	if firstTime == false {
		if !(utils.IsTradeDayNow() && utils.IsTrading()) {
			logger.Println("not trading")
			return
		}
	}

	field2Index, err := utils.Field2Index(fields)
	if err != nil {
		logger.Println(err.Error())
		return
	}
	prodCodeIndex, ok := field2Index["prod_code"]
	if ok == false {
		logger.Println(err.Error())
	}

	redisKey := "ah_stock_connect_ranking"
	timeStamp := time.Now().Format("2006-01-02 15:04:05")

	// 取数据
	var BuySellMap map[string]bool
	var MarginShortMap map[string]bool
	var codeList []string

	// 获取redis数据 ahStockConnect:BuySellMap 沪深股通 可买可卖
	if err := redisutils.GetWithVar(redispool.CacheDb, BUY_SELL_MAP, &BuySellMap); err != nil {
		logger.Println(err)
		return
	}
	// ahStockConnect:MarginShortMap 融资融券
	if err := redisutils.GetWithVar(redispool.CacheDb, MARGIN_SHORT_MAP, &MarginShortMap); err != nil {
		logger.Println(err)
		return
	}
	// ahStockConnect:BuySellArr 沪深股通 可买可卖
	if err := redisutils.GetWithVar(redispool.CacheDb, BUY_SELL_ARR, &codeList); err != nil {
		logger.Println(err)
		return
	}

	pxChangeRateGt8List := make([]string, 0)
	codes := strings.Join(codeList, ",")
	in := pb.StocksRealsReq{
		Codes: codes,
	}
	re, err := rpc.RpcStockClient.GetStocksRealsData(context.Background(), &in)

	if err != nil {
		logger.Println(err.Error())
		return
	} else {
		reSsSz := pb.StocksRealsResp{}
		reMarginShort := pb.StocksRealsResp{}

		// 获取涨停打开股票列表
		onceSurged, _ := getOnceSurged()
		for _, v := range re.Reals {
			// 如果在涨停打开列表里就过滤掉
			if _, ok := onceSurged[v.ProdCode]; ok {
				continue
			}
			if b, ok := BuySellMap[v.ProdCode]; ok && b {
				// 冲击涨停股票列表,涨幅大于8%
				if v.PxChangeRate >= 8 && !utils.IsSurged(v.LastPx, v.PreclosePx) {
					pxChangeRateGt8List = append(pxChangeRateGt8List, v.ProdCode)
				}
				reSsSz.Reals = append(reSsSz.Reals, v)
			}

			if b, ok := MarginShortMap[v.ProdCode]; ok && b {
				reMarginShort.Reals = append(reMarginShort.Reals, v)
			}
		}

		// 沪深股通（香港券商可交易A股标的）涨幅榜
		ssSzPxChangeRate := getResult(&reSsSz, "px_change_rate", -1, 10, prodCodeIndex)
		// 沪深股通振幅榜
		ssSzAmplitude := getResult(&reSsSz, "amplitude", -1, 10, prodCodeIndex)
		// 沪深股通换手率榜
		ssSzTurnoverRatio := getResult(&reSsSz, "turnover_ratio", -1, 10, prodCodeIndex)
		// 沪深股通成交额榜
		ssSzBusinessBalance := getResult(&reSsSz, "business_balance", -1, 10, prodCodeIndex)
		// 融资融券标的涨幅榜
		marginShortPxChangeRate := getResult(&reMarginShort, "px_change_rate", -1, 10, prodCodeIndex)

		resultMap := map[string]interface{}{
			"fields":                  fields,
			"ssSzPxChangeRate":        ssSzPxChangeRate,
			"ssSzAmplitude":           ssSzAmplitude,
			"ssSzTurnoverRatio":       ssSzTurnoverRatio,
			"ssSzBusinessBalance":     ssSzBusinessBalance,
			"marginShortPxChangeRate": marginShortPxChangeRate,
			"timeStamp":               timeStamp,
		}

		// pxChangeRateGt8List 设置涨停打开涨幅大于8的股票列表
		gt8ListKey := "ah_px_change_rate_gt_8_list"
		if _, err := redisutils.Set(redispool.CacheDb, gt8ListKey, pxChangeRateGt8List, 0); err != nil {
			logger.Println("set cached data error:\t", err)
			return
		}

		// 合并数据
		hklist, err := redisutils.Get(redispool.CacheDb, "hklist")
		if err != nil {
			logger.Println(err.Error())
			return
		} else {
			hklistData, ok := hklist.(map[string]interface{})
			if ok == false {
				logger.Println("the type of hklist is not map[string]interface{}")
			} else {
				// 遍历hklist数据到resultMap里面
				for k, v := range hklistData {
					if k != "szData" && k != "ssData" {
						resultMap[k] = v
					}
				}
				_, err := redisutils.Set(redispool.CacheDb, redisKey, resultMap, 0)
				if err != nil {
					logger.Println(err.Error())
					return
				}
			}
		}
	}
	firstTime = false
}

// 排序，取前M条数据
func getResult(re *pb.StocksRealsResp, sortFieldName string, sortType int, M int, index int) *[]interface{} {
	rpcutils.SortStocksRealsResp(re, sortFieldName, sortType)

	if len(re.Reals) < M {
		M = len(re.Reals)
	}

	result := make([]interface{}, 0)
	for i := 0; i < M; i++ {
		v := rpcutils.GetFieldsOfReals(re.Reals[i], &fields)
		// 去除末尾的finance_mic
		rpcutils.ModifyResultString(v, index, utils.TrimFinanceMic)
		result = append(result, v)
	}

	return &result
}

// 获取涨停打开股票列表
func getOnceSurged() (map[string]bool, error) {
	mongoSession := mongo.GetMongoSession()
	defer mongo.PutMongoSession(mongoSession)

	var models []surgeLimitReal
	// type 1:涨停板 2:涨停打开 3:跌停板 4:跌停打开
	// stock_type:1 一字板  2:自然板
	result := map[string]bool{}

	err := mongoSession.DB("god").
		C("surged_reals").
		Find(bson.M{"type": 2}).
		Select(bson.M{"stock_type": 1, "stock_code": 1}).All(&models)
	if err != nil {
		// logger.Info(err.Error())
		return result, err
	}
	for i := range models {
		model := models[i]
		result[model.StockCode] = true
	}
	return result, nil
}
