package StudentServer.server;

public class StudentDemo {
    private String  id;
    private String name;
    private String pwd;
    private int Math = 0;
    private int Java = 0;
    private int English = 0;
    private int Sum;
    private int Classid;

    public StudentDemo(String id, String name, String pwd, int math, int china, int english, int sum,int Classid) {
        this.id = id;
        this.name = name;
        this.pwd = pwd;
        Math = math;
        Java = china;
        English = english;
        Sum = sum;
        this.Classid = Classid;
    }

    public int getClassid() {
        return Classid;
    }

    public void setClass(int aClass) {
        Classid = aClass;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public int getMath() {
        return Math;
    }

    public void setMath(int math) {
        Math = math;
    }

    public int getJava() {
        return Java;
    }

    public void setJava(int china) {
        Java = china;
    }

    public int getEnglish() {
        return English;
    }

    public void setEnglish(int english) {
        English = english;
    }

    public int getSum() {
        return English+Math+Java;
    }

    public void setSum(int sum) {
        Sum = sum;
    }

    public StudentDemo(int math, int china, int english) {
        Math = math;
        Java = china;
        English = english;
    }


}
