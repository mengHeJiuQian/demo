package stack;

import java.util.ArrayList;

/**
 * 创建人：yang.liu
 * 创建时间：2019/8/2 20:21
 * 版本：1.0
 * 内容描述：[编程题]栈的压入、弹出序列
 *
 * 链接：https://www.nowcoder.com/questionTerminal/d77d11405cc7470d82554cb392585106
 * 来源：牛客网
 *
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。假设压入栈的所有数字均不相等。
 * 例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。
 * （注意：这两个序列的长度是相等的）
 */
public class StackPushOrderIsPopOrder {

    public static void main(String[] args) {
        int[] pushOrder = {1, 2, 3, 4, 5};
        int[] popOrder = {4, 5, 3, 2, 1};
        int[] popOrderError = {4, 3, 5, 1, 2};
        System.out.println(isPopOrder(pushOrder, popOrderError));
        assert isPopOrder(pushOrder, popOrderError);
    }

    public static boolean isPopOrder(int [] pushA,int [] popA) {
        ArrayList<Integer> tmpS = new ArrayList();
        //int tmpSize = 0;
        int popLen = 0;
        for (int i = 0; i < pushA.length; i++) {
            tmpS.add(pushA[i]);
            //tmpSize++;
            while (!tmpS.isEmpty() && popLen < popA.length) {
                if (popA[popLen] == tmpS.get(tmpS.size() - 1)) {
                    tmpS.remove(tmpS.size() - 1);
                    popLen++;
                } else {
                    break;
                }
            }
        }
        if (tmpS.size() == 0) {
            return true;
        } else {
            return false;
        }
    }
}
