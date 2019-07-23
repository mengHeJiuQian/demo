package test;

/**
 * 创建人：yang.liu
 * 创建时间：2019/7/23 20:28
 * 版本：1.0
 * 内容描述：压缩字符串
 */
public class ProsessedString {

    public static void main(String[] args) {
        System.out.println(compressed("aaabbbccd"));
        System.out.println(compressed("yangliu"));
        System.out.println(compress("yangliu"));
    }

    public static String compressed(String target) {
        if (null == target || target.length() == 0) {
            return "";
        }
        StringBuilder res = new StringBuilder();
        char ch = target.charAt(0);
        int chNum = 0;
        int len = target.length();
        int index = 0;
        while (index < len) {
            if (ch == target.charAt(index)) {
                chNum++;
            } else {
                res.append(ch).append(chNum);
                ch = target.charAt(index);
                chNum = 1;
            }
            index++;
        }
        res.append(ch).append(chNum);
        return res.toString();
    }

    public static String compress(String str) {
        if (null == str || str.length() == 0) {
            return "";
        }
        StringBuilder res = new StringBuilder();
        char ch = str.charAt(0);
        int chNum = 0;
        int index = 0;
        int len = str.length();
        while (index < len) {
            if (ch == str.charAt(index)) {
                chNum++;
            } else {
                res.append(ch).append(chNum);
                ch = str.charAt(index);
                chNum = 1;
            }
            index++;
        }
        res.append(ch).append(chNum);
        return res.toString();

    }
}
