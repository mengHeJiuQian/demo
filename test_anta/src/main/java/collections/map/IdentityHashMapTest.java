package collections.map;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.IdentityHashMap;

/**
 * 创建人：yang.liu
 * 创建时间：2019/8/7 15:40
 * 版本：1.0
 * 内容描述：IdentityHashMap主要特性是通过==判断key值是否重复。
 */
public class IdentityHashMapTest {

    @Test
    public void testUseDemo() {
        IdentityHashMap<String, String> ihm = new IdentityHashMap<>();
        ihm.put("yangliu", "一年经验");
        ihm.put(new String("yangliu"), "一年经验");
        System.out.println(ihm.size());

        HashMap<String, String> hm = new HashMap<>();
        hm.put("yangliu", "一年经验");
        hm.put(new String("yangliu"), "一年经验");
        System.out.println(hm.size());
    }



    @Test
    public void testIdentityHashMap_hash() {
        int h = System.identityHashCode("yangliu");
        // Multiply by -127, and left-shift to use least bit as part of hash
        int hash = ((h << 1) - (h << 8)) & (64 - 1);

        int h1 = h << 1;
        int h2 = h << 8;
        System.out.println(h1);
        System.out.println(h2);
        System.out.println(hash);
    }
}
