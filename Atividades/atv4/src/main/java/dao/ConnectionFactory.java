package dao;
import java.sql.Connection;
//import config.AppConfig;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:postgresql://localhost/persistencia", "postgres", "admin");
    }
}