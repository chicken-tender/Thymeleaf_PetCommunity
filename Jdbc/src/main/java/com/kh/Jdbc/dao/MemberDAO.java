package com.kh.Jdbc.dao;

import com.kh.Jdbc.vo.MemberVO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MemberDAO {
    Connection conn = null;
    Statement stmt = null;
    PreparedStatement pStmt = null;
    ResultSet rs = null;
    Scanner sc = new Scanner(System.in);
    boolean isLogIn = false;
    public String loginId = null;

    public void signUp(MemberVO mvo) {

        String sql = "INSERT INTO MEMBER VALUES(?,?,?,?,?,SYSDATE)";

        try {
            conn = com.kh.Jdbc.common.Common.getConnection();
            pStmt = conn.prepareStatement(sql);
            pStmt.setString(1,mvo.getId());
            pStmt.setString(2,mvo.getPw());
            pStmt.setString(3,mvo.getName());
            pStmt.setString(4,mvo.getMail());
            pStmt.setString(5,mvo.getPhone());
            int ret = pStmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        com.kh.Jdbc.common.Common.close(pStmt);
        com.kh.Jdbc.common.Common.close(conn);
    }

    public List<MemberVO> memAll() {
        List<MemberVO> list = new ArrayList<>();

        String sql = " SELECT * " +
                " FROM MEMBER " +
                " ORDER BY JOIN_DATE DESC ";
        try {
            conn = com.kh.Jdbc.common.Common.getConnection();
            pStmt = conn.prepareStatement(sql);
            rs = pStmt.executeQuery(sql);

            while (rs.next()) {
                String id = rs.getString("USER_ID");
                String pw = rs.getString("USER_PW");
                String name = rs.getString("USER_PW");
                String mail = rs.getString("EMAIL");
                String phone = rs.getString("PHONE");
                Date joinDate = rs.getDate("JOIN_DATE");
                MemberVO vo = new MemberVO(id, pw, name, mail, phone, joinDate);
                list.add(vo);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        com.kh.Jdbc.common.Common.close(rs);
        com.kh.Jdbc.common.Common.close(pStmt);
        com.kh.Jdbc.common.Common.close(conn);
        return list;
    }
}
