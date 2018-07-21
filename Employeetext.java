package cn.test;

import java.time.LocalDate;

public class Employeetext {
    public static void main(String[] args) {
        Employee[] staff = new Employee[2];

        staff[0] = new Employee("张三",1000,2018,6,6);
        staff[1] = new Employee("李四",1200,2018,6,9);

        for (Employee e:staff)
        {
            e.raiseSalary(5);
        }
        for (Employee e:staff)
            System.out.println("name"+e.getName()+",salary:"+e.getSalary()+",hireday:"+e.getHireDay());
    }
}
class Employee{
    private String name;
    private double salary;
    private LocalDate hireDay;

    public Employee(String n,double s,int year,int mon,int day){
        name = n;
        salary = s;
        hireDay = LocalDate.of(year,mon,day);
    }

    public String getName(){
        return name;
    }
    public  double getSalary(){
        return salary;
    }

    public LocalDate getHireDay() {
        return hireDay;
    }
    public void raiseSalary(double byPercent){
        double raise = salary * byPercent / 100;
        salary += raise;
    }
}