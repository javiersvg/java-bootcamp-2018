package com.globant.bootcamp.repository;

import org.apache.log4j.Logger;

import com.globant.bootcamp.patterns.builder.ConnectionProperties;

import java.util.ResourceBundle;

/**
 * Stub class for a "postgres database connection" with static user and password authentication
 */
public class PostgresConnection implements Connection {
    
    final static Logger logger = Logger.getLogger(PostgresConnection.class);
    
    private ConnectionProperties properties;

	private boolean status;


	public PostgresConnection(ConnectionProperties properties) {
		if (properties == null) {
			throw new IllegalArgumentException("Properties can't be null");
		}
		this.properties = properties;
	}
	
	@Override
	public void connect() {
	    ResourceBundle labels = ResourceBundle.getBundle("credentials");
	    String user = labels.getString("postgres.user");
	    String password = labels.getString("postgres.password");  
	    logger.info("Using stub postgres connection class\n Connecting to mysql server with adress; " + this.getUrl());
	    try{
            Thread.sleep(1000);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
	    this.status = user.equals(properties.getUsername()) && password.equals(properties.getPassword());
	    if (this.getStatus()){
	        logger.info("User " + properties.getUsername()+ " connected successfully");
	    } else {
	        logger.error("Something went wrong while connecting, incorrect user or password?");
	    }
    }
    
    @Override
    public void close() {
        logger.info("Closing connection for: " + this.getUrl());
        this.status = false;
    }
    
    @Override
    public boolean getStatus() {
        return status;
    }
    
    @Override
    public String getUrl() {
        return this.properties.getUrl();
    }
}
