package array;

import java.util.Arrays;

/**
 * 创建人：yang.liu
 * 创建时间：2019/7/23 10:04
 * 版本：1.0
 * 内容描述：请编写程序，能够判断M*N棋盘上当前五子棋的胜负情况。
 */
public class GobangGameWinOrNot {

    public static void main(String[] args) {
        int[][] checkBoard = {
                {0, 0, 1, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
        };

        printMatrix(checkBoard);
    }

    public static void printMatrix(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }
}
