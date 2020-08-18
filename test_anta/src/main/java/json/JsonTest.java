package json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.time.Duration;
import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Description
 * @Author yang.liu
 * @Date 2019/4/28 15:43
 */
public class JsonTest {

    @Test
    public void testJson() {
        Map<String, String> map = new HashMap<>();
        String value = "{\"IDCard\":\"110103198011080621\",\"IDType\":\"1\",\"customerId\":\"00926314\",\"customerName\":\"CLIENT00926314\",\"packageCode\":\"78DB89B9-92B6-46D9-8188-794D707D8A26\",\"packageName\":\"都会健康 （AGY）-ED28AA-白金+海外就医\",\"policyNo\":\"01240095\",\"productCode\":\"ED28AA\",\"productName\":\"都会健康 （AGY）\",\"reserveDate\":\"2019-03-18 09:06:52\",\"residueNumber\":37,\"serviceCode\":\"AK_08\",\"serviceDate\":\"2019-03-18 09:06:52\",\"serviceName\":\"导医服务（不限重疾）\",\"serviceNumber\":500,\"serviceOrderId\":\"155287121215495\",\"serviceStatus\":\"待服务\",\"serviceStatusCode\":\"011\",\"tel\":\"13482058924\"}";
        map.put("info", value);
        System.out.println(JSON.toJSONString(map));
    }

    @Test
    public void testTreeMap() {
        TreeMap treeMap = new TreeMap();
        treeMap.put("name", "liuyang");
        treeMap.put("age", 1);

        String s = JSONTool.toJSON(treeMap);
        System.out.println(s);

        TreeMap treeMap1 = JSONTool.toObject(s, TreeMap.class);
        System.out.println(treeMap1);

    }

    @Test
    public void testFastJsonPrivateConstruct() {
        String jsonStr = "{\n" +
                "        \"name\":\"tom\",\n" +
                "        \"age\":3\n" +
                "    }";

        jsonStr = "{\n" +
                "    \"data\":{\n" +
                "        \"first\":{\n" +
                "            \"color\":\"#173177\",\n" +
                "            \"value\":\"尊敬的客户，健康顾问已受理您的咨询申请，您可直接点击此条消息或者“历史服务查询”中的“继续服务”进一步咨询。服务时间为受理后的24小时内。如超时，请另行申请，敬请谅解。 \n" +
                "\"\n" +
                "        },\n" +
                "        \"keyword1\":{\n" +
                "            \"color\":\"#173177\",\n" +
                "            \"value\":\"无实大大\"\n" +
                "        },\n" +
                "        \"keyword2\":{\n" +
                "            \"color\":\"#173177\",\n" +
                "            \"value\":\"2020-06-15 14:29:00\"\n" +
                "        },\n" +
                "        \"keyword3\":{\n" +
                "            \"color\":\"#173177\",\n" +
                "            \"value\":\"2020-06-16 14:29:00\"\n" +
                "        },\n" +
                "        \"remark\":{\n" +
                "            \"color\":\"#173177\",\n" +
                "            \"value\":\"\"\n" +
                "        }\n" +
                "    },\n" +
                "    \"templateId\":\"dgCOlHEAZlqLOB0xVpf5sbrCLEs2d5oG5yGZ5MMSsFc\",\n" +
                "    \"touser\":\"odfuVv_1PHxO8DX61CaVFWPjU05Y\",\n" +
                "    \"url\":\"www.baidu.com\"\n" +
                "}";
//        Gson gson = new Gson();
//        TemplateData templateData = gson.fromJson(jsonStr, TemplateData.class);
//        System.out.println(templateData);

//        TemplateData templateData = JSONTool.toObject(jsonStr, TemplateData.class);
//        System.out.println(templateData);
        JSONObject jsonObject = JSONObject.parseObject(jsonStr);
        String url = jsonObject.getString("url");
        String touser = jsonObject.getString("touser");
        String templateId = jsonObject.getString("templateId");

        Map<String, Object> map = (Map<String, Object>) jsonObject.get("data");

        TemplateData templateData = TemplateData.getTemplateData();
        templateData.setUrl(url);
        templateData.setTemplateId(templateId);
        templateData.setTouser(touser);

        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String keyword = entry.getKey();

            Map<String, String> colorMap = (Map<String, String>) entry.getValue();
            String color = (String) colorMap.get("color");
            String value = (String) colorMap.get("value");

            System.out.println(keyword);
            System.out.println(color);
            System.out.println(value);
            templateData.add(keyword, value, color);
        }

        System.out.println(JSON.toJSONString(templateData));
    }

    @Test
    public void testFastJsonWithNullObj() {
        // fastjson 会将空对象，转为“null”字符串
        System.out.println(JSON.toJSONString(null));

        Gson gson = new Gson();
        System.out.println(gson.toJson(null));
    }

    @Test
    public void testBatchInsert10000() {
        int testNum = 10000;
        List list = new ArrayList(testNum);
        String key = "code";
        for (int i = 0; i < testNum; i++) {
            String code = UUID.randomUUID().toString().replace("-", "").substring(7);
            Map<String, String> map = new HashMap<>(1);
            map.put(key, "shukai1" + code);
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
        System.out.println(collect.size());
    }

    /**
     * output:
     *     -"12312 1 123"-
     */
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
        System.out.println(Duration.between(t1, t2).toMillis());

        Instant t3 = Instant.now();
        List list1 = gson.fromJson(json, List.class);
        Instant t4 = Instant.now();
        System.out.println(Duration.between(t3, t4).toMillis());
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
        System.out.println(Duration.between(t1, t2).toMillis());

        Instant t3 = Instant.now();
        List list1 = JSONObject.parseObject(json, List.class);
        Instant t4 = Instant.now();
        System.out.println(Duration.between(t3, t4).toMillis());
    }

}
