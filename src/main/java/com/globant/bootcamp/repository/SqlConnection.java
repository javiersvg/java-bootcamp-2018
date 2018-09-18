package com.globant.bootcamp.repository;

import org.apache.log4j.Logger;

import com.globant.bootcamp.patterns.builder.ConnectionProperties;

import java.util.ResourceBundle;

/**
 * Stub class for a "sql database connection" with static user and password authentication
 */
public class SqlConnection implements Connection {

    final static Logger logger = Logger.getLogger(SqlConnection.class);

	private String dbUrl;

	private boolean status;

	public SqlConnection(String dbName) {
		if (dbName == null) {
			throw new IllegalArgumentException("Database URL can't be null");
		}
		this.dbUrl = "mysql:postgres:" + dbName;
	}
	
	@Override
	public void connect(ConnectionProperties credentials) {
	    ResourceBundle labels = ResourceBundle.getBundle("credentials");
	    String user = labels.getString("mysql.user");
	    String password = labels.getString("mysql.password");
	    logger.info("Using stub mysql connection class\n Connecting to mysql server with adress; "+this.getUrl());
	    try{
            Thread.sleep(1000);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
	    this.status = user.equals(credentials.getUsername()) && password.equals(credentials.getPassword());   
	    if (this.getStatus()){
	        logger.info("User "+credentials.getUsername()+ " connected successfully");
	    } else {
	        logger.error("Something went wrong while connecting, incorrect user or password?");
	    }
    }
    
    @Override
    public boolean getStatus() {
        return this.status;
    }
    
    @Override
    public String getUrl() {
        return this.dbUrl;
    }
}
