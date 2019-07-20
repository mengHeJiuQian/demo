package map;

import org.junit.jupiter.api.Test;

import java.util.Hashtable;

/**
 * 创建人：yang.liu
 * 创建时间：2019/7/19 15:40
 * 版本：1.0
 * 内容描述：源码阅读
 */
public class HashtableTest {

    @Test
    public void testBucketIndex() {
        int hash = "a".hashCode();
//        int index = (hash & 0x7FFFFFFF) % tab.length;
        int index = hash & 0x7FFFFFFF;

        System.out.println( 0x7FFFFFFF);
        System.out.println(index);
    }

    @Test
    public void testRemove() {
        Hashtable table = new Hashtable();
        table.put("a", 1);
        table.put("b", 1);
        System.out.println(table.size());
        table.remove("a");
    }
}
