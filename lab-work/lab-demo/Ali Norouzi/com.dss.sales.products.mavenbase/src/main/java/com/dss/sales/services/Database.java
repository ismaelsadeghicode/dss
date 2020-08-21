package com.dss.sales.services;

/*
@Deprecated
public class Database {

    private static Database database = null;
    private Connection connection;
    private String url;
    private String driver;
    private String username;
    private String password;
    private File file;


    public Connection openConnection(){
        file = new File("resources/application.properties");
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(file));
        } catch (IOException e) {
            System.err.println("System wasn't able to load your \" .properties \" file!");
            e.printStackTrace();
        }
        url=properties.getProperty("url");
        driver=properties.getProperty("driver");
        username=properties.getProperty("username");
        password=properties.getProperty("password");
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url,username,password);
        } catch (ClassNotFoundException | SQLException e) {
            throw new IllegalStateException("Load the driver correctly! also double check your username and such");
        }
        return connection;
    }


    public void closeConnection() throws SQLException {
        if(connection!=null){
            connection.close();
        }else {
            System.err.println("You don't have an open connection at this moment!");
        }
    }

    public static Database getInstance(){
        if(database==null){
            synchronized (Database.class){
                database = new Database();
                return database;
            }
        }else {
            return database;
        }
    }

}
*/