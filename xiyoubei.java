import java.util.Scanner;

public class xiyoubei {
    public static void main(String[] args) {
        int y;
        int i;
        Scanner p = new Scanner(System.in);
        y = p.nextInt();
        for (i = 1;i < y;i++)
        {
            if(yinzi(yinzi(i)) == i && i < yinzi(i))
                System.out.println("("+i+","+yinzi(i)+")");
        }
    }
    static int yinzi(int n){
        int i,sum = 0;
        for (i = 1;i<n;i++){
            if (n%i == 0)
                sum+=i;
        }
        return sum;
    }
}
