package utils.string;

import org.apache.commons.lang.StringUtils;
import utils.datetime.DateUtil;

import java.util.Date;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 功能描述：
 * String字符串处理工具类.
 *
 * @version V1.0
 * @classname: com.metlife.wechat.common.utils.StringTool.java
 * @copyright Powered By wechat
 * @author: somnus
 * @date: 2019-10-20 18:03:22
 */
public class StringTool extends StringUtils {

    /**
     * trim.
     */
    public static String trimSpaceAndNull(String value) {
        if (value == null) {
            return "";
        }
        return StringUtils.deleteWhitespace(value);
    }

    /**
     * 16进制转字符串(无需Unicode编码).
     * @param hexStr 16进制字符串
     * @return
     */
    public static String hexStr2Str(String hexStr) {
        String str = "0123456789ABCDEF";
        char[] hexs = hexStr.toCharArray();
        byte[] bytes = new byte[hexStr.length() / 2];
        int n;
        for (int i = 0; i < bytes.length; i++) {
            n = str.indexOf(hexs[2 * i]) * 16;
            n += str.indexOf(hexs[2 * i + 1]);
            bytes[i] = (byte) (n & 0xff);
        }
        return new String(bytes);
    }

    /**
     * 字符串转换成为16进制(无需Unicode编码).
     * @param str 字符串内容
     * @return
     */
    public static String str2HexStr(String str) {
        char[] chars = "0123456789ABCDEF".toCharArray();
        StringBuilder sb = new StringBuilder("");
        byte[] bs = str.getBytes();
        int bit;
        for (int i = 0; i < bs.length; i++) {
            bit = (bs[i] & 0x0f0) >> 4;
            sb.append(chars[bit]);
            bit = bs[i] & 0x0f;
            sb.append(chars[bit]);
        }
        return sb.toString().trim();
    }

    /**
     * isNullOrEmpty.
     */
    public static boolean isNullOrEmpty(String value) {
        if (isBlank(value) || "null".equalsIgnoreCase(value)) {
            return true;
        }

        return false;
    }

    /**
     * String左对齐.
     * @param src 要对齐的字符串
     * @param len 总长度
     * @param ch 不足，补空位的字符
     */
    public static String padLeft(String src, int len, char ch) {
        int diff = len - src.length();
        if (diff <= 0) {
            return src;
        }

        char[] charr = new char[len];
        System.arraycopy(src.toCharArray(), 0, charr, 0, src.length());
        for (int i = src.length(); i < len; i++) {
            charr[i] = ch;
        }
        return new String(charr);
    }

    /**
     * String右对齐.
     * @param src 要对齐的字符串
     * @param len 总长度
     * @param ch 不足，补空位的字符
     */
    public static String padRight(String src, int len, char ch) {
        int diff = len - src.length();
        if (diff <= 0) {
            return src;
        }

        char[] charr = new char[len];
        System.arraycopy(src.toCharArray(), 0, charr, diff, src.length());
        for (int i = 0; i < diff; i++) {
            charr[i] = ch;
        }
        return new String(charr);
    }

    /**
     * 创建随机串.
     * @param length 随机串长度
     * @return
     */
    public static String createNoncestr(int length) {
        String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < length; i++) {
            Random rd = new Random();
            res.append(chars.charAt(rd.nextInt(chars.length() - 1)));
        }
        return res.toString();
    }

    /**
     * 创建指定位数的随机数.
     * @param num 位数
     * @return String
     */
    public static String getRandom(int num) {
        // 定义变长字符串
        StringBuilder str = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < num; i++) {
            str.append(random.nextInt(10));
        }
        return str.toString();
    }

    /**
     * 验证邮箱地址.
     * @param mailAddress 邮箱地址
     * @return
     */
    public static boolean mailValid(String mailAddress) {
        //电子邮件
        String check = "^\\s*\\w+(?:\\.?[\\w-]+)*@[a-zA-Z0-9]+(?:[-.][a-zA-Z0-9]+)*\\.[a-zA-Z]+\\s*$";
        Pattern regex = Pattern.compile(check);
        Matcher matcher = regex.matcher(mailAddress);
        return matcher.matches();
    }

    /**
     * 字符串转100倍的int.
     * 例：输入："100.89"，输出：10089
     * @param amount 金额
     * @return
     */
    public static int stringTo100TimesInt(String amount) {
        try {
            if (StringTool.isNullOrEmpty(amount)) {
                return 0;
            }
            int length = StringUtils.substringAfter(amount, ".").length();
            if (length == 2) {
                amount = amount.replace(".", "");
                return Integer.valueOf(amount);
            } else if (length == 1) {
                amount = amount + "0";
                amount = amount.replace(".", "");
                return Integer.valueOf(amount);
            } else if (length == 0) {
                return (Integer.valueOf(amount) * 100);
            } else {
                return -1;
            }
        } catch (Exception e) {
            return -1;
        }
    }


    /**
     * 功能描述:
     * 校验时间格式（针对yyyy-MM-dd字符串格式）.
     *
     * @methodname: checkTime
     * @params: [time：字符串时间]
     * @returns: boolean
     * @author: somnus
     * @date: 2019-10-10 23:52:27
     */
    public static boolean checkTime(String time) {
        if (StringUtils.isBlank(time)) {
            return false;
        }
        return TimeCheckEnum.yyyy_MM_dd.checkTime(time);
    }

    /**
     * 功能描述:
     * 校验时间格式（针对yyyyMMdd字符串格式）.
     *
     * @methodname: checkTime
     * @params: [time：字符串时间]
     * @returns: boolean
     * @author: somnus
     * @date: 2019-10-10 23:52:27
     */
    public static boolean checkTimeOfyyyyMMdd(String time) {
        if (StringUtils.isBlank(time)) {
            return false;
        }
        return TimeCheckEnum.yyyyMMdd.checkTime(time);
    }


    private enum TimeCheckEnum {
        yyyy_MM_dd {
            @Override
            boolean checkTime(String time) {
                String regex = "[0-9]{4}-[0-9]{2}-[0-9]{2}";
                return doCheck(time, regex, DateUtil.DATE_YYYY_MM_DD);
            }
        },
        yyyyMMdd {
            @Override
            boolean checkTime(String time) {
                String regex = "[0-9]{4}[0-9]{2}[0-9]{2}";
                return doCheck(time, regex, DateUtil.DATE_YYYYMMDD);
            }
        };



        abstract boolean checkTime(String time);

        protected boolean doCheck(String text, String regex, String format) {
            //校验时间格式
            if (match(text, regex)) {
                //校验时间有效性
                return validTime(text, format);
            }
            return false;
        }

        /**
         * 功能描述:
         * 校验时间格式.
         *
         * @methodname: match
         * @params: [text：内容, regex：正则匹配表达式]
         * @returns: boolean
         * @author: somnus
         * @date: 2019-10-11 16:21:07
         */
        protected boolean match(String text, String regex) {
            Pattern pattern = Pattern.compile(regex);
            return pattern.matcher(text).matches();
        }

        /**
         * 功能描述:
         * 校验时间有效性.
         *
         * @methodname: validTime
         * @params: [text：内容, format：格式化style]
         * @returns: boolean
         * @author: somnus
         * @date: 2019-10-11 16:21:15
         */
        protected boolean validTime(String text, String format) {
            Date date = DateUtil.string2date(text, format);
            return null != date;
        }
    }


    /**
     * 功能描述:
     * 获取随机Ip地址.
     *
     * @methodname: getRandomIp
     * @params: []
     * @returns: java.lang.String
     * @author: somnus
     * @date: 2019-11-26 15:06:24
     */
    public static String getRandomIp() {
        // 需要排除监控的ip范围
        //36.56.0.0-36.63.255.255; 61.232.0.0-61.237.255.255; 106.80.0.0-106.95.255.255; 121.76.0.0-121.77.255.255;
        //123.232.0.0-123.235.255.255; 139.196.0.0-139.215.255.255; 171.8.0.0-171.15.255.255; 182.80.0.0-182.92.255.255;
        // 210.25.0.0-210.47.255.255; 222.16.0.0-222.95.255.255
        int[][] range = {{607649792,608174079},{1038614528,1039007743},{1783627776,1784676351},
            {2035023872,2035154943},{2078801920,2079064063},{-1950089216,-1948778497},
            {-1425539072,-1425014785},{-1236271104,-1235419137},{-770113536,-768606209},{-569376768,-564133889},
        };
        Random rdint = new Random();
        int index = rdint.nextInt(10);
        return num2ip(range[index][0] + new Random().nextInt(range[index][1] - range[index][0]));
    }

    /**
     * 功能描述:
     * 将十进制转换成IP地址.
     *
     * @methodname: num2ip
     * @params: [ip]
     * @returns: java.lang.String
     * @author: somnus
     * @date: 2019-11-26 15:11:19
     */
    private static String num2ip(int ip) {
        int[] b = new int[4];
        b[0] = (ip >> 24) & 0xff;
        b[1] = (ip >> 16) & 0xff;
        b[2] = (ip >> 8) & 0xff;
        b[3] = ip & 0xff;
        StringBuilder x = new StringBuilder();
        x.append(Integer.toString(b[0])).append(".").append(Integer.toString(b[1])).append(".")
                .append(Integer.toString(b[2])).append(".").append(Integer.toString(b[3]));
        return x.toString();
    }

    /**
     *null或空串转'无'.
     * @return
     */
    public static String toEmpty(String str) {
        return isNullOrEmpty(str) ? "无" : str;
    }
}