package regex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 网络爬虫爬取连接
 */
public class WebSpiderTest {


    public static String getURL(String urlStr){
        StringBuilder sb=new StringBuilder();
        try {
            URL url = new URL(urlStr);
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream(),Charset.forName("gbk")));
            String temp ="";
            while ((temp = reader.readLine())!=null){
                sb.append(temp);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public static List<String> getMatherSubstrs(String destStr,String regexStr){
            Pattern p = Pattern.compile(regexStr);//取到超链接的地址
            Matcher m = p.matcher(destStr);
        List<String> result = new ArrayList<>();
        while (m.find()){
            result.add(m.group(1));
        }
        return result;
    }
    public static void main(String[] args) {
        String str = getURL("http://www.163.com");
        List<String> result = getMatherSubstrs(str,"href=\"([\\w\\s./:]+?)\"");

        for (String temp:result
             ) {
            System.out.println(temp);
        }
//        Pattern p = Pattern.compile("<a[\\s\\S]+?</a>");//取到超链接的真个内容

    }
}