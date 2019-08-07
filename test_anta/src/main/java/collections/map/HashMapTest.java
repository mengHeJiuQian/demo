package collections.map;

import org.apache.commons.lang.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description
 * @Author yang.liu
 * @Date 2018/12/25 20:29
 */
public class HashMapTest {

    public static final int TEST_NUM = 1_000_000; // 测试量

    public static void main(String[] args) {
//        hashMapTest();
//        testConcurrentHashMap();

//        // testContainsKey();
//        System.out.println(0x7fffffff);
//        System.out.println(1 << 30);
//
//        testCHashMap_tableSizeFor();

        HashMap map = new HashMap();
        map.put("a", 1);
        map.put("b", 2);
        map.put("b", 3);
        map.put("b", 4);
        map.put("b", 1);
        map.put("b", 1);
        map.put("b", 1);
        map.put("b", 1);
        map.put("b", 1);
        map.put("b", 1);
        map.put("b", 1);

    }

    public static void testCHashMap_tableSizeFor() {
        /*int initialCapacity = 10;
        int sc = initialCapacity + (initialCapacity >>> 1) + 1;
        System.out.println(sc);
        int i = tableSizeFor(sc);
        System.out.println(i);*/
    }

    /**
     * 测试hashMap怎么做到设置数组大小为2的整数次幂的
     */
    @Test
    public void tableSizeFor() {
        int MAXIMUM_CAPACITY = 1 << 30;
        int c = 1;
        int n = c - 1; // 减一是为了对于已经是二次幂的容量大小操作依然是该二次幂
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        n = (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
        System.out.println(n);
    }

    private  static void hashMapTest() {
        HashMap map = new HashMap();

        long t1 = System.currentTimeMillis();
        for (int i = 0; i < TEST_NUM; i++) {
            map.put(i + 1, i + 1);
        }
        long t2 = System.currentTimeMillis();
        System.out.println("HashMap-测试数据量：" + TEST_NUM + "，用时：" + (t2 - t1) + "毫秒");
    }

    public static void testContainsKey() {
        HashMap map = new HashMap();
        map.put(1, null);
        map.put(null, "2");
        if (null == null) {
            System.out.println("sadf");
        }
        System.out.println("null == null ? " + null == null);
        System.out.println("真null假null都是null：" + map.get(1));
        System.out.println("真null假null都是null：" + map.get(2));
        System.out.println("HashMap中key可否存null：" + map.containsKey(null));
        System.out.println("真null是null：" + map.containsValue(2));
        System.out.println("假null不是null：" + map.containsValue(null));
    }

    private static void testConcurrentHashMap() {
        ConcurrentHashMap map = new ConcurrentHashMap(65);
        long t1 = System.currentTimeMillis();
        for (int i = 0; i < TEST_NUM; i++) {
            map.put(i + 1, i + 1);
        }
        long t2 = System.currentTimeMillis();
        System.out.println("ConcurrentHashMap-测试数据量：" + TEST_NUM + "，用时：" + (t2 - t1) + "毫秒");
    }

    /**
     [
     {
     "store_no":"3434",
     "store_name":"嘉定斯凯奇店",
     "store_type_name":"店铺类型名称1",
     "store_source":"店铺渠道1",
     "status":"1",
     "shopId":"3434",
     "shopName":"嘉定斯凯奇店"
     },
     {
     "store_no":"XAA7关店",
     "store_name":"西安宝鸡天下汇关店",
     "store_type_name":"123",
     "store_source":"123",
     "status":"1",
     "shopId":"XAA7关店",
     "shopName":"西安宝鸡天下汇关店"
     }
     ]
     */
    @Test
    public void testMapInList() {
        Map m1 = new HashMap();
        m1.put("store_no", "3434");
        m1.put("store_name", "嘉定斯凯奇店");
        m1.put("store_type_name", "店铺类型名称1");
        m1.put("store_source", "店铺渠道1");
        m1.put("status", "1");
        m1.put("shopId", "3434");
        m1.put("shopName", "嘉定斯凯奇店");

        Map m2 = new HashMap();
        m2.put("store_no", "XAA7关店");
        m2.put("store_name", "西安宝鸡天下汇关店");
        m2.put("store_type_name", "123");
        m2.put("store_source", "123");
        m2.put("status", "1");
        m2.put("shopId", "XAA7关店");
        m2.put("shopName", "西安宝鸡天下汇关店");

        List<Map> resultList = new ArrayList();
        resultList.add(m1);
        resultList.add(m2);
        String rulesId = "123123";

        if (!CollectionUtils.isEmpty(resultList)) {
            //获得所有列名
            List<String> columnName = new ArrayList(resultList.get(0).keySet());

            //列名的SQL，如store_no,store_name,store_type_name
            String columnSql = StringUtils.join(columnName, ",");
            // 加上id,和rules_id两个参数
            String valueSql = generatePrepareStatementValueSql(columnName.size() + 2, resultList.size());

            List<String> params = new ArrayList<>();
            resultList.stream().forEach(map -> {
                params.add(UUID.randomUUID().toString());
                params.add(rulesId);
                columnName.stream().forEach(col -> params.add((String) map.get(col)));
            });
            System.out.println(columnName.toString());
            System.out.println(params.toString());
            String sql = "insert into shop_selector_result(id,rules_id," + columnSql + ") " + valueSql;
            System.out.println(sql);
        }

    }

    private static String generatePrepareStatementValueSql(int paramNum, int records) {
        StringBuilder prepareStatementValueSql = new StringBuilder(" values ");
        for (int i = 0; i < records; i++) {
            StringBuilder recordSql = new StringBuilder("(");
            for (int j = 1; j <= paramNum; j++) {
                recordSql.append("?,");
            }
            recordSql = recordSql.deleteCharAt(recordSql.length() - 1);
            recordSql.append("),");
            prepareStatementValueSql.append(recordSql);
        }
        return prepareStatementValueSql.deleteCharAt(prepareStatementValueSql.length() - 1).toString();
    }

}
