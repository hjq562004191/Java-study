package 多线程;

public class 线程基本信息 {
    public static void main(String[] args) throws InterruptedException {
        /**
         * 优先级
         * MAX_PRIORITY  10
         * NORM_PRIORITY  5
         * MIN_PRIORITY   1
         *
         */
        Info t1 = new Info();
        Thread s1 = new Thread(t1,"挨踢1");
        Info t2 = new Info();
        Thread s2 = new Thread(t2,"挨踢2");

        s1.start();
        s2.start();
        s1.setPriority(Thread.MAX_PRIORITY);
        s2.setPriority(Thread.MIN_PRIORITY);
        Thread.sleep(200);
        t1.stop();
        t2.stop();
    }


    public static void test() throws InterruptedException {
        /**
         * Thread.currentThread()  //当前线程
         * setName  //设置名称
         * getName   //获取名称
         * isAlive   //判断当前线程的状态
         */
        Info t = new Info();
        Thread s1 = new Thread(t);
//        s1.setName("test");
        s1.start();

        Thread.sleep(200);
        t.stop();

    }
}
