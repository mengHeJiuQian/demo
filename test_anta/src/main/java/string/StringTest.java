package string;

import org.junit.jupiter.api.Test;

/**
 * describe:
 *
 * @author 梦合九千
 * @date 2019/4/14 21:01
 */
public class StringTest {

    public static void main(String[] args) {
        printStr("yangliu");
    }

    public static void printStr(Object str) {
        System.out.println(str.toString());
    }

    @Test
    public void testStringEqualsInteger() {
        Integer i = 10;
        String s = "10";
        System.out.println(s.equals(i.toString()));
    }

    @Test
    public void testStringFormat() {
        Integer idCardTypeId = 3;
        String idCardTypeIdString = String.format("%s%s", 0, idCardTypeId);
        System.out.println(idCardTypeIdString);
    }

}
