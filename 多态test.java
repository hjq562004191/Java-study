package cn.test;

public class 多态test {
    public static void main(String[] args) {
    dongwu a = new dog();//子类可以自动转换为父类，子类之间不能胡转
    dongwuCry(a);
    dog b = new dog();
    dongwuCry(b);
    }
    static void dongwuCry(dongwu a)
    {
        a.shout();
    }
}

class dongwu{
    public void shout(){
        System.out.println("叫一声。。");
        }
}
class dog extends dongwu{
    public void shout() {
        System.out.println("汪汪汪。。。");
    }
}
class cat extends dongwu{
    public void shout() {
        System.out.println("喵喵喵。。");
    }
}