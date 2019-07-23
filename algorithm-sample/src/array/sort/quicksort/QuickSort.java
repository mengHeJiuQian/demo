package array.sort.quicksort;

import java.util.Arrays;

/**
 * 创建人：yang.liu
 * 创建时间：2019/7/23 19:32
 * 版本：1.0
 * 内容描述：手撕经典快排程序
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {7, 2,1,8,5, 7, 3,7,9,4,6, 7};
        printArr(arr);
        quicksort(arr, 0, arr.length-1);
        printArr(arr);
    }

    public static void quicksort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int pivot = partition(arr, start, end);
        quicksort(arr, start, pivot - 1);
        quicksort(arr, pivot + 1, end);

    }

    public static int partition(int[] arr, int start, int end) {
        int pivot = arr[start];
        while (start < end) {
            while (start < end && arr[end] > pivot) { //右边是大的，移走小的
                end--;
            }
            if (start < end) {
                arr[start++] = arr[end];
            }
            while (start < end && arr[start] < pivot) { //左边是小的，移走大的
                start++;
            }
            if (start < end) {
                arr[end--] = arr[start];
            }
        }
        arr[start] = pivot;
        return start;
    }

    public static void swap(int[] arr, int srcIndex, int targetIndex) {
        int temp = arr[srcIndex];
        arr[srcIndex] = arr[targetIndex];
        arr[targetIndex] = temp;
    }

    public static void printArr(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }
}
