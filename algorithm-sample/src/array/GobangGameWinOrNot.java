package array;

import java.util.Arrays;

/**
 * 创建人：yang.liu
 * 创建时间：2019/7/23 10:04
 * 版本：1.0
 * 内容描述：请编写程序，能够判断M*N棋盘上当前五子棋的胜负情况。
 */
public class GobangGameWinOrNot {

    private int[][] chessboard = null;

    // 从棋盘左上角开始，从上往下row增加，从左往右列增加
    private int row, col;

    private void createDefaultChessBoard() {
        chessboard = new int[][]{
                {0, 3, 1, 0, 0, 0, 0},
                {0, 2, 3, 2, 2, 2, 0},
                {0, 0, 1, 3, 0, 0, 4},
                {0, 0, 1, 0, 3, 4, 0},
                {0, 0, 1, 0, 4, 3, 0},
                {0, 0, 0, 4, 0, 0, 0},
                {0, 0, 4, 0, 0, 0, 0},
        };
        row = chessboard.length;
        col = chessboard[0].length;
    }

    public static void main(String[] args) {
        GobangGameWinOrNot gobang = new GobangGameWinOrNot();
        gobang.createDefaultChessBoard();
        boolean res = false;
        for (int r = 0; r < gobang.getRow(); r++) {
            for (int c = 0; c < gobang.getCol(); c++) {
                 res = gobang.checkWin(r, c);
                 if (res == true) {
//                     System.out.println(r + " " + c);
                     System.out.println("胜利方是" + gobang.get(r, c));
                     return;
                 }

            }
        }


    }

    // 判断当前的棋盘是否存在五子连线的情况，分为以下几步
    // 判断横向
    // 判断竖向
    // 判断右上-左下方向
    // 判断左上-右下方向
    public boolean checkWin(int row, int col) {
        boolean b1 = checkRow(row, col);
        boolean b2 = checkCol(row, col);
        boolean b3 = checkSlash(row, col);
        boolean b4 = checkBackSlash(row, col);
        return b4;

    }

    private boolean checkBackSlash(int row, int col) {
        int play = chessboard[row][col];
        int line = 1;
        int r = row, c = col;
        if (chessboard[row][col] == 0) {
            return false;
        }
        // 计算左上角
        while (--r >=0 && --c >=0) {
            if (chessboard[r][c] == play) {
                if (++line == 5) {
                    return true;
                }
            } else {
                break;
            }
        }
        // 计算右下角
        r = row;
        c = col;
        while (++r < getRow() && ++c < getCol()) {
            if (chessboard[r][c] == play) {
                if (++line == 5) {
                    return true;
                }
            } else {
                break;
            }
        }
        return false;
    }

    private boolean checkSlash(int row, int col) {
        int play = chessboard[row][col];
        int line = 1;
        int r = row, c = col;
        if (chessboard[row][col] == 0) {
            return false;
        }
        // 计算右上角
        while (--r >=0 && ++c < getCol()) {
            if (chessboard[r][c] == play) {
                if (++line == 5) {
                    return true;
                }
            } else {
                break;
            }
        }
        // 计算左下角
        r = row;
        c = col;
        while (++r < getRow() && --c >= 0) {
            if (chessboard[r][c] == play) {
                if (++line == 5) {
                    return true;
                }
            } else {
                break;
            }
        }
        return false;
    }


    /**
     * 01000
     * 01000
     * 01000
     * 01000
     * 01000
     */
    public boolean checkRow(int row, int col) {
        int play = chessboard[row][col]; // 确认棋手，0表示无棋子，1暂时表示有棋子。先不区分黑白棋。
        int r = row, c = col;
        int line = 1;
        if (chessboard[row][col] == 0) {
            return false;
        }
        int rUp = r;
        while (--rUp >= 0) {
            if (chessboard[rUp][c] == play) {
                line++;
                if (line == 5) {
                    return true;
                }
            } else {
                break;
            }
        }

        int rDown = r;
        while (++rDown < getRow()) {
            if (chessboard[rDown][c] == play) {
                line++;
                if (line == 5) {
                    return true;
                }
            } else {
                break;
            }
        }
        return false;
    }

    private boolean checkCol(int row, int col) {
        int play = chessboard[row][col];
        int line = 1;
        if (chessboard[row][col] == 0) {
            return false;
        }
        int cLeft = col;
        while (--cLeft >= 0) {
            if (chessboard[row][cLeft] == play) {
                line++;
                if (line == 5) {
                    return true;
                }
            } else {
                break;
            }
        }
        int cRight = col;
        while (++cRight < getCol()) {
            if (chessboard[row][cRight] == play) {
                line++;
                if (line == 5) {
                    return true;
                }
            } else {
                break;
            }
        }
        return false;
    }

    public void setChessboard(int[][] chessboard) {
        this.chessboard = chessboard;
    }



    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public int get(int row, int col) {
        return chessboard[row][col];
    }

    public void printMatrix(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }
}
