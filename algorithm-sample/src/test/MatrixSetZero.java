package test;

import java.util.Arrays;

/**
 * 创建人：yang.liu
 * 创建时间：2019/7/23 20:52
 * 版本：1.0
 * 内容描述：
 */
public class MatrixSetZero {

    public static void main(String[] args) {
        int[][] arr = {
                {0, 0, 1, 0, 0},
                {0, 0, 1, 0, 0},
                {1, 1, 1, 1, 1},
                {0, 0, 1, 0, 0},
                {0, 0, 1, 0, 0},
        };

        //printMatrix(arr);
        setRowAndColZero(arr);
        printMatrix(arr);
    }

    public static void setRowAndColZero(int[][] arr) {
        int[] row = new int[arr.length];
        int[] col = new int[arr[0].length];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == 0) {
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }

        for (int i = 0; i < row.length; i++) {
            for (int j = 0; j < col.length; j++) {
                if (row[i] == 1 || col[j] == 1) {
                    arr[i][j] = 0;
                }
            }
        }
    }

    public static void printMatrix(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }
}
