package array;

/**
 * 创建人：yang.liu
 * 创建时间：2019/7/23 10:49
 * 版本：1.0
 * 内容描述：
 */
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class FiveChessFrame extends JFrame implements MouseListener {
    int width = Toolkit.getDefaultToolkit().getScreenSize().width;
    int height = Toolkit.getDefaultToolkit().getScreenSize().height;
    BufferedImage bgImage = null;
    int x = 0;
    int y = 0;

    int[][] allChess = new int[19][19];
    boolean isBlack = true;
    boolean canPlay = true;//判断游戏可以继续落子，如果哪一方胜利，就置为false，不执行mousePressed的主体

    public FiveChessFrame() {
        this.setTitle("五子棋");
        this.setSize(500, 500);
        this.setLocation((width - 500) / 2, (height - 500) / 2);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        this.addMouseListener(this);
        try {
            bgImage = ImageIO.read(new File("F:/mypicture/java/background.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void paint(Graphics g) {
        g.drawImage(bgImage, 3, 20, this);
        g.setFont(new Font("黑体", Font.BOLD, 20));
        g.drawString("游戏信息:", 150, 50);
        g.setFont(new Font("宋体", 0, 14));
        g.drawString("黑方时间：无限制", 45, 470);
        g.drawString("白方时间：无限制", 260, 470);
        for (int i = 0; i < 19; i++) {
            g.drawLine(13, 70 + 20 * i, 372, 70 + 20 * i);
            g.drawLine(13 + 20 * i, 70, 13 + 20 * i, 430);
        }
        g.fillOval(71, 128, 4, 4);
        g.fillOval(311, 128, 4, 4);
        g.fillOval(311, 368, 4, 4);
        g.fillOval(71, 368, 4, 4);
        g.fillOval(311, 248, 4, 4);
        g.fillOval(191, 128, 4, 4);
        g.fillOval(71, 248, 4, 4);
        g.fillOval(191, 368, 4, 4);
        g.fillOval(191, 248, 4, 4);

        for (int i = 0; i < 19; i++)
            for (int j = 0; j < 19; j++) {
                if (allChess[i][j] == 1) {
                    x = i * 20 + 13;
                    y = j * 20 + 70;
                    g.fillOval(x - 7, y - 7, 14, 14);
                }
                if (allChess[i][j] == 2) {
                    x = i * 20 + 13;
                    y = j * 20 + 70;
                    g.setColor(Color.WHITE);
                    g.fillOval(x - 7, y - 7, 14, 14);
                    g.setColor(Color.BLACK);
                    g.drawOval(x - 7, y - 7, 14, 14);
                }
            }
    }

    @Override
    public void mouseClicked(MouseEvent e) {


    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (canPlay == true) {
            x = e.getX();
            y = e.getY();
            if (x >= 13 && x <= 372 && y >= 70 && y <= 430) {
                x = (x - 13) / 20;
                y = (y - 70) / 20;
                if (allChess[x][y] == 0) {
                    if (isBlack) {
                        allChess[x][y] = 1;
                        isBlack = false;
                    } else {
                        allChess[x][y] = 2;
                        isBlack = true;
                    }
                    this.repaint();
                    boolean winFlag = this.checkWin();//每下一个棋子就判断输赢
                    if (winFlag == true)//哪一方获胜就弹出窗口并将canPlay置为false
                    {
                        JOptionPane.showMessageDialog(this, "游戏结束" + (allChess[x][y] == 1 ? "黑方" : "白棋") + "获胜！");
                        canPlay = false;
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "当前位置已经有旗子了，请重新落子！");
                }
            }
        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {


    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {


    }

    public static void main(String[] args) {
        FiveChessFrame ff = new FiveChessFrame();

    }

    // 判断输赢
    private boolean checkWin() {
        boolean flag = false;
        int count = 1;
        int color = allChess[x][y];
        count = this.checkCount(1, 0, color);//判断横向
        if (count >= 5) {
            flag = true;
        } else {
            // 判断纵向
            count = this.checkCount(0, 1, color);
            if (count >= 5) {
                flag = true;
            } else {
                // 判断右上、左下
                count = this.checkCount(1, -1, color);
                if (count >= 5) {
                    flag = true;
                } else {
                    // 判断右下、左上
                    count = this.checkCount(1, 1, color);
                    if (count >= 5) {
                        flag = true;
                    }
                }
            }
        }

        return flag;
    }

    private int checkCount(int xChange, int yChange, int color) {
        int count = 1;
        int tempX = xChange;
        int tempY = yChange;
        while (x + xChange >= 0 && x + xChange <= 18 && y + yChange >= 0 && y + yChange <= 18
                && color == allChess[x + xChange][y + yChange]) {//下一个需要判断的棋子在边界内并且与上一个棋子颜色相同则执行,这是判断x的右边和y的下边
            count++;
            if (xChange != 0)//xChange不为零，就判断x的右上和左下
                xChange++;
            if (yChange != 0) {
                if (yChange > 0)
                    yChange++;
                else {
                    yChange--;
                }
            }
        }
        xChange = tempX;
        yChange = tempY;
        while (x - xChange >= 0 && x - xChange <= 18 && y - yChange >= 0 && y - yChange <= 18
                && color == allChess[x - xChange][y - yChange]) {//继续判断x的左边和y的上边
            count++;
            if (xChange != 0)//xChange不为零，就判断x的左上和右下
                xChange++;
            if (yChange != 0) {
                if (yChange > 0)
                    yChange++;
                else {
                    yChange--;
                }
            }
        }
        return count;//返回当前判断的方向共有多少个同色棋子相连，共四个方向，横竖对角线四个
    }

}
