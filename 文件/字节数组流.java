package 文件;

import java.io.*;

public class 字节数组流 {
    public static void main(String[] args) throws IOException {
        read();
        write();
    }

    public static void write() throws IOException {
        //目的地
        byte[] dest;
        //选择流
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        String msg = "中国";
        byte[]  src = msg.getBytes();
        bos.write(src,0,src.length);
        dest = bos.toByteArray();
        bos.close();
        String s = new String(dest,0,dest.length);
        System.out.println(s);
    }

    public static void read() throws IOException {
        //与文件输入流操作一致
        //读取字节数组
        String msg = "中国";
        byte[]  src = msg.getBytes();

        //选择流
        InputStream is = new BufferedInputStream(
                new ByteArrayInputStream(
                        src
                )
        );
        byte[] flush = new byte[1024];
        int len = 0;
        while (-1 != (len = is.read(flush))){
            System.out.println(new String(flush,0,len));
        }
        is.close();
    }
}
