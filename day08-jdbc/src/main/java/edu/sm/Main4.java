package edu.sm;

import java.sql.*;

public class Main4 {
    public static void main(String[] args) {
        // 1. MySQL JDBC Driver를 로딩한다.
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver not found");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        // 2. MySQL 을 서버와 연결한다.
        String url = "jdbc:mysql://localhost:3306/smdb";
        String sqlid = "smuser";
        String sqlpwd = "111111";

        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, sqlid, sqlpwd);
            System.out.println("Connected to database");
        } catch (SQLException e) {
            System.out.println("Connection failed");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        // 3.SQL

        String selectSql = "SELECT * FROM cust WHERE id=?"; // 하나만 가져오기
        PreparedStatement ps = null;
        ResultSet rs = null;  // 셀렉트 할 때 날라오는 것 받기
        try {
            ps = conn.prepareStatement(selectSql);
            ps.setString(1, "id01");
            rs = ps.executeQuery(); // 1개가 날라올 것임
            rs.next(); // 커서가 이전을 가리키고 있기에 다음으로 이동시킴
            System.out.println(rs.getString("id"));
            System.out.println(rs.getString("pwd"));
            System.out.println(rs.getString("name"));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
