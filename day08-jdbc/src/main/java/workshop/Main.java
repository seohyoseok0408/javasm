package workshop;

import java.sql.*;
import java.util.Scanner;

public class Main {
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

        // 3. SQL 작업
        Scanner scanner = new Scanner(System.in);
        String sql = "";
        PreparedStatement ps = null;

        while (true) {
            System.out.println("C: 상품추가, R: 검색, U: 업데이트, D: 삭제, Q: 나가기");
            char input = scanner.nextLine().charAt(0);

            if (input == 'Q') {
                break;
            } else if (input == 'C') {
                // 상품 추가
                try {
                    sql = "INSERT INTO Product (name, price, image_name, created_by) VALUES (?, ?, ?, ?)";
                    ps = conn.prepareStatement(sql);

                    // 사용자로부터 입력받기
                    System.out.print("상품 이름: ");
                    String name = scanner.nextLine();

                    System.out.print("상품 가격: ");
                    double price = Double.parseDouble(scanner.nextLine());

                    System.out.print("이미지 파일명: ");
                    String imageName = scanner.nextLine();

                    System.out.print("등록자: ");
                    String createdBy = scanner.nextLine();

                    // PreparedStatement에 값 설정
                    ps.setString(1, name);
                    ps.setDouble(2, price);
                    ps.setString(3, imageName);
                    ps.setString(4, createdBy);

                    // 실행
                    int result = ps.executeUpdate();
                    if (result > 0) {
                        System.out.println("상품이 성공적으로 추가되었습니다.");
                    } else {
                        System.out.println("상품 추가에 실패했습니다.");
                    }

                } catch (SQLException e) {
                    System.out.println("SQL 오류: 상품을 추가할 수 없습니다.");
                    e.printStackTrace();
                } catch (Exception e) {
                    System.out.println("입력 오류: " + e.getMessage());
                }
            } else if (input == 'R') {
                // 상품 검색
                System.out.println("1: ID로 검색, 2: 전체 검색");
                char searchInput = scanner.nextLine().charAt(0);

                if (searchInput == '1') {
                    // ID로 검색
                    try {
                        System.out.print("검색할 상품 ID를 입력하세요: ");
                        int id = Integer.parseInt(scanner.nextLine());

                        sql = "SELECT * FROM Product WHERE id = ?";
                        ps = conn.prepareStatement(sql);
                        ps.setInt(1, id);

                        ResultSet rs = ps.executeQuery();
                        if (rs.next()) {
                            System.out.println("ID: " + rs.getInt("id") +
                                    ", 이름: " + rs.getString("name") +
                                    ", 가격: " + rs.getDouble("price") +
                                    ", 이미지 이름: " + rs.getString("image_name") +
                                    ", 등록자: " + rs.getString("created_by") +
                                    ", 등록일: " + rs.getTimestamp("created_at") +
                                    ", 수정일: " + rs.getTimestamp("updated_at"));
                        } else {
                            System.out.println("해당 ID의 상품을 찾을 수 없습니다.");
                        }

                    } catch (SQLException e) {
                        System.out.println("SQL 오류: 상품을 검색할 수 없습니다.");
                        e.printStackTrace();
                    }

                } else if (searchInput == '2') {
                    // 전체 검색
                    try {
                        sql = "SELECT * FROM Product";
                        ps = conn.prepareStatement(sql);

                        ResultSet rs = ps.executeQuery();
                        while (rs.next()) {
                            System.out.println("ID: " + rs.getInt("id") +
                                    ", 이름: " + rs.getString("name") +
                                    ", 가격: " + rs.getDouble("price") +
                                    ", 이미지 이름: " + rs.getString("image_name") +
                                    ", 등록자: " + rs.getString("created_by") +
                                    ", 등록일: " + rs.getTimestamp("created_at") +
                                    ", 수정일: " + rs.getTimestamp("updated_at"));
                        }

                    } catch (SQLException e) {
                        System.out.println("SQL 오류: 상품을 검색할 수 없습니다.");
                        e.printStackTrace();
                    }
                }

            } else if (input == 'U') {
                // 상품 업데이트
                try {
                    System.out.print("업데이트할 상품 ID를 입력하세요: ");
                    int id = Integer.parseInt(scanner.nextLine());

                    System.out.print("새로운 상품 이름: ");
                    String name = scanner.nextLine();

                    System.out.print("새로운 상품 가격: ");
                    double price = Double.parseDouble(scanner.nextLine());

                    System.out.print("새로운 이미지 파일명: ");
                    String imageName = scanner.nextLine();

                    sql = "UPDATE Product SET name = ?, price = ?, image_name = ?, updated_at = CURRENT_TIMESTAMP WHERE id = ?";
                    ps = conn.prepareStatement(sql);
                    ps.setString(1, name);
                    ps.setDouble(2, price);
                    ps.setString(3, imageName);
                    ps.setInt(4, id);

                    int result = ps.executeUpdate();
                    if (result > 0) {
                        System.out.println("상품이 성공적으로 업데이트되었습니다.");
                    } else {
                        System.out.println("업데이트에 실패했습니다.");
                    }

                } catch (SQLException e) {
                    System.out.println("SQL 오류: 상품을 업데이트할 수 없습니다.");
                    e.printStackTrace();
                }

            } else if (input == 'D') {
                // 상품 삭제
                try {
                    System.out.print("삭제할 상품 ID를 입력하세요: ");
                    int id = Integer.parseInt(scanner.nextLine());

                    sql = "DELETE FROM Product WHERE id = ?";
                    ps = conn.prepareStatement(sql);
                    ps.setInt(1, id);

                    int result = ps.executeUpdate();
                    if (result > 0) {
                        System.out.println("상품이 성공적으로 삭제되었습니다.");
                    } else {
                        System.out.println("삭제에 실패했습니다.");
                    }

                } catch (SQLException e) {
                    System.out.println("SQL 오류: 상품을 삭제할 수 없습니다.");
                    e.printStackTrace();
                }
            }
        }

        // 자원 해제
        try {
            if (ps != null) ps.close();
            if (conn != null) conn.close();
            scanner.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}