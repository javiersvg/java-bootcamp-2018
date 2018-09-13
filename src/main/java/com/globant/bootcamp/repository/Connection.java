package com.globant.bootcamp.repository;
/**
 * Abstract stub class for a database connection
 */
public abstract class Connection {
    
    protected String dbUrl;
    protected Boolean status;
    
    /**
     * @return status: If connection with the database is established 
     */
    public boolean getStatus() {
        return status;
    }
    
    
    /**
     * @return dbUrl: URL of the database
    */
    public String getUrl() {
        return dbUrl;
    }
}
