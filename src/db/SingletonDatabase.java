package org.singleton.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingletonDatabase {
    
    static Connection conn = null;
    
    private SingletonDatabase(){   
    }
    
    public static Connection getSingletonDatabase(){
        
        try{
            if(conn == null){
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbc", "root", "localhost");
            }
            
        }catch (Exception e){
            System.out.println("Database Connection Creation Failed: " + e.getMessage());
        }
        
        return conn;
    }
}
