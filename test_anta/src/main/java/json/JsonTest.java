package json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.junit.jupiter.api.Test;
import org.redisson.misc.Hash;
import org.springframework.util.CollectionUtils;

import java.io.*;
import java.time.Duration;
import java.time.Instant;
import java.time.temporal.TemporalUnit;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Description
 * @Author yang.liu
 * @Date 2019/4/28 15:43
 */
public class JsonTest {

    @Test
    public void testBatchInsert10000() {
        int testNum = 10_000;
        List list = new ArrayList(testNum);
        String key = "code";
        for (int i = 0; i < testNum; i++) {
            String code = UUID.randomUUID().toString().replace("-", "").substring(7);
            Map<String, String> map = new HashMap<>(1);
            map.put(key, "sheldon" + code);
            list.add(map);
        }
        Map map = new HashMap(1);
        map.put("couponCodeList", list);

        System.out.println(JSONObject.toJSONString(map));

    }

    @Test
    public void testRemoveMultiply() throws IOException {
        FileInputStream fis = new FileInputStream(new File("E:\\myProject\\yangliu\\demo\\test_anta\\src\\main\\java\\json\\json.json"));

        BufferedReader in = new BufferedReader(new InputStreamReader(fis));
        String json = in.readLine();


        in.close();
        fis.close();
        Map mapObject = JSONObject.parseObject(json, HashMap.class);

        List<Map<String, String>> couponCodeList = (List<Map<String, String>>) mapObject.get("couponCodeList");

        Set<String> uniqueCodeList = couponCodeList.stream()
                .map(map -> map.values())
                .flatMap(Collection::stream)
                .map(s -> {
                    //s = "'" + s + "'";
                    return s;
                })
                .collect(Collectors.toSet());
        List<String> collect = uniqueCodeList.stream().sorted().collect(Collectors.toList());

        for (int i = 0; i < collect.size(); i++) {
            System.out.println(collect.get(i));
        }
    }

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
