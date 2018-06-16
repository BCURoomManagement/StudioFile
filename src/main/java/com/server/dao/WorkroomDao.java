package com.server.dao;

import com.server.pojo.Workroom;
import com.server.util.DBUtil;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class WorkroomDao {
    DBUtil util = new DBUtil();

    public List<Workroom> getAllWrokroom() {
        // T-SQL语句
        String sql = "select * from workroom";
        // 获得连接
        Connection conn = util.getConnection();
        try {
            // 获得预定义语句
            PreparedStatement pstmt = conn.prepareStatement(sql);
            // 执行查询

            ResultSet rs = pstmt.executeQuery();
            List<Workroom> wrList=new ArrayList<Workroom>();
            while (rs.next()) {
                // 封装信息
                Workroom wr=new Workroom();
                wr.setW_id(rs.getInt(1));
                wr.setW_name(rs.getString(2));
                wrList.add(wr);
            }
            conn.close();
            return wrList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public  String getName(int w_id) {
        // T-SQL语句
        String sql = "select w_name from studiofile.workroom where w_id=?";
        // 获得连接
        Connection conn = util.getConnection();
        try {
            // 获得预定义语句
            PreparedStatement pstmt = conn.prepareStatement(sql);
            // 执行查询
            pstmt.setInt(1,w_id);
            ResultSet rs = pstmt.executeQuery();
            String  name="";
            while (rs.next()) {
                // 封装信息
              name=rs.getString(1);
            }
            conn.close();
            return name;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
