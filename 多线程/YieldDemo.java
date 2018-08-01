package 多线程;

public class YieldDemo implements Runnable{
    public static void main(String[] args) throws InterruptedException {
        YieldDemo t = new YieldDemo();
        Thread s2 = new Thread(t);

        s2.start();

        for (int i = 0; i < 1000; i++) {
            if (i%20 == 0){
                s2.yield();//暂停main调度，执行别的线程
            }
            System.out.println("main....."+i);
        }
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("yield........"+i);
        }
    }
}
