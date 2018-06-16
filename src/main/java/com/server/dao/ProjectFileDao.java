package com.server.dao;

import com.server.pojo.ProjectFile;
import com.server.pojo.Workroom;
import com.server.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProjectFileDao {
    DBUtil util = new DBUtil();

    public boolean insertProjectFile(ProjectFile pf) {
        String sql = "insert into studiofile.projectfile(u_id,p_name,p_time) values(?,?,?)";
        // 获得连接
        Connection conn = util.getConnection();
        try {
            // 获得预定义语句
            PreparedStatement pstmt = conn.prepareStatement(sql);
            // 设置插入参数
            pstmt.setInt(1,pf.getU_id());
            pstmt.setString(2,pf.getP_name());
            pstmt.setString(3,pf.getP_time());

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

    public List<ProjectFile> getOneWRpf(int w_id) {
        // T-SQL语句
        String sql = "select * from studiofile.projectfile where u_id in (select u_id from studiofile.user where w_id=?) ";
        // 获得连接
        Connection conn = util.getConnection();
        try {
            // 获得预定义语句
            PreparedStatement pstmt = conn.prepareStatement(sql);
            // 执行查询
            pstmt.setInt(1 ,w_id);
            ResultSet rs = pstmt.executeQuery();
            List<ProjectFile> pfList=new ArrayList<ProjectFile>();
            while (rs.next()) {
                // 封装信息
                ProjectFile pf=new ProjectFile();
                pf.setP_id(rs.getInt(1));
                pf.setU_id(rs.getInt(2));
                pf.setP_word(rs.getString(3));
                pf.setP_code(rs.getString(4));
                pf.setP_name(rs.getString(5));
                pf.setP_video(rs.getString(6));
                pf.setP_time(rs.getString(7));
                pfList.add(pf);
            }
            conn.close();
            return pfList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
