package string;

import org.apache.commons.lang.RandomStringUtils;

/**
 * @Description TODO
 * @Author shuyun
 * @Date 2018/11/13 14:14
 */
public class TestString {

    public static void main(String[] args) {
        Object obj = "大货";
        System.out.println(String.valueOf(obj));
        System.out.println((String) obj);

        String str = "123";
        System.out.println(new String(str.getBytes()));

        int flag = 1;
        if (flag++ % 2 == 0) {
            System.out.println("抛出异常");
        }
        long l = 12;
        System.out.println(String.valueOf(l));

    }

}
