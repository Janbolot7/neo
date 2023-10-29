package Janbolot.neobis;

import Janbolot.neobis.week2.Connection.ConnectJdbc;
import Janbolot.neobis.week2.dao.UsersDao;
import Janbolot.neobis.week2.dao.ProductsDao;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
          UsersDao usersDao = new UsersDao();
//        //Создание нового пользователя
          usersDao.createUser("user", "Janbolot","Jantoroev","Okkok@gmail.com", "0777777777", "Jan");
//
//        //Изменения данных клиента
          usersDao.updateUser(1,"Kornelius","Donsword","Iuuuu@yandex.ru", "0888888888", "Kon");
//
//        //Показать всех пользователей
          usersDao.showAllClient();
//
//        //Удаление пользователя
          usersDao.deleteUser(1);


          ProductsDao productsDAO = new ProductsDao();
//        //Создание нового продукта
          productsDAO.createProduct("Iphone14", 1500.2);
//
//        //Изменения данных продукта
          productsDAO.updateProduct(1L,"Iphone15",2500.50);
//
//        //Показать все данные продуктов
          productsDAO.showAllProducts();
//
//        //Удаление продукта
          productsDAO.deleteProduct(1L);
    }
}
