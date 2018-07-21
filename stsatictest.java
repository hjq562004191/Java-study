package cn.test;

public class stsatictest {
    public static  void f(){
        int st = 10;
        st++;
        System.out.println(st);
    }
    public static void main(String[] args) {
        f();
        f();
        f();
    }

}
