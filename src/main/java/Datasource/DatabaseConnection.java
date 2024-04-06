package Datasource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DatabaseConnection {
    private static Connection connection;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/employeedb");
            } catch (SQLException e) {
                System.out.println("Connection failed");
                e.printStackTrace();
            }
            return connection;
        }
        else {
            return connection;
        }
    }
    public static void closeConnection() {
        try {
            getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Connection close failed");
        }
    }
}
