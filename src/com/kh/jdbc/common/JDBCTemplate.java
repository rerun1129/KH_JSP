package com.kh.jdbc.common;

import java.sql.*;

public class JDBCTemplate {


    public static Connection getConnection(){
        Connection con = null;

        try {
            Class.forName("oracle.jdbc.OracleDriver");
            con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:xe",
                    "JSP", "JSP");

            con.setAutoCommit(false);
            // 자동 커밋 방지!

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    public static void close(Statement st){
        try {
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void close(ResultSet rs){
        try {
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void close(Connection con) {
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void commit(Connection con) {
        // 변경사항 저장 메소드
        try {
            con.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void rollback(Connection con) {
        // 변경사항 취소 메소드
        try {
            con.rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
