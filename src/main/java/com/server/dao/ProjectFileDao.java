package com.server.dao;

import com.server.pojo.ProjectFile;
import com.server.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
}
