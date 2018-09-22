package com.globant.bootcamp.repository;

import org.apache.log4j.Logger;

import com.globant.bootcamp.patterns.builder.ConnectionProperties;

import java.util.ResourceBundle;

/**
 * Stub class for a "sql database connection" with static user and password authentication
 */
public class SqlConnection implements Connection {

    final static Logger logger = Logger.getLogger(SqlConnection.class);

    private ConnectionProperties properties;

	private boolean status;

	public SqlConnection(ConnectionProperties properties) {
		if (properties == null) {
			throw new IllegalArgumentException("Properties can't be nul");
		}
		this.properties = properties;
	}
	
	@Override
	public void connect() {
	    ResourceBundle labels = ResourceBundle.getBundle("credentials");
	    String user = labels.getString("mysql.user");
	    String password = labels.getString("mysql.password");
	    logger.info("Using stub mysql connection class\n Connecting to mysql server with adress; "+this.getUrl());
	    try{
            Thread.sleep(1000);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
	    this.status = user.equals(properties.getUsername()) && password.equals(properties.getPassword());   
	    if (this.getStatus()){
	        logger.info("User "+properties.getUsername()+ " connected successfully");
	    } else {
	        logger.error("Something went wrong while connecting, incorrect user or password?");
	    }
    }
    
    @Override
    public void close() {
        logger.info("Closing connection for: "+this.getUrl());
        this.status = false;
    }
    
    @Override
    public boolean getStatus() {
        return this.status;
    }
    
    @Override
    public String getUrl() {
        return this.properties.getUrl();
    }
}
