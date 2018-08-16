package 设计模式GOF23;

public class SingletonDemo4 {
    private static class SingletonClassInstance {
        private static final SingletonDemo4 instance = new SingletonDemo4();
    }

    private SingletonDemo4(){
    }

    //方法没有同步，调用效率高！
    public static SingletonDemo4 getInstance(){
        return SingletonClassInstance.instance;
    }
}
