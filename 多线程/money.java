package 多线程;

public class money implements Runnable{
    public int num = 3;
    @Override
    public void run() {
        while (true) {
            System.out.println(Thread.currentThread().getName() + "抢到了"+num);
            if (num <= 0){
                break;
            }
            num--;
        }
    }
}
