package ACM;

import java.util.Scanner;

public class 开灯问题 {
    public static void main(String[] args) {
        int k,n;
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        k = scanner.nextInt();
        int[] a = new int[1001];
        for (int i = 1; i <= n; i++) {
            a[i] = 1;
        }
        for (int i = 2; i <= k; i++) {
            for (int j = 1; j <= n; j++) {
                if (j%i == 0){
                    a[j] = a[j] * -1;
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            if (a[i] == 1){
                System.out.print(i+" ");
            }
        }
    }
}
