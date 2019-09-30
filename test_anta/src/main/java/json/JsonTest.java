package json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.junit.jupiter.api.Test;
import org.redisson.misc.Hash;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.TemporalUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Author yang.liu
 * @Date 2019/4/28 15:43
 */
public class JsonTest {

    @Test
    public void testStringJson() {
        String str = "12312 1 123";
        Gson gson = new Gson();
        String json = gson.toJson(str);
        System.out.println("-" + json + "-");
    }

    @Test
    public void testJsonMap() {
        HashMap map = new HashMap();
        map.put("deptId", 123);

        HashMap map2 = new HashMap();
        map2.put("title", "啊阿道夫");
        map2.put("sendTime", "2019-01-01 10:10:10");
        map.put("params", map2);

        List list = new ArrayList();
        Map map3 = new HashMap();
        map3.put("openId", "23413yangliu");
        Map map4 = new HashMap();
        map4.put("openId", "2adfafsheldon");

        list.add(map3);
        list.add(map4);
        map.put("userInfos", list);

        System.out.println(JSON.toJSONString(map));
    }

    @Test
    public void testGson() {
        List<Map<String, Integer>> list = new ArrayList<>();
        for (int i = 1; i <= 1_000_000; i++) {
            Map<String, Integer> map = new HashMap<>();
            map.put(String.valueOf(i), i);
            list.add(map);
        }
        Instant t1 = Instant.now();
        Gson gson = new Gson();
        String json = gson.toJson(list);
        Instant t2 = Instant.now();
        System.out.println(Duration.between(t1,t2).toMillis());

        Instant t3 = Instant.now();
        List list1 = gson.fromJson(json, List.class);
        Instant t4 = Instant.now();
        System.out.println(Duration.between(t3,t4).toMillis());
    }

    @Test
    public void testFastJson() {
        List<Map<String, Integer>> list = new ArrayList<>();
        for (int i = 1; i <= 1_000_000; i++) {
            Map<String, Integer> map = new HashMap<>();
            map.put(String.valueOf(i), i);
            list.add(map);
        }
        Instant t1 = Instant.now();
        String json = JSONObject.toJSONString(list);
        Instant t2 = Instant.now();
        System.out.println(Duration.between(t1,t2).toMillis());

        Instant t3 = Instant.now();
        List list1 = JSONObject.parseObject(json, List.class);
        Instant t4 = Instant.now();
        System.out.println(Duration.between(t3,t4).toMillis());
    }

}
