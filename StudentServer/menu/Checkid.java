package StudentServer.menu;

import StudentServer.mysql.JDBCUnity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class Checkid {
    private String id;
    public Checkid(String id){
        this.id = id;
    }
    List<String> checklist = new ArrayList<>();
    public boolean checkstudent(){
        checklist.clear();
        boolean f = false;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = JDBCUnity.getconnection("studentdata");
            ps = con.prepareStatement("select stuid from student where id>=?");
            ps.setObject(1, 0);

            rs = ps.executeQuery();

            while (rs.next()) {
                checklist.add(rs.getString(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (String t:checklist
             ) {
            if (t.equals(id)){
                f = true;
                break;
            }
        }

        return f;
    }
    public boolean checkteacher(){
        checklist.clear();
        boolean f = false;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = JDBCUnity.getconnection("teacherdata");
            ps = con.prepareStatement("select teacherid from teacher where id>=?");
            ps.setObject(1, 0);

            rs = ps.executeQuery();

            while (rs.next()) {
                checklist.add(rs.getString(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (String t:checklist
                ) {
            if (t.equals(id)){
                f = true;
                break;
            }
        }

        return f;
    }

}
