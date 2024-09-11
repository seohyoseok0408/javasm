package edu.sm;

import java.sql.*;

public class Main5 {
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

        // 3. SQL
        String sql = "select * from cust";
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        while (true) {
            try {
                if (!rs.next()) break;
                System.out.println(rs.getString("id"));
                System.out.println(rs.getString("pwd"));
                System.out.println(rs.getString("name"));

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
