package com.globant.bootcamp.patterns.sinlgeton;

import java.util.Properties;
import java.util.ResourceBundle;

import lombok.Getter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.globant.bootcamp.repository.Connection;

/**
 * Stub class for a "postgres database connection" with static user and password authentication
 */
public class PostgresConnection implements Connection {
    
	private static Connection instance;

    private final static Logger LOGGER = LoggerFactory.getLogger(SqlConnection.class);
    
    private Properties properties;

	@Getter private String url;

	@Getter private boolean open;

	public PostgresConnection(Properties properties) {
		if (properties == null) {
			throw new IllegalArgumentException("Properties can't be null");
		}
		this.properties = properties;
		url = properties.getProperty("");
	}

	public static Connection getInstance(Properties properties) {
		if (instance == null) {
			LOGGER.info("Creating static instance of Sql connection");
			instance = new PostgresConnection(properties);
		}
		return instance;
	}
	
	@Override
	public void connect() {
	    ResourceBundle labels = ResourceBundle.getBundle("credentials");
	    String user = labels.getString("postgres.user");
	    String password = labels.getString("postgres.password");
	    
	    LOGGER.info("Using stub mysql connection class\n Connecting to mysql server with adress: {}", getUrl());
	    try{
            Thread.sleep(1000);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
	    open = user.equals(properties.getProperty(PropertiesKey.USER.name())) && password.equals(properties.getProperty(PropertiesKey.PASSWORD.name()));
	    
	    if (isOpen()){
	        LOGGER.info("User {} connected succesfully", properties.getProperty(PropertiesKey.USER.name()));
	    } else {
	        LOGGER.error("Something went wrong while connecting, incorrect user or password?");
	    }
    }
    
    @Override
    public void close() {
        LOGGER.info("Closing connection for: {}", url);
        open = false;
        properties = null;
        instance = null;
    }  
}