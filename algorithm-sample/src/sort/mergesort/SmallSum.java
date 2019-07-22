package sort.mergesort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * Q1、什么是小和？
 * A：在一个数列中，任意元素p左边所有比p小的数之和，即为小和。
 * Q2：什么是小和问题？
 * A: 数列中所有元素的小和之和就是小和问题
 *
 * 利用归并排序求解
 *
 * 思想：从第一个元素p起向后看，如果有n个元素都比p大，说明n个元素的小和中都有p，因此，第一个元素对小和的贡献是n*p,遍历完整个数组后，就可以求出全部小和了。
 * ---------------------
 * 作者：Evan要好好学习好好工作
 * 来源：CSDN
 * 原文：https://blog.csdn.net/u014228447/article/details/80626427
 * 版权声明：本文为博主原创文章，转载请附上博文链接！
 *
 * 还可以参考
 * https://blog.csdn.net/whm114336793/article/details/79692154
 */
public class SmallSum {

    public static void main(String[] args) {
        int[] arr = {8,7,6,5,4,3,2,1,9};
        //int volent = volent(arr);
        //System.out.println(volent);
        int i = mergeSortSum(arr, 0, arr.length - 1);
        System.out.println(i);
        System.out.println(Arrays.toString(arr));
    }


    @Test
    public void test() {
        int left = 1, right = 3;
        int mid1 = left + (right - left)>>1; // + 运算符优先级大于 >>
        int mid2 = left + ((right - left) >> 1);
        System.out.println(mid1 + " " + mid2);
    }

    public static int mergeSortSum(int[] arr, int left, int right) {
        if (left == right)
            return 0;
        int mid = left + ((right - left) >> 1);
        System.out.println("left = " + left + ", right = " + right + ", mid = " + mid);
        return mergeSortSum(arr, left, mid) + mergeSortSum(arr, mid + 1, right)
                + mergeSortSumArray(arr, left, mid, right);
    }

    /**
     * 左右区间分别为[left, mid] 和 [mid + 1, right]
     * @param arr
     * @param left
     * @param mid
     * @param right
     * @return
     */
    public static int mergeSortSumArray(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, tmp = 0, smallSum = 0;
        while (i <= mid && j <= right) {
            // 如果左边组的left元素比右边组的right元素小，则left比right及right右边的所有元素小
            smallSum += arr[i] < arr[j] ? arr[i] * (right - j + 1) : 0;
            //i++;
            temp[tmp++] = arr[i] < arr[j] ? arr[i++] : arr[j++];
        }
        while (i <= mid) {
            temp[tmp++] = arr[i++];
        }

        while(j <= right){
            temp[tmp++] = arr[j++];
        }

        for(i = 0; i < temp.length; i++){
            arr[left + i]  = temp[i];
        }
        return smallSum;
    }

    /**
     * 暴力求解：时间复杂度为：O(N^2)
     * @param arr
     * @return
     */
    public static int volent(int[] arr) {
        int smallSum = 0;
        for (int i = 0; i < arr.length; i++) {
            int sumOfElement = 0;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    sumOfElement += arr[j];
                }
            }
            smallSum += sumOfElement;
        }
        return smallSum;
    }

}
