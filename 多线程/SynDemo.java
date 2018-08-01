package 多线程;

/**
 * 多线程访问同一份资源
 * synchronize - > 同步
 * synchronized 修饰的类或者方法只能被一个线程访问，从而保护
 */
public class SynDemo{
    public static void main(String[] args) {
        Mythread t = new Mythread();

        Thread s1 = new Thread(t,"a");
        Thread s2 = new Thread(t,"b");
        Thread s3 = new Thread(t,"c");

        s1.start();
        s2.start();
        s3.start();
    }


static class Mythread implements Runnable{
    public int num = 100;
    boolean flag = true;
    @Override
    public void run() {

        while (flag) {
            try {
                test02();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public synchronized void test02() throws InterruptedException {
        if (num <= 0) {
            flag = false;
            return;
        }
        Thread.sleep(0);
        System.out.println(Thread.currentThread().getName() + "抢到了" + num--);
    }
}

}
