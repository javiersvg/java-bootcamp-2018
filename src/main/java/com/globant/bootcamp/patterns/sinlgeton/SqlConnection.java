package com.globant.bootcamp.patterns.sinlgeton;

import java.util.Properties;
import java.util.ResourceBundle;

import lombok.Getter;
import lombok.NonNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.globant.bootcamp.repository.Connection;

/**
 * Stub class for a "sql database connection" with static user and password authentication
 */
public class SqlConnection implements Connection {

	private static Connection instance;

    private final static Logger LOGGER = LoggerFactory.getLogger(SqlConnection.class);
    
    private Properties properties;

	@Getter private String url;

	@Getter private boolean open;

	public SqlConnection(@NonNull Properties properties) {
		this.properties = properties;
		url = properties.getProperty(PropertiesKey.URL.name());
	}

	public static Connection getInstance(Properties properties) {
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



