package array;

import java.util.Arrays;

/**
 * 创建人：yang.liu
 * 创建时间：2019/7/23 9:36
 * 版本：1.0
 * 内容描述：编写一个算法，若矩阵M*N中某个元素为0，则将其所在行与列清0。
 */
public class RowAndColumnSetToZero {

    public static void main(String[] args) {
        int[][] arr = {
                {0, 0, 1, 0, 0},
                {0, 0, 1, 0, 0},
                {1, 1, 1, 1, 1},
                {0, 0, 1, 0, 0},
                {0, 0, 1, 0, 0}
        };

        boolean[] rowFlag = new boolean[arr.length];
        boolean[] colFlag = new boolean[arr[0].length];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if(arr[i][j] == 0) {
                    rowFlag[i] = colFlag[j] = true;
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if(rowFlag[i] & colFlag[j]) {
                    arr[i][j] = 0;
                }
            }
        }

        printMatrix(arr);
    }

    public static void printMatrix(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }
}
