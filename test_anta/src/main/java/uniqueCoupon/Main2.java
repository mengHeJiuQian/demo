package uniqueCoupon;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @Description TODO
 * @Author shuyun
 * @Date 2018/11/20 12:03
 */
public class Main2 {
    public static final int ANTA_COUPON_LEN = 13;
    private final static String ANTA_LETTERS = "QWERTYUPASDFGHJKLXCVBNM";

    public static void main(String[] args) {
        String key = getSeconds();
        long val = 23000;
        String antaCoupon = t(key, Long.valueOf(val));
        System.out.println(antaCoupon);
    }

    public static String t(String key, long version) {
        if (version > 23000) {
            version = version - 23000;
            key = String.valueOf(Long.valueOf(key) + 1L);
            return t(key, version);
        } else {
            return createAntaCoupon(key, version);
        }
    }

    public static String getSeconds() {
        long millis = System.currentTimeMillis();
        return (millis + "").substring(1, 10);
    }

    public static String createAntaCoupon(String key, long val) {
        StringBuffer sb = new StringBuffer();
        sb.append(key).reverse();

        // anta优惠券由12位数字和一个大写字符组成
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

}
