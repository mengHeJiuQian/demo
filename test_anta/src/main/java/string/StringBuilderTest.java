package string;

import org.junit.Test;

/**
 * @author yang.liu
 * @createtime 2020/10/10 17:01
 * @description
 */
public class StringBuilderTest {

    @Test
    public void testToString() {
        StringBuilder sb = new StringBuilder(1024);
        String s = sb.toString();
        System.out.println(s);
    }
}
