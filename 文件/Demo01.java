package 文件;

import java.io.*;//拷贝文件//封装

public class Demo01 {
    public static void main(String[] args) throws IOException {
        copyfile("f:/a/2.jpg","f:/a/100.jpg");
    }
    public static void copyfile(String str,String dest) throws IOException {
        File s1 = new File(str);//建立联系源
        File s2 = new File(dest);//目的地（可以为不存在文件）

        copyfile2(s1,s2);
    }
    public static void copyfile2(File s1,File s2) throws IOException {

        InputStream is = new FileInputStream(s1);//选择流
        OutputStream os = new FileOutputStream(s2);
        //文件拷贝  循环+读取+写出
        byte[] flush = new byte[1024];
        int len = 0;
        //读取
        while (-1 !=(len = is.read(flush))){
            os.write(flush,0,len);//写出
        }
        os.flush();//强制刷出
        //关闭流
        os.close();
        is.close();
    }
}
