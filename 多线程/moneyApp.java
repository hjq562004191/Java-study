package 多线程;

public class moneyApp {
    public static void main(String[] args) {
        money m = new money();
        Thread s1 = new Thread(m,"路人甲");
        Thread s2 = new Thread(m,"路人乙");
        Thread s3 = new Thread(m,"路人丙");

        s1.start();
        s2.start();
        s3.start();

    }
}
