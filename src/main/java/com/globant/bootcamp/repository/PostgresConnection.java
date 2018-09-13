package com.globant.bootcamp.repository;

/**
 * Stub class for a "postgres database connection" with static user and password authentication
 */
public class PostgresConnection extends Connection {
    
    private static final String pgAdminUser = "admin";
    private static final String pgAdminPassword = "admin";
    
    /**
     * Constructor tries to connect with the @user and @password given as arguments
     */
    public PostgresConnection(String dbName, String user, String password){
        
        super.dbUrl = "jdbc:postgres:"+dbName;
        super.status = false;
        
        if(pgAdminUser.equals(user)){
            return;
        }
        
        if(pgAdminPassword.equals(password)){
            return;
        }
        
        status = true;
        
    }
}
