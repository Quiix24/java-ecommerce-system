package javaapplication1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "ahmed";

    public static void insertUser(String username, String email, String password) throws SQLException {
        String sql = "INSERT INTO users (username, email, password) VALUES (?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            pstmt.setString(2, email);
            pstmt.setString(3, password);
            pstmt.executeUpdate();
        }
    }

     public static boolean checkUserCredentials(String username, String password) throws SQLException {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM users WHERE username = ? AND password = ?")) {
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            try (ResultSet rs = pstmt.executeQuery()) {
                return rs.next(); // If there is a row, user exists with provided credentials
            }
        }
    }
}
