public class test重载 {
    public static void main(String[] args) {
        test重载 cz = new test重载();
        int c = cz.add(1,2,3);
        int d = cz.add(3,4);
        System.out.println(c);
        System.out.println(d);
        /**
         * 方法名相同，参数个数不同，构成重载
         * 方法名相同，参数类型不同，构成重载
         * 方法名相同，参数顺序不同，构成重载
         * 编译错误：只有返回值不同，不构成重载
         * 编译错误：只有参数名不同，不构成重载
         */
    }
    int add(int n1,int n2,int n3){
        int sum = n1 +n2 +n3;
        return  sum;
    }
    int add(int n1,int n2){
        int sum = n1 + n2;
        return sum;
    }
}
