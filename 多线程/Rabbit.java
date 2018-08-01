package 多线程;

/**
 * 模拟龟兔赛跑
 * 1.创建多线程 继承 Thread + 重写 run();
 * 2.使用线程：创建子类对象 + 对象.start(); 线程启动 不代表运行
 */
public class Rabbit extends Thread{
    @Override
    public void run() {
        for (int i = 0;i<=1000;i+=2){
            System.out.println("兔子跑了"+i+"米");
        }
    }
}
class Tortoise extends Thread{
    @Override
    public void run() {
        for (int i = 0;i<=1000;i++){
            System.out.println("乌龟跑了"+i+"米");
        }
    }
}
