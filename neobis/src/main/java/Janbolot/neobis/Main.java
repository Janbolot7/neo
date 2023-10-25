package Janbolot.neobis;

import Janbolot.neobis.week2.Connection.ConnectJdbc;
import Janbolot.neobis.week2.dao.CustomerDao;
import Janbolot.neobis.week2.dao.ProductDao;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        Connection connection = ConnectJdbc.connection();

        CustomerDao customerDao = new CustomerDao();

        //создание клиента
        customerDao.createCustomer(connection,1,"Janbolot");
        //внесение изменений в данных клиента
        customerDao.updateCustomer(connection,1,"Jantay");
        //просмотр всех введенных нами данных во всей таблица Customer
        customerDao.readCustomer(connection);
        //удаление не нужного клиента
        customerDao.deleteCustomer(connection,1);

        ProductDao productDao = new ProductDao();

        //создание продукта
        productDao.createProduct(connection,1,"Iphone15",4500);
        //внесение изменений в данных продукта
        productDao.updateProduct(connection,1,"Iphone16", 3000);
        //просмотр всех введенных нами данных во всей таблица Product
        productDao.readProduct(connection);
        //удаление не нужного продукта
        productDao.deleteProduct(connection,1);

    }
}
