package cn.hjq.Exception;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Throws抛出异常
 */
public class TestReadFile {
    public static void main(String[] args) {
        String str = null;
        try{
            str = new TestReadFile().OpenFile();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(str);
    }
        String OpenFile() throws FileNotFoundException,IOException {
            FileReader reader = new FileReader("f:/a.txt");
            char d = (char)reader.read();
            System.out.println(d);
            return ""+d;
        }

}
