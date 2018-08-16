package 设计模式GOF23;

/**
 * 饿汉式单例模式
 */
public class hunger {

    //类初始化时，立即加载（没有延时加载的优势）//天然线程安全
    private static hunger instance = new hunger();

    private hunger(){
        //私有构造器
    }

    public static hunger getInstance(){
        return instance;
    }
}
