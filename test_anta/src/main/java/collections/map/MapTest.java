package collections.map;

import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 创建人：yang.liu
 * 创建时间：2019/7/19 16:33
 * 版本：1.0
 * 内容描述：Map的一些实现类性能比较。
 */
public class MapTest {

    public static int SAMPLE_NUM = 200_0000;

    public static void main(String[] args) {
        /*testHashMap();
        testCHashMap();
        testHashtable();*/


    }

    public static void testHashMap() {
        HashMap hm = new HashMap();
        Instant start = Instant.now();
        for (int i = 0; i < SAMPLE_NUM; i++) {
            hm.put(i, i);
        }
        Instant end = Instant.now();

        for (int i = 0; i < SAMPLE_NUM; i++) {
            hm.get(i);
        }
        Instant end2 = Instant.now();

        System.out.println("执行添加时间：" + Duration.between(start, end).toMillis() + "毫秒");
        System.out.println("执行读取时间：" + Duration.between(end, end2).toMillis() + "毫秒");
    }

    public static void testCHashMap() {
        ConcurrentHashMap chm = new ConcurrentHashMap();
        Instant start = Instant.now();
        for (int i = 0; i < SAMPLE_NUM; i++) {
            chm.put(i, i);
        }
        Instant end = Instant.now();
        for (int i = 0; i < SAMPLE_NUM; i++) {
            chm.get(i);
        }
        Instant end2 = Instant.now();

        System.out.println("执行添加时间：" + Duration.between(start, end).toMillis() + "毫秒");
        System.out.println("执行读取时间：" + Duration.between(end, end2).toMillis() + "毫秒");
    }

    public static void testHashtable() {
        Hashtable ht = new Hashtable();
        Instant start = Instant.now();
        for (int i = 0; i < SAMPLE_NUM; i++) {
            ht.put(i, i);
        }
        Instant end = Instant.now();
        for (int i = 0; i < SAMPLE_NUM; i++) {
            ht.get(i);
        }
        Instant end2 = Instant.now();

        System.out.println("执行添加时间：" + Duration.between(start, end).toMillis() + "毫秒");
        System.out.println("执行读取时间：" + Duration.between(end, end2).toMillis() + "毫秒");
    }

}
