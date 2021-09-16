package com.kh.jdbc.member.model.dao;


import com.kh.jdbc.common.JDBCTemplate;
import com.kh.jdbc.member.model.vo.Member;

import java.sql.*;

import static com.kh.jdbc.common.JDBCTemplate.*;

public class MemberDAO {

    public int insertMember(Connection con, Member joinMember) {
        int result = 0; // 추가된 행의 수

        // Statement st = null;
        PreparedStatement ps = null;

        String sql = "INSERT INTO MEMBER VALUES "
                + " (?, ?, ?, ?, ?, ?, ?, ?, ?, DEFAULT)";

        try {
            ps = con.prepareStatement(sql);

            // 데이터 베이스 값 추가 (DB 숫자 시작은 1부터!)
            ps.setString(1, joinMember.getUserId());
            ps.setString(2, joinMember.getUserPwd());
            ps.setString(3, joinMember.getUserName());
            ps.setString(4, joinMember.getGender());
            ps.setInt(5, joinMember.getAge());
            ps.setString(6, joinMember.getEmail());
            ps.setString(7, joinMember.getPhone());
            ps.setString(8, joinMember.getAddress());
            ps.setString(9, joinMember.getHobby());

            result = ps.executeUpdate();

        } catch (SQLException e) {

            e.printStackTrace();
        } finally {
            close(ps);
        }

        return result;
    }

    public Member selectMember(Connection con, Member loginMember) {
        Member result = null;

        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM MEMBER WHERE USERID = ? AND PASSWORD = ?";

        try {
            ps = con.prepareStatement(sql);

            ps.setString(1, loginMember.getUserId());
            ps.setString(2, loginMember.getUserPwd());

            rs = ps.executeQuery();

            if (rs.next()) {
                result = new Member();
                result.setUserId(rs.getString("USERID"));
                result.setUserPwd(rs.getString("PASSWORD"));
                result.setUserName(rs.getString("USERNAME"));
                result.setGender(rs.getString(4));
                result.setAge(rs.getInt("age"));
                result.setAddress(rs.getString("address"));
                result.setPhone(rs.getString("phone"));
                result.setEmail(rs.getString("email"));
                result.setHobby(rs.getString("Hobby"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rs);
            close(ps);
        }

        return result;

    }

    public int updateMember(Connection con, Member updateMember) {
        int result = 0; // 업데이트된 행의 수
        PreparedStatement ps = null;

        String sql = "UPDATE MEMBER SET PASSWORD= ?, "
                + " GENDER = ?, AGE = ?, EMAIL=?, "
                + " ADDRESS = ?, HOBBY = ?, PHONE = ? "
                + " WHERE USERID = ?";

        try {
            ps = con.prepareStatement(sql);

            ps.setString(1, updateMember.getUserPwd());
            ps.setString(2, updateMember.getGender());
            ps.setInt(3, updateMember.getAge());
            ps.setString(4, updateMember.getEmail());
            ps.setString(5, updateMember.getAddress());
            ps.setString(6, updateMember.getHobby());
            ps.setString(7, updateMember.getPhone());
            ps.setString(8, updateMember.getUserId());

            result = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(ps);
        }

        return result;
    }

    public int deleteMember(Connection con, String userId) {
        int result = 0;
        PreparedStatement ps = null;

        String sql = "DELETE FROM MEMBER WHERE USERID = ?";

        try {
            ps = con.prepareStatement(sql);

            ps.setString(1, userId);

            result = ps.executeUpdate();

        } catch (SQLException e) {

            e.printStackTrace();
        } finally {

            close(ps);
        }

        return result;
    }
}

