package com.globant.bootcamp.patterns.sinlgeton;

import java.util.ResourceBundle;

import lombok.Getter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.globant.bootcamp.patterns.builder.ConnectionProperties;
import com.globant.bootcamp.repository.Connection;

/**
 * Stub class for a "sql database connection" with static user and password authentication
 */
public class SqlConnection implements Connection {

	private static Connection instance;

    private final static Logger LOGGER = LoggerFactory.getLogger(SqlConnection.class);
    
    private ConnectionProperties properties;

	@Getter private String url;

	@Getter private boolean open;

	public SqlConnection(ConnectionProperties properties) {
		if (properties == null) {
			throw new IllegalArgumentException("Properties can't be null");
		}
		this.properties = properties;
		this.url = properties.getUrl();
	}

	public static Connection getInstance(ConnectionProperties properties) {
		if (instance == null) {
			LOGGER.info("Creating static instance of Sql connection");
			instance = new SqlConnection(properties);
		}
		return instance;
	}
	
	@Override
	public void connect() {
	    ResourceBundle labels = ResourceBundle.getBundle("credentials");
	    String user = labels.getString("mysql.user");
	    String password = labels.getString("mysql.password");
	    LOGGER.info("Using stub mysql connection class\n Connecting to mysql server with adress: {}", getUrl());
	    try{
            Thread.sleep(1000);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
	    open = user.equals(properties.getUsername()) && password.equals(properties.getPassword());   
	    if (isOpen()){
	        LOGGER.info("User {} connected succesfully", properties.getUsername());
	    } else {
	        LOGGER.error("Something went wrong while connecting, incorrect user or password?");
	    }
    }
    
    @Override
    public void close() {
        LOGGER.info("Closing connection for: {}", url);
        this.open = false;
        this.url = null;
    }  
}



