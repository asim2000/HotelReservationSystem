package az.company.hotelreservation.dao.concretes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbHelper {
    public static Connection getConnection() throws SQLException, IOException {
        Properties properties=new Properties();
        properties.load(new BufferedReader(new FileReader("config.properties")));
        return DriverManager.getConnection(properties.getProperty("db.url"),properties.getProperty("db.username"),properties.getProperty("db.password"));
   }
}