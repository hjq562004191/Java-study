/**
 * 桌球小游戏
 *
 */

import java.awt.*;
import javax.swing.*;
public class BallGame2 extends JFrame{

    Image ball = Toolkit.getDefaultToolkit().getImage("images/ball.jpg");
    Image desk = Toolkit.getDefaultToolkit().getImage("images/desk.jpg");

    double x = 100;
    double y = 100;

    double degree = 3.14/3;//弧度制60°;

    //画窗口的方法
    public void paint(Graphics g){
        g.drawImage(desk,0,0,null);
        g.drawImage(ball,(int) x,(int) y,null);

        x = x + 10*Math.cos(degree);
        y = y + 10*Math.sin(degree);

        if(y > 300 -70|| y < 40){
            degree = -degree;
        }
        if (x > 450-50 || x < 30){
            degree = 3.14 - degree;
        }
    }
    //窗口加载
    void launchFrame() {
        setSize(480, 320);
        setLocation(50, 50);
        setVisible(true);

        //重画窗口
        while(true){
            repaint();
            try{
                Thread.sleep(40);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        System.out.println("adsadsadsad");
        BallGame2 game = new BallGame2();
        game.launchFrame();
    }
}
