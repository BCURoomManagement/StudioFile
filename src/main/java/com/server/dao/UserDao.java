package com.server.dao;

import com.server.pojo.User;
import com.server.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    DBUtil util = new DBUtil();

    public User checkUser(String u_account,String u_password) {
        // T-SQL语句
        String sql = "select * from studiofile.user where u_account=? and u_password=?";
        // 获得连接
        Connection conn = util.getConnection();
        try {
            // 获得预定义语句
            PreparedStatement pstmt = conn.prepareStatement(sql);
            // 执行查询
            pstmt.setString(1,u_account);
            pstmt.setString(2,u_password);

            ResultSet rs = pstmt.executeQuery();
            User us=new User();
            while (rs.next()) {
                // 封装信息
                us.setU_id(rs.getInt(1));
                us.setW_id(rs.getInt(2));
                us.setU_account(rs.getString(3));
                us.setU_password(rs.getString(4));
                us.setU_name(rs.getString(5));
                us.setU_class(rs.getString(6));
                us.setU_grade(rs.getString(7));
                us.setU_type(rs.getInt(8));

            }
            conn.close();
            return us;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean insertAccount(User us) {
        String sql = "insert into studiofile.user(w_id,u_account,u_password,u_name,u_class,u_grade,u_type) values(?,?,?,?,?,?,?)";
        // 获得连接
        Connection conn = util.getConnection();
        try {
            // 获得预定义语句
            PreparedStatement pstmt = conn.prepareStatement(sql);
            // 设置插入参数
            pstmt.setInt(1,us.getW_id());
            pstmt.setString(2,us.getU_account());
            pstmt.setString(3,us.getU_password());
            pstmt.setString(4,us.getU_name());
            pstmt.setString(5,us.getU_class());
            pstmt.setString(6,us.getU_grade());
            pstmt.setInt(7,us.getU_type());

            // 执行插入
            if (pstmt.executeUpdate() > 0) {
                conn.close();
                return true;
            } else {
                conn.close();
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
