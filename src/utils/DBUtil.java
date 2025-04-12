package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String url = "jdbc:mysql://localhost:3306/tasklist?useSSL=false&serverTimezone=UTC";
        String user = "root";
        String password = "your_password";
        return DriverManager.getConnection(url, user, password);
    }
}