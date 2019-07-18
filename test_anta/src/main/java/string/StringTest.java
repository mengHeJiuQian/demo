package string;

import org.junit.jupiter.api.Test;

/**
 * describe:
 *
 * @author 梦合九千
 * @date 2019/4/14 21:01
 */
public class StringTest {

    @Test
    public void testStringEqualsInteger() {
        Integer i = 10;
        String s = "10";
        System.out.println(s.equals(i.toString()));
    }
}
