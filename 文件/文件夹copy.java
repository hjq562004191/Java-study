package 文件;

import sun.reflect.misc.FieldUtil;

import java.io.File;
import java.io.IOException;

/**
 * 文件夹的拷贝
 * 1、文件 赋值 copyFile
 * 2、文件创建  mkdirs
 * 3、递归查找子孙级
 */
public class 文件夹copy {
    public static void main(String[] args) {
        String path = "f:/a/b";//源目录
        String destpath = "f:/a/b1";//目的文件

        File scr = new File(path);
        File dest = new File(destpath);
        if (scr.isDirectory()){
             dest  = new File(destpath,scr.getName());
        }
        copyDir(scr,dest);
    }
    public static void copyDir(File src,File dest){
        if (src.isFile()){
            try {
                Demo01.copyfile2(src,dest);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else if (src.isDirectory()){//是一个文件夹
            //确保目标文件夹存在
            dest.mkdirs();
            for (File t:src.listFiles()
                 ) {
                  copyDir(t,new File(dest,t.getName()));
            }
        }
    }
}
