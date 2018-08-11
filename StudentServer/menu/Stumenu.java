package StudentServer.menu;

import StudentServer.mysql.JDBCUnity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

@SuppressWarnings("all")
public class Stumenu {
    int ID;
    public Stumenu(Integer ID){
        this.ID = ID;
    }
    public void menu() {

        int choice;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\t\t\t\t----------------1.信息查看----------------");
            System.out.println("\t\t\t\t----------------2.信息修改----------------");
            System.out.println("\t\t\t\t----------------0.退出    ----------------");
            System.out.print("\t\t\t\t\t\t请输入你要进行的操作:");
            choice = scanner.nextInt();
            if (choice == 0) break;
            switch (choice) {
                case 1:
                    see();
                    break;
                case 2:
                    change();
                    break;
            }
        }
    }


    public void see(){
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

            try {
                con = JDBCUnity.getconnection("studentdata");
                ps = con.prepareStatement("select * from student where id=?");
                ps.setInt(1,ID);
                rs = ps.executeQuery();
                System.out.println("*********************************************************************************************");
                while (rs.next()) {
                    int sum = rs.getInt(7)+rs.getInt(5)+rs.getInt(6);
                    System.out.println("\t\t|学号：" + rs.getString(2) + "|" + "姓名：" + rs.getString(3) + "|" + "密码：" +
                            rs.getString(4) + "|" + "数学：" + rs.getInt(5) + "|" + "英语：" + rs.getInt(6) + "|" +
                            "Java：" + rs.getInt(7) + "|" + "Sum：" + sum+ "|"+ "班级：" + rs.getInt(8)+ "|");
                }
                System.out.println("*********************************************************************************************");
            } catch (Exception e) {
                e.printStackTrace();
            }

    }

    public void change() {
        int choice;
        Scanner scanner = new Scanner(System.in);
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

            try {
                con = JDBCUnity.getconnection("studentdata");

                    System.out.println("\t\t\t\t----------------1.修改姓名----------------");
                    System.out.println("\t\t\t\t----------------2.修改学号----------------");
                    System.out.println("\t\t\t\t----------------3.修改密码----------------");
                    System.out.println("\t\t\t\t----------------0.退出    ----------------");
                    System.out.println("\t\t\t\t\t\t请输入你要进行的操作:");
                    choice = scanner.nextInt();
                    scanner.nextLine();
                    switch (choice) {
                        case 1:
                            System.out.print("\t\t\t\t姓名改为：");
                            String name = scanner.nextLine();
                            ps = con.prepareStatement("update student set stuname=? where id=ID;");
                            ps.setString(1,name);
                            ps.execute();
                            break;
                        case 2:
                            System.out.print("\t\t\t\t学号改为：");
                            String id = scanner.nextLine();
                            ps = con.prepareStatement("update student set stuid=? where id=ID;");
                            ps.setString(1,id);
                            ps.execute();
                            break;
                        case 3:
                            System.out.print("\t\t\t\t密码改为：");
                            String pwd = scanner.nextLine();
                            ps = con.prepareStatement("update student set pwd=? where id=ID");
                            ps.setString(1,pwd);
                            ps.execute();
                            break;
                    }

            } catch (Exception e) {
                e.printStackTrace();
            }
    }
}
