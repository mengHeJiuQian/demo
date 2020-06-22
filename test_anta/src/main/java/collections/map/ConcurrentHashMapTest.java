package collections.map;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 创建人：yang.liu
 * 创建时间：2019/7/19 16:16
 * 版本：1.0
 * 内容描述：源码阅读
 */
public class ConcurrentHashMapTest {

    @Test
    public void test_MAX_RESIZERS() {
        /*int RESIZE_STAMP_BITS = 15;
        int MAX_RESIZERS = (1 << (32 - RESIZE_STAMP_BITS)) - 1;
        System.out.println(MAX_RESIZERS);*/

        int initialCapacity = 0;
        int iniCap = initialCapacity + (initialCapacity >>> 1) + 1;
        System.out.println(iniCap);

        System.out.println(Integer.MIN_VALUE  + " " + Integer.MAX_VALUE);
        int HASH_BITS = 0x7fffffff;
        int h = 2147483647;
        int hash = (h ^ (h >>> 16)) & HASH_BITS;
        System.out.println(hash);
    }

    @Test
    public void testConcurrentHashMap() {
        ConcurrentHashMap<String, String> chm = new ConcurrentHashMap<>();
        chm.put("name", "liuyang");
    }

}
