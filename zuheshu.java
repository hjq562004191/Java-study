package ACM;

import java.util.Scanner;

public class zuheshu {
    public static void main(String[] args) {
        int n,r;
        Scanner scanner = new Scanner(System.in);
        r = scanner.nextInt();
        n= scanner.nextInt();
        for (int i = r; i > 0; i--) {
            if (n == 1)
            System.out.println(i);
            for (int j = i-1; j > 0 && n > 1; j--) {
                if (n == 2)
                System.out.println(""+i+j);
                for (int k = j - 1; k > 0 && n > 2; k--){
                    if (n == 3)
                    System.out.println(""+i+j+k);
                    for (int l = k - 1; l > 0 && n > 3; l--){
                        if (n == 4)
                        System.out.println(""+i+j+k+l);
                        for (int m = l - 1; m > 0 && n > 4; m--){
                            if (n == 5)
                            System.out.println(""+i+j+k+l+m);
                            for (int o = m - 1; o > 0 && n > 5; o--){
                                if (n == 6)
                                System.out.println(""+i+j+k+l+m+o);
                                for (int p = o - 1; p > 0 && n > 6; p--){
                                    if (n == 7)
                                    System.out.println(""+i+j+k+l+m+o+p);
                                    for (int q = p - 1; q > 0 && n > 7; q--){
                                        if (n == 8)
                                        System.out.println(""+i+j+k+l+m+o+q);
                                        for (int s = q - 1; s > 0 && n > 8; s--){
                                            if (n == 9)
                                            System.out.println(""+i+j+k+l+m+o+q+s);
                                            for (int t = s - 1; t > 0 && n > 9; t--){
                                                if (n == 10)
                                                System.out.println(""+i+j+k+l+m+o+q+s+t);

            }}}}}}}}}}
    }
}
