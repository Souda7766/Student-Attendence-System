package studentattendancesystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {

    private static final String URL = "jdbc:mysql://localhost:3306/studentdb"; // তোমার DB নাম
    private static final String USER = "root";
    private static final String PASSWORD = "Souda@123"; // তোমার MySQL পাসওয়ার্ড

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
