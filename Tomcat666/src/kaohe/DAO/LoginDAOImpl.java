package kaohe.DAO;
import kaohe.User;


import java.sql.*;

@SuppressWarnings("all")
public class LoginDAOImpl implements LoginDAO {
    @Override
    public User checkLoginDAO(String uname, String pwd) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User u = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/userdata?useSSL=false&serverTimezone=UTC&characterEncoding=utf-8","root","qqq1234");
            String sql = "select * from t_user where uname=? and pwd=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,uname);
            ps.setString(2,pwd);

            rs = ps.executeQuery();

            while(rs.next()){
                u = new User();
                u.setUid(rs.getInt("uid"));
                u.setUname(rs.getString("uname"));
                u.setPwd(rs.getString("pwd"));

            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return u;
    }

    //校验cookie
    //根据uid获取用户信息
    @Override
    public User checkUidDAO(String uid) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User u = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/userdata?useSSL=false&serverTimezone=UTC&characterEncoding=utf-8","root","qqq1234");
            String sql = "select * from t_user where uid=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,uid);

            rs = ps.executeQuery();

            while(rs.next()){
                u = new User();
                u.setUid(rs.getInt("uid"));
                u.setUname(rs.getString("uname"));
                u.setPwd(rs.getString("pwd"));

            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return u;
    }
}
