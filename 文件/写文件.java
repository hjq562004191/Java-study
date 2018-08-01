package 文件;

import java.io.*;

public class 写文件 {
    public static void main(String[] args) throws IOException {
        File dest = new File("f:/a/b.txt");
        OutputStream os = null;
        try {
             os = new BufferedOutputStream(new FileOutputStream(dest,true));
            String str = "3g is good \r\ngggggg";
            byte[] data = str.getBytes();
            os.write(data,0,data.length);
            os.flush();;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("文件未找到");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("文件写出失败");
        }finally {
            if (os != null)
                os.close();
        }
    }
}
