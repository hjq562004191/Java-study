package StudentServer.denglu;

import StudentServer.menu.Checkid;
import StudentServer.mysql.JDBCUnity;

import java.sql.*;
import java.util.Scanner;

public class zhuceteacher {
    public void zhuce() {
        System.out.println("\t\t\t\t注册教师账号");
        Scanner scanner = new Scanner(System.in);
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = JDBCUnity.getconnection("teacherdata");

            ps = con.prepareStatement("insert into teacher (teacherid,pwd,class) values (?,?,?)");
            System.out.print("\t\t\t\t请输入账号:");
            String id;
            while (true) {
                id = scanner.nextLine();
                boolean f = new Checkid(id).checkteacher();
                if (f) {
                    System.out.println("\t\t\t\t账号重复，请重新输入！");
                    System.out.print("\t\t\t\t请输入账号:");
                }
                else break;
            }
            ps.setObject(1, id);
            System.out.print("\t\t\t\t请输入密码:");
            String pwd = scanner.nextLine();
            ps.setObject(2, pwd);
            System.out.print("\t\t\t\t\t班级:");
            int classid = scanner.nextInt();
            ps.setObject(3, classid);

            ps.execute();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
