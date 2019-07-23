package array.sort.quicksort;

import java.util.Arrays;

/**
 * 创建人：yang.liu
 * 创建时间：2019/7/23 16:27
 * 版本：1.0
 * 内容描述：对于一个数组，给定一个数组中的元素，将数组中比该数小的放左边，比该数大的放右边。
 * 通过快排中的分区思想来做。
 */
public class DutchFlag {

    public static void main(String[] args) {
        int[] arr = {7, 2,1,8,5, 7, 3,7,9,4,6, 7};
        System.out.println("执行前：" + Arrays.toString(arr));
        solution(arr, 7);
        System.out.println("执行后：" + Arrays.toString(arr));
    }

    /**
     * 7, 2, 1, 8, 5, 7, 3, 7, 9, 4, 6, 7， 初始状态是left和cur指向第一个元素位置，right指向最后一个元素的位置。
     * [left,cur)之间是维护的是和给定数字7相等的数，cur是每次需要判断是比7大还是小，还是相等。
     */
    public static void solution(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return;
        }
        int left = 0;
        int cur = 0;
        int right = arr.length - 1;
        while (cur <= right) {
            if (arr[cur] < target) { // cur比目标数小，把这个小点儿的数换到维护区间的最左边，也就是left的位置。
                if (cur != left) { //如果当前没有维护和目标数7相等的区间，就不用交换，此时left和cur位置一样。
                    swap(arr, left, cur);
                }
                cur++;
                left++;
            } else if (arr[cur] == target) { // 和目标数相等，直接比较下一个
                cur++;
            } else { //cur比目标数大，就把大的数置换到数组后面，判断置换过来的新的数是大、小还是相等
                swap(arr, cur, right);
                right--;
            }
        }
    }

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

}
