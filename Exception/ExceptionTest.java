package cn.hjq.Exception;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;

public class ExceptionTest {
    public static void main(String[] args) {
        FileReader reader = null;
        try
        {
            reader = new FileReader("f:/a.txt");
            char c = (char)reader.read();
            char c1 = (char)reader.read();
            System.out.println(""+c+c1);
        }catch (FileAlreadyExistsException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (reader != null)
                    reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
