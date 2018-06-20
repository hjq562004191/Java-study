import java.awt.*;
import javax.swing.*;
public class BallGame extends JFrame{

    Image ball = Toolkit.getDefaultToolkit().getImage("images/ball.jpg");
    Image desk = Toolkit.getDefaultToolkit().getImage("images/desk.jpg");

    double x = 100;
    double y = 100;
    boolean right = true;//方向
    //画窗口的方法
    public void paint(Graphics g){
        g.drawImage(desk,0,0,null);
        g.drawImage(ball,(int) x,(int) y,null);

        if(right){
            x = x+10;
        }else{
            x= x-10;
        }

        if(x > 480 - 80)
            right = false;
        if(x < 0+50)
            right = true;
    }
        //窗口加载
        void launchFrame() {
            setSize(480, 340);
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
                BallGame game = new BallGame();
                game.launchFrame();
            }
}
