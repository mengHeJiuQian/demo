package collections.list;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 创建人：yang.liu
 * 创建时间：2019/7/18 18:45
 * 版本：1.0
 * 内容描述：测试 LinkedList 的一些细节特性
 */
public class LinkedListTest {

    /**
     * 测试 LinkedList 能不能添加null元素
     */
    @Test
    public void testAddNull() {
        LinkedList list = new LinkedList();
        System.out.println(list.size());
        list.add(null);
        System.out.println(list.size());
        list.add(null);
        System.out.println(list.size());

        list.remove(null);
        System.out.println(list.size());
    }
}
