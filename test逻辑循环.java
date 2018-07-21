public class test逻辑循环 {
    public static void main(String[] args){
       int i,j;
       outer:for (i = 101;i < 150;i++) {
           for (j = 2; j < i / 2; j++) {
               if (i % j == 0)
                   continue outer;
           }
           System.out.println(i +" ");

       }
    }
}
