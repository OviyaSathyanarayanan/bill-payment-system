package com.project.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionHandler {
    public static Connection getConnection()
            throws IOException, ClassNotFoundException, SQLException {
        InputStream bin = ConnectionHandler.class.getClassLoader()
                .getResourceAsStream("connection.properties");
        Properties property = new Properties();
        property.load(bin);
        String user = property.getProperty("db.username");
        String pass = property.getProperty("db.password");
        String url = property.getProperty("db.url");
        String driver = property.getProperty("db.driver");
        Class.forName(driver);
        Connection connection = DriverManager.getConnection(url, user, pass);
        return connection;
    }
}
