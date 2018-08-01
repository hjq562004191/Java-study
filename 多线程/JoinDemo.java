package 多线程;

import javax.swing.*;

public class JoinDemo implements Runnable{
    public static void main(String[] args) throws InterruptedException {
        JoinDemo t = new JoinDemo();
        Thread s1 = new Thread(t);

        s1.start();
        for (int i = 0; i < 1000; i++) {
            if (i == 100){
                s1.join();
            }
            System.out.println("main....."+i);
        }
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {

            System.out.println("qqqq......"+i);
        }
    }
}
