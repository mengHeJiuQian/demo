package uniqueCoupon;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.HashSet;

/**
 * @Author: yu.yue
 * @Date: Created in 2018/6/11 15:28
 * @Modified By:
 * @Description:
 */
public class RandomLetterUtil {

    // ANTA用户的优惠券长度
    public static final int ANTA_COUPON_LEN = 13;
    // private final static String letters = "1234567890QWERTYUPASDFGOHIJKLZXCVBNM";
    private final static String letters = "3456789QWERTYUPASDFGHJKLXCVBNM";
    private final static String ANTA_LETTERS = "QWERTYUPASDFGHJKLXCVBNM";
    private final static String[] charList = letters.split("");
    private final static String[] char23 = ANTA_LETTERS.split("");

    /**
     * 把一个数字用23个大写字符表示
     * @param num
     * @return
     */
    public static String base23UpperCase(Long num){
        int length = char23.length;
        StringBuffer sb = new StringBuffer();
        while(num!=0){
            int index = (int)(num%length);
            num = num / length;
            sb.append(char23[index]);
        }
        return sb.toString();
    }

    public static String transferNum(Long num){
        int length = charList.length;
        StringBuffer sb = new StringBuffer();
        while(num!=0){
            int index = (int)(num%length);
            num = num/length;
            sb.append(charList[index]);
        }
        return sb.toString();
    }

    public static String randomLetter(int length){
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<length;i++){
            sb.append(charList[(int)(Math.random()*30)]);
        }
        return sb.toString();
    }

    /**
     * 生成唯一优惠券码。
     * @param length 要生成优惠券码的长度
     * @param cur 通过这个long型的参数来生成优惠券码，所以要保证cur的唯一性。
     * @return
     */
    public static String createCoupon(int length, long cur){
        StringBuffer sb = new StringBuffer();
        sb.append(transferNum(cur));
        sb.append(randomLetter(length-sb.length()));
        return sb.toString();
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
        // while (val == 999 && getSeconds().equals(key)) { }

        int currentLen = sb.length();
        for (int i = 0; i < ANTA_COUPON_LEN - (val+"").length() - 1 - currentLen; i++) {
            sb.append(0);
        }
        sb.append(val).append(one); // 字母放在最后一位
        return sb.toString();
    }

    /**
     * 1.取得当前的秒级时间戳 1542252842719 -> 1542252842
     * 2.时间戳去掉开头的15 得到42252842这一截，0000 0000-9999 9999 这段时间是3.17年
     * 3.每三年换一个头字母
     */
    public static String getSeconds() {
        long millis = System.currentTimeMillis();
        return (millis + "").substring(1, 10);
    }




    /**
     * 在解决优惠券码的唯一生成后，这个main方法就不能测试createCoupon()了。*/
    public static void main(String[] args){
//        // 测试唯一的coupon
//        HashSet uniqueCoupon = new HashSet(100);
//        for (int i = 10001; i <= 90000; i++) {
//            String s = String.valueOf(i);
//            String coupon = s + s.substring(s.length()-1);
//            coupon = base23UpperCase(Long.valueOf(coupon));
//            System.out.println("新生成的：" + coupon);//GHGC8DAR5HYSQ
//            uniqueCoupon.add(coupon);
//        }
//        System.out.println(uniqueCoupon.size());
        StringBuffer coupon = new StringBuffer("YRYS");
        String seqStr = String.valueOf(1);
        System.out.println(coupon.length());
        System.out.println(seqStr.length());

        int repeatZeroTimes = 13 - coupon.length() - seqStr.length();
        for (int i = 0; i < repeatZeroTimes; i++) {
            coupon.append(0);
        }
        coupon.append(seqStr);
        System.out.println(coupon.toString());

    }
    
    
    @Test
    public void generatePrefix() {
//        String ss = "12345";
//        System.out.println(ss.substring(ss.length() - 2, ss.length()-1));
        //System.out.println(ss += ss.substring(String.valueOf(ss).length()-2));
        for (int i = 10000; i < 90000; i++) {
            String s = String.valueOf(i);
            System.out.print(s += s.substring(String.valueOf(i).length()-2) + "    ");
            if (i % 10 == 0) {
                System.out.println();
            }
        }
    }

    @Test
    public void testTimestamp() throws ParseException {
        String date = "2019-03-21 23:59:59";

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date timeout = sdf.parse(date);

        long survivalSeconds = timeout.getTime() / 1000 - Instant.now().getEpochSecond();
        System.out.println("asdf" + survivalSeconds);

        System.out.println((timeout.getTime() - new Date().getTime()) / 1000);

    }



}
