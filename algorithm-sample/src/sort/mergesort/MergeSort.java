package sort.mergesort;

import java.util.Arrays;

/**
 * 小和问题
 * 逆序列
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {9,8,7,6,5,4,3,2,1};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr) {
        if (null == arr || arr.length == 0)
            return ;
        int[] temp = new int[arr.length];
        sort(arr, 0, arr.length - 1, temp);
    }

    public static void sort(int[] target, int left, int right, int[] temp) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            sort(target, left, mid, temp);
            sort(target, mid + 1, right, temp);
            merge(target, left, mid, right, temp);
        }
    }

    /**
     * 将target的已经排序的[left, mid]和[mid + 1, right]的数进行排序，排序结果保存到temp临时数组中
     * @param target
     * @param left
     * @param mid
     * @param right
     * @param temp
     */
    public static void merge(int[] target, int left, int mid, int right, int[] temp) {
        // k来标记temp数组存放数的位置
        int i = left, j = mid + 1, k = 0;
        while (i <= mid && j <= right) {
            if (target[i] > target[j]) {
                temp[k++] = target[j++];
            } else {
                temp[k++] = target[i++];
            }
        }
        while (i <= mid) {
            temp[k++] = target[i++];
        }
        while (j <= right) {
            temp[k++] = target[j++];
        }
        // 将临时数组中的有序数列拷贝到目标排序数组的对应位置上
        k = 0;
        while (left <= right) {
            target[left++] = temp[k++];
        }
    }

}
