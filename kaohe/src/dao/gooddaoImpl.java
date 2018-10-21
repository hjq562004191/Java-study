package dao;

import user.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class gooddaoImpl implements gooddao {
    @Override
    public void add(User user) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/goods?useSSL=false&serverTimezone=UTC&characterEncoding=utf-8&allowPublicKeyRetrieval=true","root","qqq1234");
            String sql = "insert into goods (gname,gtype,gchandi,gdate,gnum) values (?,?,?,?,?);";
            ps = conn.prepareStatement(sql);
            ps.setString(1,user.getGname());
            ps.setString(2,user.getType());
            ps.setString(3,user.getChandi());
            ps.setString(4,user.getDate());
            ps.setInt(5,user.getNum());

            ps.execute();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> read() {
        List<User> list = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/goods?useSSL=false&serverTimezone=UTC&characterEncoding=utf-8&allowPublicKeyRetrieval=true","root","qqq1234");
            String sql = "select * from goods;";
            ps = conn.prepareStatement(sql);

            rs = ps.executeQuery();
            list = new ArrayList<>();

            while (rs.next()){
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setGname(rs.getString("gname"));
                user.setType(rs.getString("gtype"));
                user.setChandi(rs.getString("gchandi"));
                user.setDate(rs.getString("gdate"));
                user.setNum(rs.getInt("gnum"));
                list.add(user);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void dele(String id) {
        Connection conn = null;
    ResultSet rs = null;
    PreparedStatement ps = null;
    User u = null;
    boolean i = false;
        try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/goods?useSSL=false&serverTimezone=UTC&characterEncoding=utf-8&allowPublicKeyRetrieval=true","root","qqq1234");
        String sql = "delete from goods where id=?;";
        ps = conn.prepareStatement(sql);
        ps.setString(1,id);
        ps.execute();

    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

    @Override
    public void change(User user) {
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/goods?useSSL=false&serverTimezone=UTC&characterEncoding=utf-8&allowPublicKeyRetrieval=true","root","qqq1234");
            String sql = "update goods set gname=?,gtype=?,gchandi=?,gdate=?,gnum=? where id=?;";
            ps = conn.prepareStatement(sql);
            ps.setString(1,user.getGname());
            ps.setString(2,user.getType());
            ps.setString(3,user.getChandi());
            ps.setString(4,user.getDate());
            ps.setInt(5,user.getNum());
            ps.setInt(6,user.getId());
            ps.executeUpdate();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
