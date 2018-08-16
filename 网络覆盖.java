package ACM;

import java.util.Scanner;

public class 网络覆盖 {
    public static void main(String[] args) {
        int t;
        int L,D,R;
        Scanner scanner = new Scanner(System.in);
        t= scanner.nextInt();
        while (t-- != 0){
            L = scanner.nextInt();
            D = scanner.nextInt();
            R = scanner.nextInt();
            int sum = 0;
            if (D/2 >= R || R < 1) System.out.println("impossible");
            else{
                double q =2*Math.sqrt((R*R - D*D/4.0));
                if (L%q != 0){
                    sum = (int)(L/q) +1;
                }else
                    sum = (int)(L/q);
                System.out.println(sum);
            }

        }
    }
}
