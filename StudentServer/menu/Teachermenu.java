package StudentServer.menu;

import StudentServer.mysql.JDBCUnity;
import StudentServer.server.StudentDemo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@SuppressWarnings("all")
public class Teachermenu {
     private int classid;
     List< StudentDemo> list = new ArrayList<>();
     public Teachermenu(int classid){
         this.classid = classid;
     }


    public void menu() {
        int choice;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            read();
            System.out.println("\t\t\t\t----------------1.信息添加----------------");
            System.out.println("\t\t\t\t----------------2.信息查看----------------");
            System.out.println("\t\t\t\t----------------3.信息修改----------------");
            System.out.println("\t\t\t\t----------------4.信息删除----------------");
            System.out.println("\t\t\t\t----------------5.信息查询----------------");
            System.out.println("\t\t\t\t----------------6.成绩排名----------------");
            System.out.println("\t\t\t\t--------------7.修改教师密码--------------");
            System.out.println("\t\t\t\t----------------0.退出    ----------------");
            System.out.print("\t\t\t\t\t\t请输入你要进行的操作:");
            choice = scanner.nextInt();
            if (choice == 0) break;
            switch (choice) {
                case 1:
                    add();
                    break;//添加学生信息
                case 2:
                    show();
                    break;
                case 3:
                    change();
                    break;//修改学生信息
                case 4:
                    delete();
                    break;//删除学生信息
                case 5:
                    find();
                    break;//查询学生信息
                case 6:
                    sort();
                    break;
                case 7:
                    changeteacher();
                    break;
            }
        }
    }
    public void changeteacher(){
        int choice;
        Scanner scanner = new Scanner(System.in);
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = JDBCUnity.getconnection("teacherdata");

            System.out.print("\t\t\t\t教师账号：");
            String tid = scanner.nextLine();
            if (tid.equals("")){
                System.out.println("\t\t\t\t账号不能为空！");
                tid = scanner.nextLine();
            }
            System.out.print("\t\t\t\t密码改为：");
            String pwd = scanner.nextLine();
            if (pwd.equals("")){
                System.out.println("\t\t\t\t密码不能为空！");
                pwd = scanner.nextLine();
            }
            ps = con.prepareStatement("update teacher set pwd=? where teacherid=?;");
            ps.setString(1,pwd);
            ps.setString(2,tid);
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("修改成功！");
        try {
            Thread.currentThread().sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void find(){
        Scanner scanner = new Scanner(System.in);
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        System.out.print("\t\t\t\t请输入要查询的学生学号:");
        String id = scanner.nextLine();

        try {
            con = JDBCUnity.getconnection("studentdata");
            ps = con.prepareStatement("select * from student where stuid=?");
            ps.setString(1,id);
            rs = ps.executeQuery();
            System.out.println("*********************************************************************************************");
            while (rs.next()) {
                int sum = rs.getInt(7)+rs.getInt(5)+rs.getInt(6);
                System.out.println("\t\t\t\t|学号：" + rs.getString(2) + "|" + "姓名：" + rs.getString(3) + "|" + "密码：" +
                        rs.getString(4) + "|" + "数学：" + rs.getInt(5) + "|" + "英语：" + rs.getInt(6) + "|" +
                        "Java：" + rs.getInt(7) + "|" + "Sum：" + sum+ "|"+"班级：" + rs.getInt(8) + "|");
            }
            System.out.println("*********************************************************************************************");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void change(){
        int choice;
        Scanner scanner = new Scanner(System.in);
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean f = false;
        System.out.print("\t\t\t\t请输入学号:");
        String id = scanner.nextLine();
        for (StudentDemo t:list
             ) {
            if (t.getId().equals(id)){
                f = true;
                break;
            }
        }
        if (f == false){
            System.out.println("\t\t\t\t此老师名下无此学生！或者此学生没有注册！");
            return;
        }
        try {
            con = JDBCUnity.getconnection("studentdata");

            System.out.println("\t\t\t\t----------------1.修改姓名----------------");
            System.out.println("\t\t\t\t----------------2.修改学号----------------");
            System.out.println("\t\t\t\t----------------3.修改密码----------------");
            System.out.println("\t\t\t\t----------------4.修改数学----------------");
            System.out.println("\t\t\t\t----------------5.修改英语----------------");
            System.out.println("\t\t\t\t----------------6.修改Java----------------");
            System.out.println("\t\t\t\t----------------7.修改班级----------------");
            System.out.println("\t\t\t\t----------------0.退出    ----------------");
            System.out.print("\t\t\t\t\t\t请输入你要进行的操作:");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("\t\t\t\t姓名改为：");
                    String name = scanner.nextLine();
                    ps = con.prepareStatement("update student set stuname=? where stuid=? and class=?;");
                    ps.setString(1,name);
                    ps.setString(2,id);
                    ps.setInt(3,classid);
                    ps.execute();
                    break;
                case 2:
                    System.out.print("\t\t\t\t学号改为：");
                    String id1 = scanner.nextLine();
                    ps = con.prepareStatement("update student set stuid=? where stuid=? and class=?;");
                    ps.setString(1,id1);
                    ps.setString(2,id);
                    ps.setInt(3,classid);
                    ps.execute();
                    break;
                case 3:
                    System.out.print("\t\t\t\t密码改为：");
                    String pwd = scanner.nextLine();
                    ps = con.prepareStatement("update student set pwd=? where stuid=? and class=?");
                    ps.setString(1,pwd);
                    ps.setString(2,id);
                    ps.setInt(3,classid);
                    ps.execute();
                    break;
                case 4:
                    System.out.print("\t\t\t\t数学改为：");
                    String math1 = scanner.nextLine();
                    ps = con.prepareStatement("update student set math=? where stuid=? and class=?;");
                    ps.setString(1,math1);
                    ps.setString(2,id);
                    ps.setInt(3,classid);
                    ps.execute();
                    break;
                case 5:
                    System.out.print("\t\t\t\t英语改为：");
                    String eng1 = scanner.nextLine();
                    ps = con.prepareStatement("update student set eng=? where stuid=? and class=?;");
                    ps.setString(1,eng1);
                    ps.setString(2,id);
                    ps.setInt(3,classid);
                    ps.execute();
                    break;
                case 6:
                    System.out.print("\t\t\t\tJava改为：");
                    String java1 = scanner.nextLine();
                    ps = con.prepareStatement("update student set java=? where stuid=? and class=?;");
                    ps.setString(1,java1);
                    ps.setString(2,id);
                    ps.setInt(3,classid);
                    ps.execute();
                    break;
                case 7:
                    System.out.print("\t\t\t\t班级改为：");
                    int classid1 = scanner.nextInt();
                    ps = con.prepareStatement("update student set class=? where stuid=? and class=?;");
                    ps.setInt(1,classid1);
                    ps.setString(2,id);
                    ps.setInt(3,classid);
                    ps.execute();
                    break;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sort(){

        int choice;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            read();
            System.out.println("\t\t\t\t----------------1.数学排名----------------");
            System.out.println("\t\t\t\t----------------2.英语排名----------------");
            System.out.println("\t\t\t\t----------------3.Java排名----------------");
            System.out.println("\t\t\t\t----------------4.总分排名----------------");
            System.out.println("\t\t\t\t----------------0.退出    ----------------");
            System.out.print("\t\t\t\t\t\t请输入你要进行的操作:");
            choice = scanner.nextInt();
            if (choice == 0) break;
            switch (choice) {
                case 1:
                    Collections.sort(list, new Comparator<StudentDemo>() {
                        @Override
                        public int compare(StudentDemo o1, StudentDemo o2) {
                            return -1 * ((Integer)(o1.getMath())).compareTo((Integer)o2.getMath());
                        }
                    });
                    break;
                case 2:
                    Collections.sort(list, new Comparator<StudentDemo>() {
                        @Override
                        public int compare(StudentDemo o1, StudentDemo o2) {
                            return -1 * ((Integer)(o1.getEnglish())).compareTo((Integer)o2.getEnglish());
                        }
                    });
                    break;
                case 3:
                    Collections.sort(list, new Comparator<StudentDemo>() {
                        @Override
                        public int compare(StudentDemo o1, StudentDemo o2) {
                            return -1 * ((Integer)(o1.getJava())).compareTo((Integer)o2.getJava());
                        }
                    });
                    break;
                case 4:
                    Collections.sort(list, new Comparator<StudentDemo>() {
                        @Override
                        public int compare(StudentDemo o1, StudentDemo o2) {
                            return -1 * ((Integer)(o1.getSum())).compareTo((Integer)o2.getSum());
                        }
                    });
                    break;
            }
            show();
        }


    }

    public void show(){
        System.out.println("*********************************************************************************************");
        for ( StudentDemo t:list
             ) {
            System.out.println("\t\t|学号："+t.getId()+"|"+"姓名："+t.getName()+"|"+"密码："+
                    t.getPwd()+"|"+"数学："+t.getMath()+"|"+"英语："+t.getEnglish()+"|"+"Java："+t.getJava()+
                    "|"+"Sum："+t.getSum()+"|"+"Class："+t.getClassid()+"|");
        }
        System.out.println("*********************************************************************************************");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public void add() {
        Scanner scanner = new Scanner(System.in);
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        int choice;
        while (true) {
            try {
                con = JDBCUnity.getconnection("studentdata");
                ps = con.prepareStatement("insert into student (stuid,stuname,pwd,math,eng,java,class) values (?,?,?,?,?,?,?)");
                System.out.print("\t\t\t\t请输入学生id:");
                String id;
                while (true) {
                    id = scanner.nextLine();
                    if (id.equals("")){
                        System.out.println("学号不能为空！");
                        return;
                    }
                    boolean f = new Checkid(id).checkstudent();
                    if (f) {
                        System.out.println("\t\t\t\t学号重复，请重新输入！");
                        System.out.print("\t\t\t\t请输入学生id:");
                    }
                    else break;
                }
                ps.setObject(1, id);
                System.out.print("\t\t\t\t请输入学生name:");
                String name = scanner.nextLine();
                if (name.equals("")){
                    System.out.println("\t\t\t\t姓名不能为空！");
                    return;
                }
                ps.setObject(2, name);
                System.out.print("\t\t\t\t请输入学生密码:");
                String pwd = scanner.nextLine();
                if (pwd.equals("")){
                    System.out.println("\t\t\t\t密码不能为空！");
                    return;
                }
                ps.setObject(3, pwd);
                System.out.print("\t\t\t\t数学:");int math = scanner.nextInt();
                System.out.print("\t\t\t\t英语:");int eng = scanner.nextInt();
                System.out.print("\t\t\t\tJava:");int java = scanner.nextInt();
                ps.setInt(4,math);
                ps.setInt(5,eng);
                ps.setInt(6,java);
                int classid1 = classid;
                ps.setInt(7,classid1);

                ps.execute();

            } catch (Exception e) {
                e.printStackTrace();
            }

            System.out.println("\t\t\t\t添加学生，按0退出，按1继续");
            choice = scanner.nextInt();
            if (choice == 0) break;
        }
    }

    public void delete() {
        Scanner scanner = new Scanner(System.in);
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
            try {
                con = JDBCUnity.getconnection("studentdata");
                System.out.println("\t\t\t\t按名称删除-->'1'    按学号删除-->'2'");
                int choice = scanner.nextInt();
                if (choice == 1) {
                    ps = con.prepareStatement("delete from student where stuname=? and class=?");
                    System.out.println("\t\t\t\t请输入学生name");
                    scanner.nextLine();
                    String name = scanner.nextLine();
                    if (name.equals("")){
                        System.out.println("\t\t\t\t姓名不能为空！");
                        return;
                    }
                    ps.setObject(1, name);
                    ps.setObject(2, classid);
                }else {
                    ps = con.prepareStatement("delete from student where stuid=? and class=?");
                    System.out.println("\t\t\t\t请输入学生id");
                    scanner.nextLine();
                    String id = scanner.nextLine();
                    if (id.equals("")){
                        System.out.println("\t\t\t\t学号不能为空！");
                        return;
                    }
                    ps.setObject(1, id);
                    ps.setObject(2, classid);
                }

                ps.execute();

            } catch (Exception e) {
                e.printStackTrace();
            }

    }

    public void read() {
        list.clear();
        Scanner scanner = new Scanner(System.in);
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = JDBCUnity.getconnection("studentdata");
            ps = con.prepareStatement("select stuid,stuname,pwd,math,eng,java,class from student where id>=? and class=?");
            ps.setObject(1, 0);
            ps.setInt(2,classid);
            rs = ps.executeQuery();

            while (rs.next()) {
                int sum = rs.getInt(4)+rs.getInt(5)+rs.getInt(6);
                StudentDemo stu =new StudentDemo(rs.getString(1),rs.getString(2),
                        rs.getString(3),rs.getInt(4),
                        rs.getInt(5),rs.getInt(6),sum,rs.getInt(7));

                list.add(stu);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
