package sort;

import java.util.Arrays;

/**
 * 题目描述：
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 *
 * @author 梦合九千
 * @date 2018/12/28 21:54
 */
public class Solution {

    public void reOrderArray(int [] array) {
        if (null == array || 0 == array.length) {
            return ;
        }
        int[] temp = new int[array.length];
        int odd = 0;
        int even = array.length - 1;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] % 2 == 0) {
                //array[]
            }
        }

    }

    public static void main(String[] args) {
        Solution s = new Solution();

        int[] arr1 = {1,2,3,4,5,6,7,8,9,10};
        int[] arr2 = {1,2,3,4,5,6,7};
        /**
         *  1 2 3 4 5 6 7
         *  1
         */
        s.reOrderArray(arr2);
        System.out.println(Arrays.toString(arr2));

    }

}
