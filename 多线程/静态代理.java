package 多线程;

import java.util.Map;

/**
 * 静态代理 设计模式
 * 1.真实角色
 * 2.代理角色
 * 3.二者实现相同的接口
 */
public class 静态代理 {
    public static void main(String[] args) {
        Marry you = new You();
        Marry company = new WeddingCompany(you);

        company.marry();
    }

    //共同接口
    interface Marry{
        public abstract void marry();
    }
    //真实角色
    static class You implements Marry{
        @Override
        public void marry() {
            System.out.println("你和嫦娥结婚了");
        }
    }
    //代理角色
    static class WeddingCompany implements Marry{
        private Marry you;
        public WeddingCompany() {
        }

        public WeddingCompany(Marry you) {
            this.you = you;
        }
        private void before(){
            System.out.println("布置婚房");
        }
        private void after(){
            System.out.println("闹洞房");
        }
        @Override
        public void marry() {
            before();
            you.marry();
            after();
        }
    }
}
