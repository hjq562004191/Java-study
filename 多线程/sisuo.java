package 多线程;

/**
 * 过多的同步方法可能造成死锁
 * 互相不释放资源
 */

public class sisuo {
    public static void main(String[] args) {
        Object g = new Object();
        Object m = new Object();
        Test t1 =new Test(g,m);
        Test2 t2 = new Test2(g,m);
        Thread s1 = new Thread(t1);
        Thread s2 = new Thread(t2);
        s1.start();
        s2.start();
    }
}
class Test implements Runnable {
    Object goods;
    Object money;

    public Test(Object goods, Object money) {
        this.goods = goods;
        this.money = money;
    }

    @Override
    public void run() {
        while (true) {
            try {
                test();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void test() throws InterruptedException {
        synchronized (goods) {
            Thread.sleep(50);
            synchronized (money) {

            }
        }
        System.out.println("一手给钱");
    }
}
    class Test2 implements Runnable{
        Object goods ;
        Object money ;

        public Test2(Object goods, Object money) {
            this.goods = goods;
            this.money = money;
        }

        @Override
        public void run() {
            while(true){
                try {
                    test();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        public void test() throws InterruptedException {
            synchronized (money){
                Thread.sleep(100);
                synchronized (goods){

                }
            }
            System.out.println("一手给货");
        }
}
