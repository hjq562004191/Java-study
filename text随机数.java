import java.util.Scanner;

public class text随机数 {

    public static void main(String[] args){

        double r = 4 * Math.random();
        System.out.println("圆的面积为:"+Math.PI*r*r);

        int a = (int)(6 * Math.random());
        if (a<=3){
            System.out.println("小");
        }else
            System.out.println("大");
    }
}
