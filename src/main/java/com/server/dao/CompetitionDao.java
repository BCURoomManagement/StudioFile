package com.server.dao;

import com.server.pojo.Competition;
import com.server.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CompetitionDao {
    DBUtil util = new DBUtil();
    public boolean insertCompetition(Competition cp) {
        String sql = "insert into studiofile.competition(u_id,c_time,c_word,c_code,c_name,c_certificate,c_video) values(?,?,?,?,?,?,?)";
        // 获得连接
        Connection conn = util.getConnection();
        try {
            // 获得预定义语句
            PreparedStatement pstmt = conn.prepareStatement(sql);
            // 设置插入参数
            pstmt.setInt(1,cp.getU_id());
            pstmt.setString(2,cp.getC_time());
            pstmt.setString(3,cp.getC_word());
            pstmt.setString(4,cp.getC_code());
            pstmt.setString(5,cp.getC_name());
            pstmt.setString(6,cp.getC_certificate());
            pstmt.setString(7,cp.getC_video());

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

    public List<Competition> getOneWRcp(int w_id) {
        // T-SQL语句
        String sql = "select * from studiofile.competition where u_id in (select u_id from studiofile.user where w_id=?) ";
        // 获得连接
        Connection conn = util.getConnection();
        try {
            // 获得预定义语句
            PreparedStatement pstmt = conn.prepareStatement(sql);
            // 执行查询
            pstmt.setInt(1 ,w_id);
            ResultSet rs = pstmt.executeQuery();
            List<Competition> cpList=new ArrayList<Competition>();
            while (rs.next()) {
                // 封装信息
               Competition cp=new Competition();
               cp.setC_id(rs.getInt(1));
               cp.setU_id(rs.getInt(2));
               cp.setC_time(rs.getString(3));
               cp.setC_word(rs.getString(4));
               cp.setC_code(rs.getString(5));
               cp.setC_name(rs.getString(6));
               cp.setC_certificate(rs.getString(7));
               cp.setC_video(rs.getString(8));
                cpList.add(cp);
            }
            conn.close();
            return cpList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean deleteCompetiton(int c_id) {
        String sql = "delete from studiofile.competition where c_id=?";
        // 获得连接
        Connection conn = util.getConnection();
        try {
            // 获得预定义语句
            PreparedStatement pstmt = conn.prepareStatement(sql);
            // 设置插入参数
            pstmt.setInt(1,c_id);

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

    public Competition getOneCp(int c_id) {
        // T-SQL语句
        String sql = "select * from studiofile.competition where c_id=?";
        // 获得连接
        Connection conn = util.getConnection();
        try {
            // 获得预定义语句
            PreparedStatement pstmt = conn.prepareStatement(sql);
            // 执行查询
            pstmt.setInt(1 ,c_id);
            ResultSet rs = pstmt.executeQuery();
            Competition cp=new Competition();
            while (rs.next()) {
                // 封装信息
                cp.setC_id(rs.getInt(1));
                cp.setU_id(rs.getInt(2));
                cp.setC_time(rs.getString(3));
                cp.setC_word(rs.getString(4));
                cp.setC_code(rs.getString(5));
                cp.setC_name(rs.getString(6));
                cp.setC_certificate(rs.getString(7));
                cp.setC_video(rs.getString(8));
            }
            conn.close();
            return cp;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean updateCompetition(Competition cp) {
        String sql = "update  studiofile.competition set c_time=?,c_word=?,c_code=?,c_name=?,c_certificate=?,c_video=? where c_id=?";
        // 获得连接
        Connection conn = util.getConnection();
        try {
            // 获得预定义语句
            PreparedStatement pstmt = conn.prepareStatement(sql);
            // 设置插入参数
            pstmt.setString(1,cp.getC_time());
            pstmt.setString(2,cp.getC_word());
            pstmt.setString(3,cp.getC_code());
            pstmt.setString(4,cp.getC_name());
            pstmt.setString(5,cp.getC_certificate());
            pstmt.setString(6,cp.getC_video());
            pstmt.setInt(7,cp.getC_id());

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
