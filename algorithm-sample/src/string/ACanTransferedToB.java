package string;

import java.util.Arrays;

/**
 * 创建人：yang.liu
 * 创建时间：2019/7/22 21:57
 * 版本：1.0
 * 内容描述：给定两个字符串，请编写程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
 */
public class ACanTransferedToB {

    public static void main(String[] args) {

        System.out.println(permutation("yangliu", "liuyang"));
        System.out.println(permutation("abc", "aad"));
        System.out.println(permutation("Dog", "god"));

        System.out.println(permutation2("yangliu", "liuyang"));
        System.out.println(permutation2("abc", "aad"));
    }

    /**
     * 判断两个字符串组成字符和字符个数是否相同
     *
     * @param s
     * @param t
     * @return
     */
    public static boolean permutation(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] s_letter = new int[256];

        for (int i = 0; i < s.length(); i++) {
            s_letter[s.charAt(i)]++;
        }

        for (int i = 0; i < t.length(); i++) {
            s_letter[t.charAt(i)]--;
            if (s_letter[t.charAt(i)] < 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 通过已有的类库实现
     */
    public static boolean permutation2(String s, String t) {
        char[] s_chars = s.toCharArray();
        Arrays.sort(s_chars);
        String s1 = String.valueOf(s_chars);

        char[] t_chars = t.toCharArray();
        Arrays.sort(t_chars);
        String t2 = String.valueOf(t_chars);

        return s1.equals(t2);
    }

}
