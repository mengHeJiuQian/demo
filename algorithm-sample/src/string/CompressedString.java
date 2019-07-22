package string;

/**
 * 创建人：yang.liu
 * 创建时间：2019/7/23 0:19
 * 版本：1.0
 * 内容描述：字符串压缩，给定string="aaabbbcccaa"，压缩a3b3c3a2。
 */
public class CompressedString {

    public static void main(String[] args) {
        System.out.println(compressed("aaabbbcccd"));
    }

    public static String compressed(String target) {
        int len = target.length();
        int i = 0; //字符串中字符数据的索引
        int chNum = 0; // 记录字符连续的个数
        char ch = target.charAt(0); // 索引指向的字符
        StringBuilder res = new StringBuilder();
        while (i < len) {
            if (ch == target.charAt(i)) {
                chNum++;
            } else {
                res.append(target.charAt(i - 1)).append(chNum);
                chNum = 1;
                ch = target.charAt(i);
            }
            i++;
        }
        res.append(target.charAt(i - 1)).append(chNum);
        return res.toString();
    }

}
