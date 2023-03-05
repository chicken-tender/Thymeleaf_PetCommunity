package com.kh.Jdbc.dao;
import com.kh.Jdbc.vo.WriteVO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WriteDAO {
    Connection conn = null;
    Statement stmt = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    Scanner sc = new Scanner(System.in);
    MemberDAO mdao = new MemberDAO();

    public List<WriteVO> getEntireList() {
        List<WriteVO> list = new ArrayList<>();
        try {
            conn = com.kh.Jdbc.common.Common.getConnection();
            stmt = conn.createStatement();
            String sql = "SELECT BOARD_NUM, BOARD_NAME, USER_ID, TITLE, REG_DATE FROM WRITE ORDER BY REG_DATE DESC";
            rs = stmt.executeQuery(sql);

            while(rs.next()) {
                int boardNum = rs.getInt("BOARD_NUM");
                String boardName = rs.getString("BOARD_NAME");
                String id = rs.getString("USER_ID");
                String title = rs.getString("TITLE");
                Date date = rs.getDate("REG_DATE");
                WriteVO vo = new WriteVO(boardNum, boardName, id, title, date);
                list.add(vo);
            }
            com.kh.Jdbc.common.Common.close(rs);
            com.kh.Jdbc.common.Common.close(stmt);
            com.kh.Jdbc.common.Common.close(conn);
        } catch(Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
