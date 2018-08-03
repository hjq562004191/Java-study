package TestAnnotation;


@MyAnnotation
public class Demo02 {
    @MyAnnotation(age = 19,studentname = "强强",id = 1001,
            schools = "清华大学")
    public void test(){

    }
    @MyAnnotation02("aaaa")
    public void test02(){

    }
}
