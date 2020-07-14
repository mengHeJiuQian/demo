package string;

import org.apache.commons.lang.StringUtils;
import org.junit.jupiter.api.Test;

/**
 * describe:
 *
 * @author 梦合九千
 * @date 2019/4/14 21:01
 */
public class StringTest {

    @Test
    public void testSubString() {
        System.out.println("01".substring(0, 2));
        System.out.println("011".substring(0, 2));
    }

    @Test
    public void testEquals() {
        System.out.println("female".equals("female") ? "male" : "female");
    }

    @Test
    public void testBlank() {
        String testStr = null;
        if (StringUtils.isBlank(testStr)) {
            System.out.println("空");
        } else {
            System.out.println("非空");
        }
    }

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
