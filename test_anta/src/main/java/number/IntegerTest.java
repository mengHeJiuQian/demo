package number;

import org.junit.jupiter.api.Test;

/**
 * 创建人：yang.liu
 * 创建时间：2019/7/18 0:12
 * 版本：1.0
 * 内容描述：测试一些Integer的相关特性
 */
public class IntegerTest {

    @Test
    public void testCache() {
        Integer i1 = 127;
        Integer i2 = 127;
        System.out.println(i1 == i2);

        Integer i3 = 128;
        Integer i4 = 128;
        System.out.println(i3 == i4);
    }
}
