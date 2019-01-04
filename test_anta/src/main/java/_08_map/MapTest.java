package _08_map;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description TODO
 * @Author yang.liu
 * @Date 2018/12/25 20:29
 */
public class MapTest {

    public static final int TEST_NUM = 1_000_000; // 测试量

    public static void main(String[] args) {
//        HashMapTest();
        // testContainsKey();
//        testConcurrentHashMap();
        System.out.println(0x7fffffff);
        System.out.println(1 << 30);

        testCHashMap_tableSizeFor();

    }

    public static void testCHashMap_tableSizeFor() {
        int initialCapacity = 10;
        int sc = initialCapacity + (initialCapacity >>> 1) + 1;
        System.out.println(sc);
        int i = tableSizeFor(sc);
        System.out.println(i);
    }

    private static int tableSizeFor(int c) {
        int n = c - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return n + 1;
    }

    public static void HashMapTest() {
        HashMap map = new HashMap();
//        map.put(new Object(), 1);
//        map.put(new Object(), 2);
//        System.out.println(map.size());



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
        System.out.println(null == null);
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
}
