package com.server.dao;

import com.server.pojo.Book;
import com.server.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDao {
    DBUtil util = new DBUtil();

    public boolean insertBook(Book bk) {
        String sql = "insert into studiofile.book(b_name,b_provide,w_id) value(?,?,?)";
        // 获得连接
        Connection conn = util.getConnection();
        try {
            // 获得预定义语句
            PreparedStatement pstmt = conn.prepareStatement(sql);
            // 设置插入参数
            pstmt.setString(1,bk.getB_name());
            pstmt.setString(2,bk.getB_provide());
            pstmt.setInt(3,bk.getW_id());
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


    public List<Book> getOneWRBook(int w_id) {
        // T-SQL语句
        String sql = "select * from studiofile.book where w_id=?";
        // 获得连接
        Connection conn = util.getConnection();
        try {
            // 获得预定义语句
            PreparedStatement pstmt = conn.prepareStatement(sql);
            // 执行查询
            pstmt.setInt(1,w_id);
            ResultSet rs = pstmt.executeQuery();
            List<Book> bkList=new ArrayList<Book>();
            while (rs.next()) {
                // 封装信息
                Book bk=new Book();
                bk.setB_id(rs.getInt(1));
                bk.setB_name(rs.getString(2));
                bk.setB_status(rs.getInt(3));
                bk.setB_provide(rs.getString(4));
                bk.setU_id(rs.getInt(5));
                bk.setW_id(rs.getInt(6));
                bkList.add(bk);
            }
            conn.close();
            return bkList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean changeStatus(int b_id,int b_status,int u_id) {
        String sql = "update studiofile.book set b_status=?,u_id=? where b_id=?";
        // 获得连接
        Connection conn = util.getConnection();
        try {
            // 获得预定义语句
            PreparedStatement pstmt = conn.prepareStatement(sql);
            // 设置插入参数
            pstmt.setInt(1,b_status);
            pstmt.setInt(2,u_id);
            pstmt.setInt(3,b_id);
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
