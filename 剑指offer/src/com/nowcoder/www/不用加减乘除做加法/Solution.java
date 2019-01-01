package com.nowcoder.www.不用加减乘除做加法;

/**
 * describe:
 *
 * @author 梦合九千
 * @date 2018/12/31 16:15
 */
public class Solution {

    public int Add(int num1,int num2) {
        int sum;
        int mark;
        do {
            // 1. 计算每一位上的结果   91 + 19 计算的结果是个位是0，（暂不不考虑个位进位），十位上是0，（暂不不考虑个位进位）
            sum = num1 ^ num2;
            // 2. 计算进位，91 + 19 计算的结果是个位上进个1，十位上是1；十位上进1，百位上是1
            // 把1和2都用二进制加法来思考
            mark = (num1 & num2) << 1;
            num1 = sum;
            num2 = mark;
        } while (0 != num2);
        return num1;
    }

}
