package com.server.dao;

import com.server.pojo.Software;
import com.server.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SoftwareDao {
    DBUtil util = new DBUtil();
    public boolean insertCompetition(Software sw) {
        String sql = "insert into studiofile.software(u_id,s_name,s_time,s_software,s_version) values(?,?,?,?,?)";
        // 获得连接
        Connection conn = util.getConnection();
        try {
            // 获得预定义语句
            PreparedStatement pstmt = conn.prepareStatement(sql);
            // 设置插入参数
            pstmt.setInt(1,sw.getU_id());
            pstmt.setString(2,sw.getS_name());
            pstmt.setString(3,sw.getS_time());
            pstmt.setString(4,sw.getS_software());
            pstmt.setString(5,sw.getS_version());
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

    public List<Software> getOneSWcp(int w_id) {
        // T-SQL语句
        String sql = "select * from studiofile.software where u_id in (select u_id from studiofile.user where w_id=?) ";
        // 获得连接
        Connection conn = util.getConnection();
        try {
            // 获得预定义语句
            PreparedStatement pstmt = conn.prepareStatement(sql);
            // 执行查询
            pstmt.setInt(1 ,w_id);
            ResultSet rs = pstmt.executeQuery();
            List<Software> swList=new ArrayList<Software>();
            while (rs.next()) {
                // 封装信息
                Software sw=new Software();
                sw.setS_id(rs.getInt(1));
                sw.setU_id(rs.getInt(2));
                sw.setS_name(rs.getString(3));
                sw.setS_time(rs.getString(4));
                sw.setS_software(rs.getString(5));
                sw.setS_version(rs.getString(6));
                swList.add(sw);
            }
            conn.close();
            return swList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean deleteSoftware(int s_id) {
        String sql = "delete from studiofile.software where s_id=?";
        // 获得连接
        Connection conn = util.getConnection();
        try {
            // 获得预定义语句
            PreparedStatement pstmt = conn.prepareStatement(sql);
            // 设置插入参数
            pstmt.setInt(1,s_id);

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

    public Software getOneSW(int s_id) {
        // T-SQL语句
        String sql = "select * from studiofile.software where s_id=?";
        // 获得连接
        Connection conn = util.getConnection();
        try {
            // 获得预定义语句
            PreparedStatement pstmt = conn.prepareStatement(sql);
            // 执行查询
            pstmt.setInt(1 ,s_id);
            ResultSet rs = pstmt.executeQuery();
            Software sw=new Software();
            while (rs.next()) {
                // 封装信息
                sw.setS_id(rs.getInt(1));
                sw.setU_id(rs.getInt(2));
                sw.setS_name(rs.getString(3));
                sw.setS_time(rs.getString(4));
                sw.setS_software(rs.getString(5));
                sw.setS_version(rs.getString(6));
            }
            conn.close();
            return sw;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public boolean updateSoftware(Software sw) {
        String sql = "update  studiofile.software set s_time=?,s_name=?,s_software=?,s_version=? where s_id=?";
        // 获得连接
        Connection conn = util.getConnection();
        try {
            // 获得预定义语句
            PreparedStatement pstmt = conn.prepareStatement(sql);
            // 设置插入参数
            pstmt.setString(1,sw.getS_time());
            pstmt.setString(2,sw.getS_name());
            pstmt.setString(3,sw.getS_software());
            pstmt.setString(4,sw.getS_version());
            pstmt.setInt(5,sw.getS_id());

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
