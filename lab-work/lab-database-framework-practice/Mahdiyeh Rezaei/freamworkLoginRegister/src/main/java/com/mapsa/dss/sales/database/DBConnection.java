package com.mapsa.dss.sales.database;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Component
public class DBConnection {
    private Connection connection;
    private static DBConnection dbConnection = null;
    private String driver;
    private String url;
    private String user;
    private String pass;

    private DBConnection() {
    }

    public Connection getConnection() throws IOException {

//        Properties properties = new Properties();
//        properties.load(new FileInputStream("/WEB-INF/classes/application.properties"));



        url = "jdbc:oracle:thin:@localhost:1521:orcl";
        user = "sales";
        pass = "sales123";


        try {
            Class.forName("oracle.jdbc.OracleDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection(url, user, pass);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        System.out.println("getConnection");
        return connection;
    }

    public static DBConnection getInstance() {
        if (dbConnection == null) {
            synchronized (DBConnection.class) {
                dbConnection = new DBConnection();
            }
        }
        return dbConnection;
    }

    public void closeConnection() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }
}
