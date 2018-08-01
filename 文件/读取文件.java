package 文件;

import java.io.*;

public class 读取文件 {
    public static void main(String[] args) throws IOException {
        //File对象 建立联系
        File src = new File("f:/a/a.txt");
        //选择流
        BufferedInputStream is = new BufferedInputStream(new FileInputStream(src));
        //操作 读取
        byte[] car = new byte[10];
        int len = 0;//循环读取
        while (-1 != (len = is.read(car))){
            String s = new String(car,0,len);
            System.out.println(s);
        }
        if (is != null)
            is.close();
    }
}
//     A
//    / \
//   /   \
//  /-----\
// /       \