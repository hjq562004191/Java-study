package 设计模式GOF23;

import java.io.*;
import java.lang.reflect.Constructor;

/**
 * 测试反射和反序列化破解单例模式
 */
public class Client2 {
    public static void main(String[] args) throws Exception {
        SingletonDemo6 s1 = SingletonDemo6.getInstance();
        SingletonDemo6 s2 = SingletonDemo6.getInstance();

        System.out.println(s1);
        System.out.println(s2);

//        //通过反射直接调用私有构造器
//        Class<SingletonDemo6> clazz = (Class<SingletonDemo6>) Class.forName("设计模式GOF23.SingletonDemo6");
        Class.forName("设计模式GOF23.SingletonDemo6");
////        Class.forName("设计模式GOF23.SingletonDemo6");
//        Constructor<SingletonDemo6> c = clazz.getDeclaredConstructor(null);
//        c.setAccessible(true);//放弃检查是否私有权限
//        SingletonDemo6 s3 = c.newInstance();
//        SingletonDemo6 s4 = c.newInstance();
//
//        System.out.println(s3);
//        System.out.println(s4);

        //通过反序列化的方式构造多个对象
        FileOutputStream fos = new FileOutputStream("d:/a.txt");
        ObjectOutputStream oos =new ObjectOutputStream(fos);
        oos.writeObject(s1);
        oos.close();
        fos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("d:/a.txt"));
        SingletonDemo6 s3 = (SingletonDemo6) ois.readObject();
        System.out.println(s3);
    }
}
