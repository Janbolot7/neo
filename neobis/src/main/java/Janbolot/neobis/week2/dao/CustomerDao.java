package Janbolot.neobis.week2.dao;

import Janbolot.neobis.week2.pojo.Customer;
import Janbolot.neobis.week2.pojo.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDao {
    public static void createCustomer(Connection connection, int customerId, String customerName) {
        String createCustomer = "INSERT INTO customer (customer_id, customer_name) VALUES (?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(createCustomer);

            preparedStatement.setInt(1, customerId);
            preparedStatement.setString(2, customerName);

            preparedStatement.executeUpdate();
            System.out.println("Успешно добавили клиента в таблицу!");
        } catch (SQLException e) {
            System.out.println("Error");
            throw new RuntimeException(e);
        }
    }

    public static void deleteCustomer(Connection connection, int customerId) {
        try {
            String deleteQuery = "DELETE FROM customer WHERE customer_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery);
            preparedStatement.setInt(1, customerId);
            preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();
            System.out.println("Вы успешно удалили клиента!");
        } catch (SQLException e) {
            System.out.println("Error");
            throw new RuntimeException(e);
        }
    }

    public static List<Customer> readCustomer(Connection connection) {
        List<Customer> customers = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();

            String selectQuery = "SELECT * FROM customer";
            ResultSet resultSet = statement.executeQuery(selectQuery);

            while (resultSet.next()) {
                Customer customer = new Customer();
                customer.setCustomerId(resultSet.getInt("customer_id"));
                customer.setCustomerName(resultSet.getString("customer_name"));
                customers.add(customer);

                System.out.println("Customer ID: " + customer.getCustomerId() + ", Name: " + customer.getCustomerName());
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }

    public static void updateCustomer(Connection connection, int customerId, String newCustomerName) {
        try {
            Statement statement = connection.createStatement();

            String updateQuery = "UPDATE customer SET customer_name = ? WHERE customer_id = ?";
            PreparedStatement preparedSt = connection.prepareStatement(updateQuery);
            preparedSt.setString(1, newCustomerName);
            preparedSt.setInt(2, customerId);

            preparedSt.executeUpdate();
            System.out.println("Вы успешно обновили данные клиента!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
