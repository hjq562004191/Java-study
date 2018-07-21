package cn.test;

public class 数组test {
    public static void main(String[] args) {
        int[] a;
        a = new int[10];
        for (int i=0;i<10;i++){
            a[i] = i+i;
            System.out.println(a[i]);
        }
    }
}
