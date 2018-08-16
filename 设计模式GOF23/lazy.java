package 设计模式GOF23;

/**
 * 懒汉式单例模式
 */
public class lazy {
    //不初始化这个对象，用时加载（演示加载）
    private static lazy instance;
    private lazy(){

    }
    public static synchronized lazy getInstance(){
        if (instance == null){
            instance = new lazy();
        }
        return instance;
    }
}
