package main

import (
	"container/list"
	"context"
	"fmt"
	"github.com/satori/go.uuid"
	"go.mongodb.org/mongo-driver/mongo" //MongoDB的Go驱动包
	"go.mongodb.org/mongo-driver/mongo/options"
	"io/ioutil"
	"log"
	"net/http"
	"regexp"
	"strings"
	"time"
)

const mongoServer = "localhost"
const mongoPort = "27017"
const mongoDatabase = "csdn_article"
const mongoCollection = "article_base"

// 获取url的页面
func HttpGetHtml(url string) (result string, err error) {
	resp, respErr := http.Get(url)
	if (respErr != nil) {
		err = respErr
		fmt.Println("抓取网页出现问题，url=" + url)
		return
	}

	defer resp.Body.Close()

	bodyByte, _ := ioutil.ReadAll(resp.Body)
	bodyStr := string(bodyByte)

	return bodyStr, err
}

// 过滤出csdn的url链接
func filterCsdnHref(contents string) *list.List {
	// <a href="https://blog.csdn.net/gopain/article/details/17185979" target="_blank"

	csdnUrlRe := `href="https://blog.csdn.net/.*?"`
	compile := regexp.MustCompile(csdnUrlRe)
	allSubmatch := compile.FindAllStringSubmatch(contents, -1)

	urlList := list.New()

	for _, submatch := range allSubmatch {
		var urlWithShit = submatch[0]
		index:= strings.Index(urlWithShit, "\"")
		index++
		urlWithShit = urlWithShit[index:]

		url := urlWithShit[0 : len(urlWithShit) - 1]
		urlList.PushBack(url)
	}

	return urlList
}

func openMongoClient() (*mongo.Collection) {

	clientOptions := options.Client().ApplyURI("mongodb://" + mongoServer + ":" + mongoPort)
	client, err := mongo.Connect(context.TODO(), clientOptions)
	if err != nil {
		log.Fatal("mongo数据库连接失败，原因={}", err)
	}
	err = client.Ping(context.TODO(), nil)
	if err != nil {
		log.Fatal("mongo数据库连接失败，原因={}", err)
	}
	log.Println("成功连接mongodb！")

	collection := client.Database(mongoDatabase).Collection(mongoCollection)
	return collection
}

// 程序入口
func main() {

	html, _ := HttpGetHtml("https://blog.csdn.net/iotisan/article/details/104463582")
	//fmt.Println(html)
	urlList := filterCsdnHref(html)

	client := openMongoClient()

	saveUrl(urlList, client)
	// https://www.cnblogs.com/dongyuq1/p/13595258.html
	// https://www.cnblogs.com/Dr-wei/p/11742293.html

	//client.close
}

type UrlInfo struct {
	Id string
	Url string
	CreateTime string
}

//type DateUtil struct {
//}

func NOW_YYYY_MM_DD_HH_MM_SS() (timeStr string) {
	now  := time.Now()
	//Year = now.Year()
	//Mouth  = now.Month()
	//Day  =  now.Day()
	//时间格式化输出 Printf输出
	timeStr = fmt.Sprintf("当前时间为： %d-%d-%d %d:%d:%d\n",now.Year(),now.Month(),now.Day(),now.Hour(),now.Minute(),now.Second())
	//fmt.Sprintf 格式化输出
	//dateString := fmt.Sprintf("当前时间为： %d-%d-%d %d:%d:%d\n",now.Year(),now.Month(),now.Day(),now.Hour(),now.Minute(),now.Second())
	//fmt.Println(dateString)
	//now.Format 方法格式化
	//fmt.Println(now.Format("2006-01-02 15:04:05"))
	//fmt.Println(now.Format("2006/01/02 15:04:05"))
	//fmt.Println(now.Format("2006/01/02"))//年月日
	//fmt.Println(now.Format("15:04:05"))//时分秒
	return timeStr
}

func saveUrl(urlList *list.List, collection *mongo.Collection) {
	if urlList == nil || urlList.Len() == 0 {
		log.Println("保存的urlList为空")
	}

	for url := urlList.Front(); url != nil; url = url.Next() {
		value := url.Value
		urlInfo := &UrlInfo{
			Id:         uuid.NewV4().String(),
			Url:        fmt.Sprint(value),
			CreateTime: NOW_YYYY_MM_DD_HH_MM_SS(),
		}

		insertOne, err := collection.InsertOne(context.TODO(), urlInfo)
		if err != nil {
			log.Println("插入url失败，原因={}", err)
			return
		}
		id := insertOne.InsertedID
		log.Println("插入的id = {}", id)
	}

}