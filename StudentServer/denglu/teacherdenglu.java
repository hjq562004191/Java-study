package StudentServer.denglu;

import StudentServer.mysql.JDBCUnity;
import StudentServer.server.TeacherDemo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

public class teacherdenglu {
    List<TeacherDemo> list = new ArrayList<>();

    public void read() {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = JDBCUnity.getconnection("teacherdata");
            ps = con.prepareStatement("select teacherid,pwd,class from teacher where id>=0");

            rs = ps.executeQuery();
            while (rs.next()) {
                TeacherDemo teacherDemo = new TeacherDemo(rs.getString("teacherid"),rs.getString("pwd")
                ,rs.getInt("class"));
                list.add(teacherDemo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public int denglu() throws InterruptedException {
        list.clear();
        read();
        int f = 0;
        String pwd1 = null;
        if (list.isEmpty()){
            System.out.println("\t\t\t\t目前还没有教师注册!");
        }else{
        Scanner scanner = new Scanner(System.in);
        System.out.print("\t\t\t\t请输入账号:");
        String id = scanner.nextLine();
            for (TeacherDemo t:list
                 ) {
                if (t.getId().equals(id)){
                    while (true) {
                        System.out.print("\t\t\t\t请输入密码:");
                        pwd1 = scanner.nextLine();
                        if (pwd1.equals(t.getPwd())) {
                            f = t.getClassid();
                            break;
                        }else {
                            System.out.println("\t\t\t\t密码错误，请重新输入！");
                        }
                    }
                }
            }

        if (f == 0) {
            System.out.println("\t\t\t\t无此账号!");
            Thread.sleep(1500);
        }
    }
    return f;
    }
}
