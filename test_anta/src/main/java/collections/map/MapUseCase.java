package collections.map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Description: 使用map做一些处理，
 * @Author: sheldon
 * @Create Date: 2019/9/30 9:49
 * @Update Date: 2019/9/30 9:49
 */
public class MapUseCase {

    /**
     * 取一个list里每一个map的所有value,同时对value去重
     */
    @Test
    public void test1() {
        String requestBody = "{\"brandCode\":\"xxx\",\"couponId\":111,\"couponCodeList\":[{\"code\":\"aaa\"},{\"code\":\"bbb\"},{\"code\":\"ccc\"}]}";
        Map<String, Object> requestObject =  JSONObject.parseObject(requestBody, Map.class);
        Collection<Map<String, String>> codeList = (Collection) requestObject.get("couponCodeList");
        Set<String> collect = codeList.stream().flatMap(map -> Stream.of(map)).map(Map::values).flatMap(coll -> coll.stream()).collect(Collectors.toSet());
        System.out.println(collect);
        requestObject.put("couponCodeList", collect);

        String o = JSONObject.toJSONString(requestObject);
        System.out.println(o);

    }

}
