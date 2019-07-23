package test;

/**
 * 创建人：yang.liu
 * 创建时间：2019/7/23 20:15
 * 版本：1.0
 * 内容描述：
 */
public class StringATransferToStringB {

    public static void main(String[] args) {
        System.out.println(canTransfer("yangliu", "liuyang"));
        System.out.println(canTransfer("Gog", "god"));
    }

    public static boolean canTransfer(String aStr, String otherStr) {
        if (aStr.length() != otherStr.length()) {
            return false;
        }
        char[] a_chars = aStr.toCharArray();
        char[] o_chars = otherStr.toCharArray();

        int[] ASCII = new int[128];
        for (int i = 0; i < a_chars.length; i++) {
            ASCII[a_chars[i]]++;
        }

        for (int j = 0; j < o_chars.length; j++) {
            if (ASCII[o_chars[j]] == 0) {
                return false;
            }
            ASCII[o_chars[j]]--;
        }
        return true;
    }
}
