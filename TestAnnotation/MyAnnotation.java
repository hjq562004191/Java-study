package TestAnnotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value = {ElementType.METHOD,ElementType.TYPE}) //此注解可以注解类、方法
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {

    String studentname() default "";
    int age() default 0;
    int id() default  -1;
    String[] schools() default {"北京大学","河北大学"};
}
