package com.globant.bootcamp.patterns;

import com.globant.bootcamp.repository.Connection;
import com.globant.bootcamp.repository.SqlConnection;

/**
 * Singleton of a database connection
 */
public class ConnectionSingleton {
    
    
    private static Connection instance;
    
    private ConnectionSingleton(){}
    
    public static Connection getInstance(String dbName, String user, String password){
        if(instance == null){
            instance = new SqlConnection(dbName, user, password);
        }
        return instance;
    }
    
}


