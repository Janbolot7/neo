package Janbolot.neobis.week2.dao;

import Janbolot.neobis.week2.Connection.ConnectJdbc;
import Janbolot.neobis.week2.pojo.Users;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsersDao {
    public void createUser(String userRole, String firstName, String lastName, String email, String phoneNumber, String password) {
        String insertSQL = "INSERT INTO users (user_role,first_name, last_name, email, phone_number, password) " +
                "VALUES (?, ?, ?, ?, ?, ?)";
        Long userId = null;
        try {
            Connection connection = ConnectJdbc.connection();
            PreparedStatement preparedStatement = connection.prepareStatement(insertSQL, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1,userRole);
            preparedStatement.setString(2, firstName);
            preparedStatement.setString(3, lastName);
            preparedStatement.setString(4, email);
            preparedStatement.setString(5, phoneNumber);
            preparedStatement.setString(6, password);

            preparedStatement.executeUpdate();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                userId = resultSet.getLong("user_id");
            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
            System.out.println("Успешно добавили клиента в таблицу!");
        } catch (SQLException e) {
            System.out.println("Error");
            throw new RuntimeException(e);
        }
    }
    public void updateUser(long userId, String newFirstName, String newLastName, String newEmail, String newPhoneNumber, String newPassword) {
        String updateSQL = "UPDATE users SET first_name = ?, last_name = ?, email = ?, phone_number = ?, password = ? WHERE user_id = ?";

        try {
            Connection connection = ConnectJdbc.connection();
            PreparedStatement preparedStatement = connection.prepareStatement(updateSQL);

            preparedStatement.setString(1, newFirstName);
            preparedStatement.setString(2, newLastName);
            preparedStatement.setString(3, newEmail);
            preparedStatement.setString(4, newPhoneNumber);
            preparedStatement.setString(5, newPassword);
            preparedStatement.setLong(6, userId);

            int rowsUpdate = preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();
            if (rowsUpdate > 0) {
                System.out.println("Данные клиента с id: " + userId + ", были успешно обновлены");
            } else {
                System.out.println("Клиента с таким id: " + userId + " не существует");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void deleteUser(long userId) {
        String deleteSQL = "DELETE FROM users WHERE user_id = ?";

        try {
            Connection connection = ConnectJdbc.connection();
            PreparedStatement preparedStatement = connection.prepareStatement(deleteSQL);
            preparedStatement.setLong(1, userId);
            preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();

            System.out.println("Данные с id: " + userId + " были успешно удалены");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Users> showAllClient() {
        String checkSQL = "SELECT * FROM users";
        List<Users> users = new ArrayList<>();

        try {
            Connection connection = ConnectJdbc.connection();
            PreparedStatement preparedStatement = connection.prepareStatement(checkSQL);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Users user = new Users();
                user.setUserId(resultSet.getLong("user_id"));
                user.setRole(resultSet.getString("user_role"));
                user.setFirstName(resultSet.getString("first_name"));
                user.setLastName(resultSet.getString("last_name"));
                user.setEmail(resultSet.getString("email"));
                user.setPhoneNumber(resultSet.getString("phone_number"));
                user.setPassword(resultSet.getString("password"));

                users.add(user);
                resultSet.close();
                preparedStatement.close();
                connection.close();

                System.out.println("User id: " + user.getUserId() + ", first name: " + user.getFirstName() + ", last name: " + user.getLastName());
            }
        } catch (SQLException e) {
            System.out.println("Error");
            throw new RuntimeException(e);
        }

        return users;
    }
}
