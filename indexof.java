package text.ArrayList;

import java.util.ArrayList;

/**
 * ArrayList 中的  indexof(a)  可以找到第一次出现a的位置，并返回其下标
 * 如果没有就返回-1
 */
public class indexof {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(null);
        list.add(3);
        list.add(4);


        System.out.println("null:" + list.indexOf(null));
        System.out.println("3:" + list.indexOf(3));
        System.out.println("5:" + list.indexOf(5));
    }
}