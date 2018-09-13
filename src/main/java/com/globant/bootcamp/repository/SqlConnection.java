package com.globant.bootcamp.repository;

/**
 * Stub class for a "sql database connection" with static user and password authentication
 */
public class SqlConnection extends Connection {
    
    private static final String sqlAdminUser = "admin";
    private static final String sqlAdminPassword = "admin";
    
    /**
     * Constructor tries to connect with the @user and @password given as arguments
    */
    public SqlConnection(String dbName, String user, String password){
        
        super.dbUrl = "jdbc:mysql:"+dbName;
        super.status = false;
        
        if(sqlAdminUser.equals(user)){
            return;
        }
        
        if(sqlAdminPassword.equals(password)){
            return;
        }
        
        status = true;
        
    }
}
