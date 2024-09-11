package edu.sm;

import com.mysql.cj.jdbc.exceptions.CommunicationsException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main3 {
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

        String updateSql = "UPDATE cust SET name=(?) WHERE id=(?)";
        PreparedStatement ps = null; // 준비돼있는 Statement
        try {
            ps = conn.prepareStatement(updateSql);
            ps.setString(1, "서효석"); // Sql 문의 ? 채우기
            ps.setString(2, "id01"); // Sql 문의 ? 채우기
            int result = ps.executeUpdate(); // 전송
            System.out.println(result);
            System.out.println("Inserted rows into database");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        // 4. close
    }
}
