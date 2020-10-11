package string;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * describe:
 *
 * @author 梦合九千
 * @date 2019/4/14 21:01
 */
public class StringTest {

    @Test
    public void testPrint() {
        String[] strArr = new String[]{null, null, null};
        String reason = StringUtils.join(strArr , ":");
        System.out.println(reason);

        List<String> list = new ArrayList<String>(){{
            add(null);
            add(null);
            add(null);
        }};
        String reason2 = StringUtils.join(list , ":");
        System.out.println(reason2);


        String result = list.stream().collect(Collectors.joining(""));
        System.out.println(result);

        String join = String.join(":", list);
        System.out.println(join);

        System.out.println("night mode");
        /* \u000d System.out.println("night mode"); */

        Set<String> set = new HashSet<String>() {{
            add("wmyskxz");
            add("is");
            add("awesome");
            add("!");
        }};
        System.out.println(set);
        // Arrays.asList();

        int[] arr = {1,3,4,5,6, 8};
        int pos = Arrays.binarySearch(arr, 7);
        System.out.println("Element has to be inserted at: " + pos);
        System.out.println("Element has to be inserted at: " + ~pos);

        // 快速判断素数
        boolean probablePrime = BigInteger.valueOf(1235).isProbablePrime(1);
        System.out.println(probablePrime);


    }

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
