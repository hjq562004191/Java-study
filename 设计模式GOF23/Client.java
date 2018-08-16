package 设计模式GOF23;

public class Client {
    public static void main(String[] args) {
        hunger s1 = hunger.getInstance();
        hunger s2 = hunger.getInstance();
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(SingletonDemo5.INSTANCE == SingletonDemo5.INSTANCE);
    }
}
