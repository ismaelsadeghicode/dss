package com.dss.database.practice.database;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {
    private static DBConnection dbConnection=null;
    private Connection connection;
    private String username;
    private String password;
    private String url;
    private String driver;

    public Connection openConnection(){
        File file = new File("resources/application.properties");
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(file));
        } catch (IOException e) {
            System.err.println("System wasn't able to find your \" .properties \" file!");
            e.printStackTrace();
        }
        username =properties.getProperty("username");
        password=properties.getProperty("password");
        url=properties.getProperty("url");
        driver=properties.getProperty("driver");
        try {
            Class.forName(driver);
            connection= DriverManager.getConnection(url,username,password);
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("If it's \"ClassNotFoundException\" you haven't got that driver loaded properly!");
            e.printStackTrace();
        }
        return connection;
    }

    public Connection getConnection(){
        return connection;
    }

    public void closeConnection() throws SQLException {
        if (connection!=null){
            connection.close();
        }else{
            System.err.println("you don't have an open connection at this moment!");
        }
    }

    public static DBConnection getInstance(){
        if(dbConnection==null){
            synchronized (DBConnection.class){
                dbConnection = new DBConnection();
            }
        }
        return dbConnection;
    }
}
