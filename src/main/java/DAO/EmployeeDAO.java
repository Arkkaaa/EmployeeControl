package DAO;
import Datasource.DatabaseConnection;
import java.sql.*;

public class EmployeeDAO {
    public void insertEmployee(String firstName, String lastName, String email) {
        Connection connection = DatabaseConnection.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO employee (first_name, last_name, email) VALUES (?, ?, ?)");
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setString(3, email);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
}
    }
}
