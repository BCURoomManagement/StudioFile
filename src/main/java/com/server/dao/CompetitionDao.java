package com.server.dao;

import com.server.pojo.Competition;
import com.server.pojo.ProjectFile;
import com.server.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
}
