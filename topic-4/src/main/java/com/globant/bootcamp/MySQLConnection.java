package com.globant.bootcamp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class MySQLConnection  {
    
    private static final String DB_URL = "jdbc:mysql://db:3306/high_school";
    private static final String DB_USER_NAME = "high_school_admin";
    private static final String DB_PASSWORD = "high_school_admin_password";
    private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
    
    private static MySQLConnection instance;
    
    private MySQLConnection(){}
    
    public static MySQLConnection getInstance() {
        if (instance == null) {
            instance = new MySQLConnection();
        }
        return instance;
    }
    
    public ResultSet run(String query) throws SQLException {
        Connection connection = null;
        try {
            Class.forName(DB_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER_NAME, DB_PASSWORD); 
            Statement stmt = connection.createStatement();
            return stmt.executeQuery(query);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
        return null;
    }
}
