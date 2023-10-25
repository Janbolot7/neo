package Janbolot.neobis.week2.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectJdbc {
    private static final String url = "jdbc:postgresql://localhost:5432/week2_neo";
    private static final String userName = "postgres";
    private static final String password = "postgres";
    private static Connection connection;

    public static Connection connection(){
        try {
            connection = DriverManager.getConnection(url, userName, password);
        } catch (SQLException e) {
            System.out.println("Connection failed!");
            e.printStackTrace();
        }
        return connection;
    }
}
