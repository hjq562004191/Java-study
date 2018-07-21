package cn.test;

public class foreachTest {
    public static void main(String[] args) {
        int a[] = new int[5];
        String[] s = new String[3];
        for (int i = 0; i < 5; i++) {
            a[i] = i+1;
        }
        s[0] = "aaa";
        s[1] = "bbb";
        s[2] = "ccc";
        for (int k: a) {
            System.out.println(k);
        }
        for (String t: s
             ) {
            System.out.println(t);
        }
    }
}
