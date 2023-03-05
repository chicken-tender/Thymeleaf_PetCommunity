package com.kh.Jdbc.dao;
import com.kh.Jdbc.vo.PetVO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PetDAO {
    Connection conn = null;
    Statement stmt = null;
    PreparedStatement pStmt = null;
    ResultSet rs = null;
    Scanner sc = new Scanner(System.in);

    public List<PetVO> petAll() {
        List<PetVO> list = new ArrayList<>();
        String sql = "SELECT * FROM PET ORDER BY PET_BDAY ASC, PET_GENDER DESC";
        try {
            conn = com.kh.Jdbc.common.Common.getConnection();
            pStmt = conn.prepareStatement(sql);
            rs = pStmt.executeQuery();

            while (rs.next()) {
                String id = rs.getString("USER_ID");
                String petName = rs.getString("PET_NAME");
                String petGender = rs.getString("PET_GENDER");
                String petBday = rs.getString("PET_BDAY");
                String petSpec = rs.getString("PET_SPEC");
                PetVO vo = new PetVO(petName, id, petGender, petBday, petSpec);
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

    public void registerPet(PetVO pvo) {
        String sql = "INSERT INTO PET VALUES(?,?,?,?,?)";
        try {
            conn = com.kh.Jdbc.common.Common.getConnection();
            pStmt = conn.prepareStatement(sql);
            pStmt.setString(1, pvo.getId());
            pStmt.setString(2, pvo.getPetName());
            pStmt.setString(3, pvo.getPetGender());
            pStmt.setString(4, pvo.getPetBday());
            pStmt.setString(5, pvo.getPetSpec());
            pStmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        com.kh.Jdbc.common.Common.close(pStmt);
        com.kh.Jdbc.common.Common.close(conn);
    }
}
