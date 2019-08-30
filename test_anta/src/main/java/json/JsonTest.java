package json;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import org.redisson.misc.Hash;

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

}
