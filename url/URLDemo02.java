package url;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 获取资源：源代码
 */
public class URLDemo02 {
    public static void main(String[] args) throws IOException {
        URL url= new URL("http://www.baidu.com");//主页，默认资源

        //获取资源
//        InputStream is = url.openStream();
//        byte[] flush = new byte[1024];
//        int len = 0;
//        while (-1 != (len = is.read(flush))){
//            System.out.println(new String(flush,0,len));
//        }
//        is.close();
        BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream(),"UTF-8"));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("baidu.html"),"UTF-8"));
        String MSG = null;
        while (null != (MSG = br.readLine())){
//            System.out.println(MSG);
            bw.append(MSG);
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
