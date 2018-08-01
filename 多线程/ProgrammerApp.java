package 多线程;

public class ProgrammerApp {
    public static void main(String[] args) {
        Programmer p1 = new Programmer();

        Thread proxy = new Thread(p1);

        proxy.start();

        for (int i = 0; i < 100; i++) {
            System.out.println("边看手机");
        }
    }
}
