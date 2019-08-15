package uniqueCoupon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description TODO
 * @Author shuyun
 * @Date 2018/11/16 17:22
 */
public class Test {

    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis()); //时间戳是十三位数

        long zero = 0L;
        for (int i = 0; i < 1500; i++) {
            System.out.println((long) (Math.random() * 30 + 1));
        }

        String paramValue = "%%%";
        /*String inStr = Arrays.stream(paramValue.split(","))
                .map(s -> String.format("'%s'", s))
                .reduce((sum, s) -> sum.concat(",").concat(s))
                .get();
        System.out.println(String.format("%s in (%s)", "product_id", inStr));*/

        paramValue = paramValue.replace("%", "\\\\%");
        String singleSelect = String.format("%s like '%%%s%%'", "product_id", paramValue);
        System.out.println(singleSelect);
        System.out.println(System.currentTimeMillis());

        Long a = 12345256L;
        System.out.println(String.valueOf(a.toString()));


    }

}
