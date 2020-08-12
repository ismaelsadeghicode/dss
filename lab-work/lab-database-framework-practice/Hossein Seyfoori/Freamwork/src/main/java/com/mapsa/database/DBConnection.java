package com.mapsa.database;

import com.mapsa.model.Customer;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class DBConnection {

     String driver;
     String user;
     String pass;
     String url;

    private Connection connection;
    private static DBConnection dbConnection = null;


    public DBConnection(){

    }


    public  Connection getConnection() throws IOException, ClassNotFoundException, SQLException {
        String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();

        Properties properties = new Properties();
        properties.load(new FileInputStream(rootPath+"application.properties"));

        this.driver = properties.getProperty("db.driver");
        this.user = properties.getProperty("db.user");
        this.pass = properties.getProperty("db.pass");
        this.url = properties.getProperty("db.url");

        Class.forName("oracle.jdbc.OracleDriver");
        System.out.println("Connection to Database ...");
        connection = DriverManager.getConnection(url,user,pass);
        System.out.println("Connection Established.");
        return connection;
    }

    public static DBConnection getInstance() {
        if (dbConnection == null) {
            synchronized (DBConnection.class){
             dbConnection = new DBConnection();
            }
        }
        return dbConnection;
    }

//    public List<Customer> customers()
//    {
//        List<Customer> customers = new ArrayList<>();
//
//        try {
//            Connection connection = getConnection();
//            Statement statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery("select * from customer");
//
//            while(resultSet.next())
//            {
//                Customer customer = new Customer();
//                customer.setFirstName(resultSet.getString("FIRST_NAME"));
//                customer.setLastName(resultSet.getString("LAST_NAME"));
//                customer.setId(resultSet.getInt("ID"));
//
//                customers.add(customer);
//            }
//
//            return customers;
//
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//
//
//        return customers;
//    }
//
//    public void createTable()
//    {
//        try {
//            Connection connection = getConnection();
//            Statement statement = connection.createStatement();
////            String query = "create table person(id number(10))";
//            String query = "create table customer(id number(10),firs_name VARCHAR(10),last_name varchar(10))";
//            statement.executeUpdate(query);
//            System.out.println(query);
//
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//    }



}
