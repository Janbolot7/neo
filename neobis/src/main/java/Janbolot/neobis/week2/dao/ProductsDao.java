package Janbolot.neobis.week2.dao;

import Janbolot.neobis.week2.Connection.ConnectJdbc;
import Janbolot.neobis.week2.pojo.Products;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductsDao {
    public List<Products> showAllProducts() {
        String checkAllProducts = "SELECT * FROM products";
        List<Products> products = new ArrayList<>();

        try {
            Connection connection = ConnectJdbc.connection();
            PreparedStatement preparedStatement = connection.prepareStatement(checkAllProducts);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Products product = new Products();

                product.setProductId(resultSet.getLong("Product_Id"));
                product.setProductName(resultSet.getString("Product_name"));
                product.setProductPrice(resultSet.getDouble("Product_price"));

                products.add(product);
                preparedStatement.close();
                connection.close();

                System.out.println("Product id: " + product.getProductId() + ", Product name: " + product.getProductName() + ", Product price: " + product.getProductPrice());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return products;
    }
    public void deleteProduct(Long productId) {
        String deleteSQL = "DELETE FROM products WHERE product_id = ?";

        try {
            Connection connection = ConnectJdbc.connection();
            PreparedStatement preparedStatement = connection.prepareStatement(deleteSQL);
            preparedStatement.setLong(1, productId);

            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
            System.out.println("Данный продукт с id: " + productId + " был успешно удален");
        } catch (SQLException e) {
            System.out.println("Error");
            throw new RuntimeException(e);
        }
    }
    public void updateProduct(Long productId, String newProductName, Double newProductPrice) {
        String updateSQL = "UPDATE products SET product_name = ?, product_price = ? WHERE product_id = ?";

        try {
            Connection connection = ConnectJdbc.connection();
            PreparedStatement preparedStatement = connection.prepareStatement(updateSQL);

            preparedStatement.setString(1, newProductName);
            preparedStatement.setDouble(2, newProductPrice);
            preparedStatement.setLong(3, productId);

            int rowsUpdate = preparedStatement.executeUpdate();

            if (rowsUpdate > 0) {
                System.out.println("Данные продукта id: " + productId + " были успешно обновлены");
            } else {
                System.out.println("Не удалось обновить продукт с id: " + productId);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error");
            throw new RuntimeException(e);
        }
    }
    public void createProduct(String productName, Double productPrice) {
        String insertSQL = "INSERT INTO products (product_id, product_name, product_price) VALUES (?, ?, ?)";

        try {
            Connection connection = ConnectJdbc.connection();
            PreparedStatement preparedStatement = connection.prepareStatement(insertSQL, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(2, productName);
            preparedStatement.setDouble(3, productPrice);

            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
            System.out.println("Успешно добавили продукт в таблицу");
        } catch (SQLException e) {
            System.out.println("Error");
            throw new RuntimeException(e);
        }
    }
}
