package Janbolot.neobis.week2.dao;

import Janbolot.neobis.week2.pojo.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {
    public static void createProduct(Connection connection, int productId, String productName, int productPrice) {
        String createCustomer = "INSERT INTO product (product_id, product_name, product_price) VALUES (?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(createCustomer);

            preparedStatement.setInt(1, productId);
            preparedStatement.setString(2, productName);
            preparedStatement.setInt(3, productPrice);

            preparedStatement.executeUpdate();
            System.out.println("Успешно добавили продукт в таблицу!");
        } catch (SQLException e) {
            System.out.println("Error");
            throw new RuntimeException(e);
        }
    }

    public static void deleteProduct(Connection connection, int productId) {
        try {
            String deleteQuery = "DELETE FROM product WHERE product_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery);
            preparedStatement.setInt(1, productId);
            preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();
            System.out.println("Вы успешно удалили продукт из таблицы!");
        } catch (SQLException e) {
            System.out.println("Error");
            throw new RuntimeException(e);
        }
    }

    public static List<Product>readProduct(Connection connection) {
        List<Product> products = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();

            String selectQuery = "SELECT * FROM product";
            ResultSet resultSet = statement.executeQuery(selectQuery);

            while (resultSet.next()) {
                Product product = new Product();
                product.setProductId(resultSet.getInt("product_id"));
                product.setProductName(resultSet.getString("product_name"));
                product.setProductPrice(resultSet.getInt("product_price"));
                products.add(product);

                System.out.println("Product ID: " + product.getProductId() + ", Product Name: " + product.getProductName() + ", Product Price: " + product.getProductPrice());
            }

            resultSet.close();
            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    public static void updateProduct(Connection connection, int productId, String newProductName, int newProductPrice) {
        try {
            Statement statement = connection.createStatement();

            String updateQuery = "UPDATE product SET product_name = ?, product_price = ? WHERE product_id = ?";
            PreparedStatement preparedSt = connection.prepareStatement(updateQuery);
            preparedSt.setString(1, newProductName);
            preparedSt.setInt(2, newProductPrice);
            preparedSt.setInt(3, productId);

            preparedSt.executeUpdate();
            System.out.println("Вы успешно обновили данные продукта!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
