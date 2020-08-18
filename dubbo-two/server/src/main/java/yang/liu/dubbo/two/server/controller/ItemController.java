package yang.liu.dubbo.two.server.controller;

import com.google.common.collect.Maps;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import yang.liu.dubbo.one.api.enums.StatusCode;
import yang.liu.dubbo.one.api.response.BaseResponse;
import yang.liu.dubbo.one.api.service.DubboItemService;

import java.util.Map;

/**
 * 创建人：yang.liu
 * 创建时间：2019/7/25 15:49
 * 版本：1.0
 * 内容描述：
 */
@RestController
public class ItemController {

    public static final Logger log = LoggerFactory.getLogger(ItemController.class);

    public static final String prefix = "item";

    @Autowired
    private DubboItemService dubboItemService;

    public static final Gson gson = new Gson();

    /**
     * 通过别的服务查询商品信息
     * @return
     */
    @RequestMapping(value = prefix + "/list", method = RequestMethod.GET)
    public Map list() {
        Map itemMap = Maps.newHashMap();
        try {
            BaseResponse items = dubboItemService.listItems();
            log.info("查询结果{}", gson.toJson(items));
            System.out.println(items.getCode() == StatusCode.SUCCESS.getCode()); // 反序列化后的code虽然是200，推测是个新的Integer对象。
            itemMap.put("data", items.getData());
            itemMap.put("code", 200);
            itemMap.put("msg", "成功");
        } catch (Exception e) {
            e.printStackTrace();
            itemMap.put("code", 500);
            itemMap.put("msg", "失败");
        }
        return itemMap;
    }

    /**
     * 通过别的服务分页查询商品信息
     * @return
     */
    @RequestMapping(value = prefix + "/page/list", method = RequestMethod.GET)
    public Map pageList(@RequestParam Integer pageNo, @RequestParam Integer pageSize) {
        if (pageNo == null || pageSize == null || pageNo == 0 || pageSize == 0) {
            pageNo = 1;
            pageSize = 2;
        }
        Map itemMap = Maps.newHashMap();
        itemMap.put("code", 200);
        itemMap.put("msg", "成功");

        try {
            BaseResponse items = dubboItemService.listPageItems(pageNo, pageSize);
            itemMap.put("data", items.getData());
        } catch (Exception e) {
            e.printStackTrace();
            itemMap.put("code", 500);
            itemMap.put("msg", "失败");
        }
        return itemMap;
    }

    /**
     * 用户商城列表查询-分页查询-带参数模糊查询
     * @return

    @RequestMapping(value = prefix+"/page/list/params",method = RequestMethod.GET)
    public Map<String,Object> pageListParams(Integer pageNo,Integer pageSize,String search){
        if (pageNo==null || pageSize==null || pageNo<=0 || pageSize<=0){
            pageNo=1;
            pageSize=2;
        }
        Map<String,Object> resMap= Maps.newHashMap();
        resMap.put("code","0");
        resMap.put("msg","成功");

        //TODO:调用服务提供方dubboOne提供的列表查询-分页查询功能
        try {
            BaseResponse response=dubboItemService.listPageItemsParams(pageNo,pageSize,search);
            if (response!=null && response.getCode().equals(0)){
                resMap.put("data",response.getData());

            }
        }catch (Exception e){
            e.printStackTrace();
            resMap.put("code","-1");
            resMap.put("msg","失败");
        }
        return resMap;
    }*/
}
