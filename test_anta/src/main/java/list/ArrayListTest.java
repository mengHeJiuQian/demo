package list;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

/**
 * 创建人：yang.liu
 * 创建时间：2019/7/18 17:01
 * 版本：1.0
 * 内容描述：测试ArrayList的一些细节特性
 */
public class ArrayListTest {

    /**
     * 测试ArrayList能不能添加null元素
     */
    @Test
    public void testAddNull() {
        ArrayList list = new ArrayList();
        System.out.println(list.size());
        list.add(null);
        System.out.println(list.size());
        list.add(null);
        System.out.println(list.size());
    }
}
