package uniqueCoupon;

import org.apache.commons.lang.RandomStringUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @Description TODO
 * @Author shuyun
 * @Date 2018/11/15 10:38
 */
public class Main {

    public static final int ANTA_COUPON_LEN = 13;
    // private final static String ANTA_LETTERS = "QWERTYUPASDFGHJKLXCVBNM";
    private final static String ANTA_LETTERS = "ABCDEFGHJKLMNPQRSTUVWXY";

    public static void main(String[] args) throws InterruptedException {
        // HashSet<String> uniqueCoupon = new HashSet(20000);
        List<String> uniqueCoupon = new ArrayList<>(15000);
        int num = 0;
        String sec = null;
        for (int i = 1; i <= 10000; i++) {
            String seconds = getSeconds();
            if (seconds.equals(sec)) {
                num++;
            } else {
                sec = seconds;
                num = 0;
            }
            String coupon = createAntaCoupon(sec, num);
            if (uniqueCoupon.contains(coupon)) {
                System.out.println("新生成的重复券码：" + coupon);
            } else {
                uniqueCoupon.add(coupon);
            }
        }
        System.out.println(uniqueCoupon.size());
        System.out.println(System.currentTimeMillis());
        uniqueCoupon.stream().forEach(System.out::println);
    }

    public static String createAntaCoupon(String key, long val) {
        StringBuffer sb = new StringBuffer();
        sb.append(key).reverse();

        // 按需求优惠券由12位数字和一个大写字符组成
        char one = ANTA_LETTERS.charAt((int)val % ANTA_LETTERS.length());
        val = val / ANTA_LETTERS.length();
        /**
         * 对于同一秒内创建的第n个优惠券，n需先对字母的数量23取余，再用n除以23。得到的结果如下
         * Q1, W1, E1, ...
         * Q2, W2, E2, ...
         * Q999, W999, E999 ...
         *
         * Q1000会造成生成的优惠券长度为 9 + 5 = 14（个）字符串长度。
         * 这里是判断第一次出现999的情况，没有判断最后一次出现999的
         */
        while (val == 999 && getSeconds().equals(key)) { }

        int currentLen = sb.length();
        for (int i = 0; i < ANTA_COUPON_LEN - (val+"").length() - 1 - currentLen; i++) {
            sb.append(0);
        }
        sb.append(val).append(one); // 字母放在最后一位
        return sb.toString();
    }
    public static String getSeconds() {
        long millis = System.currentTimeMillis();
        return (millis + "").substring(1, 10);
    }

}
