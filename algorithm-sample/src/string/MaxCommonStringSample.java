package string;

/**
 * 内容描述：求解最大公共子字符串问题
 *          请设计函数，返回指定存在于两个字符串中最大的子字符串（如果存在多个相同长度的，只返回第一个）
 * 创建人：yang.liu
 * 创建时间：2019/7/4 12:53
 * 版本：1.0
 */
public class MaxCommonStringSample {

    public static String getMaxCommonString(String str1, String str2) {
        if (null == str1 && null == str2) {
            return "";
        }
        char[] c1 = str1.toCharArray();
        char[] c2 = str2.toCharArray();
        int[][] comp = new int[c1.length][c2.length];

        //max记录相同子串的最大长度
        // m记录最长公共字符串的最后位置，用来找最大字符串
        // n记录最长公共字符串的开始位置，用来找最大字符串
        /**
         * str1 = "acdedeg";
         * str2 = "abcdefg";
         * 比较结果是最大长度的公共字符串是3
         *    a b c d e f g
         *  a 1 0 0 0 0 0 0
         *  c 0 0 1 0 0 0 0
         *  d 0 0 0 2 0 0 0
         *  e 0 0 0 0 3 0 0
         *  d 0 0 0 1 0 0 0
         *  e 0 0 0 0 2 0 0
         *  g 0 0 0 0 0 0 1
         */
        int max = 0, m = -1, n = -1;
        for (int i = 0; i < c1.length; i++) {
            for (int j = 0; j < c2.length; j++) {
                if (c1[i] != c2[j]) {
                    // 矩阵位置不同字符，值设为1
                    comp[i][j] = 0;
                } else {
                    // 矩阵位置相同字符，值为左上角的值加1.
                    if (i == 0 || j == 0) {
                        comp[i][j] = 1;
                    } else {
                        comp[i][j] = comp[i - 1][j - 1] + 1;
                    }

                    if (comp[i][j] > max) {
                        max = comp[i][j];
                        m = i;
                        n = j;
                    }
                }

            }
        }

        StringBuffer commonStr = new StringBuffer();
        while (m >=0 && n >= 0 && comp[m][n] > 0) {
            commonStr.append(c1[m]);
            m--;
            n--;
        }
        return commonStr.reverse().toString();
    }

    public static void main(String[] args) {
        String str1 = "aaabbbdccc";
        String str2 = "ebcbbbgccc";

        String s = getMaxCommonString(str1, str2);
        System.out.println(s);

    }

}
