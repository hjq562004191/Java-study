package 多线程;

public class 练习 {
    public static void main(String[] args) throws InterruptedException {
        Animal robbit = new Animal(500,"兔子");
        Animal wugui = new Animal(1000,"乌龟");
        Thread s1 = new Thread(robbit);
        Thread s2 = new Thread(wugui);
        s1.start();
        s2.start();
        Thread.sleep(3000);
        robbit.setFlag(false);
        wugui.setFlag(false);
        System.out.println(robbit.getName()+"---->"+robbit.getStep()+"步");
        System.out.println(wugui.getName()+"---->"+wugui.getStep()+"步");
    }
}
class Animal implements Runnable{
    private boolean flag = true;
    private int time;
    private String name;
    private int step = 1;

    @Override
    public void run() {
    while (flag){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        step++;
    }
    }

    public Animal(int time, String name) {
        this.time = time;
        this.name = name;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }
}