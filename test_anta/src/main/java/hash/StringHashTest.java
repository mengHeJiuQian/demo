package hash;

import org.junit.jupiter.api.Test;

/**
 * 创建人：yang.liu
 * 创建时间：2019/8/2 12:45
 * 版本：1.0
 * 内容描述：
 */
public class StringHashTest {

    /**
     * Time31算法
     *
     * hash(i) = hash(i-1)*31 + str[i]
     */
    @Test
    public void testStringHash() {
        System.out.println("aa".hashCode());
        System.out.println("ab".hashCode());
        System.out.println("AA".hashCode());
        System.out.println("AB".hashCode());
    }

}
