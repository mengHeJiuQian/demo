package number.CumulativeNumber;

/**
 * 创建人：yang.liu
 * 创建时间：2019/8/11 21:44
 * 版本：1.0
 * 内容描述：求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 * 解决思路：利用短路运算，当if条件判断
 */
public class CumulativeNumber {

    public static void main(String[] args) {
        System.out.println(sumSolution(100));
    }

    public static int sumSolution(int n) {
        int curN = n;
        int curRes = 0;
        boolean b = (curN > 0) && ((curRes = curN + sumSolution(--curN)) > 0);
        return curRes;
    }

}
