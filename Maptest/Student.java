package cn.hjq.Maptest;

public class Student {
    private String name;
    private String no;
    private double score;

    public Student(){

    }
    public Student(String name, String no, double score) {
        this.name = name;
        this.no = no;
        this.score = score;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getName() {

        return name;
    }

    public String getNo() {
        return no;
    }

    public double getScore() {
        return score;
    }
}
