package DAO;

import Datasource.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmployeeDAO {
    private Connection connection;

    public EmployeeDAO() {
        // Initialize the connection
        connection = DatabaseConnection.getConnection();
    }

    public void insertEmployee(String firstName, String lastName, String email, String tableName) {
        // Check if connection is null
        if (connection == null) {
            System.err.println("Connection is null. Cannot execute query.");
            return;
        }

        try {
            // Prepare the SQL statement with the dynamic table name
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO " + tableName + " (first_name, last_name, email) VALUES (?, ?, ?)");
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setString(3, email);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
