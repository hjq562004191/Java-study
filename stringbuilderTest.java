package cn.test;

public class stringbuilderTest {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("abcd");
        sb.append(20);
        sb.append("qwert");
        System.out.println(sb);
        StringBuilder sb1 = new StringBuilder();
        for (int i = 0;i < 100;i++){
            sb1.append(i);
        }
        System.out.println(sb1);
    }
}
