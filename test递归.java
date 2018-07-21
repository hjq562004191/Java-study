public class test递归 {
    public static void main(String[] args) {

        System.out.printf("%d阶乘的结果%d:",10,a(10));
    }
    static int a(int n){
        if(n == 1)
            return 1;
        else {
            return n*a(n-1);
        }
    }
}
