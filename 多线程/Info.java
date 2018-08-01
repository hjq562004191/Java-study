package 多线程;

public class Info implements Runnable{
    private int num = 0;
    private boolean flog = true;
    @Override
    public void run() {
        while (flog){
            System.out.println(Thread.currentThread().getName()+"-->"+num++);
        }
    }
    public void stop(){
        this.flog = false;
    }
}
