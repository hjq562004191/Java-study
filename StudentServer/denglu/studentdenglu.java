package StudentServer.denglu;

import StudentServer.mysql.JDBCUnity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;


public class studentdenglu {
    Map map = new HashMap();
    String pwd1 = null;
    String id1 = null;
    int ID ;
    public void read() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = JDBCUnity.getconnection("studentdata");
            ps = con.prepareStatement("select stuid,pwd from student where id>=?");
            ps.setObject(1, 0);

            rs = ps.executeQuery();

            while (rs.next()) {
                map.put(rs.getObject("stuid"),rs.getObject("pwd"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public int denglu() throws SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int f = 0;

        Scanner scanner = new Scanner(System.in);
        read();
        if (map.isEmpty()){
            System.out.println("\t\t\t\t目前还没有学生！");
        }else {
            System.out.print("\t\t\t\t请输入学号:");
            id1 = scanner.nextLine();
            Set set = map.keySet();
            Iterator it = set.iterator();
            while (it.hasNext()){
                if (it.next().equals(id1)){
                    while (true) {
                        System.out.print("\t\t\t\t请输入密码:");
                        pwd1 = scanner.nextLine();
                        if (pwd1.equals(map.get(id1))) {
                            con = JDBCUnity.getconnection("studentdata");
                            ps = con.prepareStatement("select id from student where stuid=? and pwd=?");
                            ps.setString(1, id1);
                            ps.setString(2, pwd1);
                            rs = ps.executeQuery();
                            while (rs.next())
                                ID = rs.getInt(1);
                            f = ID;
                            break;
                        }
                        System.out.println("\t\t\t\t密码错误！！请重新输入！！！");
                    }
                }
            }
        }
        if (f == 0){
            System.out.println("\t\t\t\t\t\t无此账号!");
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return f;
    }
}
