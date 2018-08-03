package TestAnnotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * Student
 * SxtField
 * Table
 * 使用反射读取注解的信息 ，模拟处理注解信息的流程
 *
 */
@SuppressWarnings("all")
public class Demo01 {
    public static void main(String[] args) {
        try {
            Class c = Class.forName("TestAnnotation.Student");

            //获得类的所有注解
            Annotation[] a = c.getDeclaredAnnotations();
            for (Annotation temp:a
                 ) {
                System.out.println(temp);
            }

            //获得类指定的注解
            Table t = (Table) c.getDeclaredAnnotation(Table.class);
            System.out.println(t.value());

            //获得类的属性的注解
            Field f = c.getDeclaredField("age");
            SxtField sxtField = f.getAnnotation(SxtField.class);

            System.out.println(sxtField.columnName()+"--"+ sxtField.type()+"--"+ sxtField.lenth());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}
