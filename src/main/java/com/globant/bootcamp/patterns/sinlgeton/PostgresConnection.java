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
    
    final static Logger logger = LoggerFactory.getLogger(PostgresConnection.class);

	private static Connection instance;
	
	@Getter private String url;
	
	@Getter private boolean open;

	private PostgresConnection(String dbName) {

		if (dbName == null) {
			throw new IllegalArgumentException("Database URL can't be null");
		}
		this.url = "jdbc:postgres:" + dbName;
	}

	public static Connection getInstance(String dbName) {
		if (instance == null) {
			logger.info("Creating static instance of Postgres connection");
			instance = new PostgresConnection(dbName);
		}
		return instance;
	}
	
	@Override
	public void connect(Properties credentials) {
	    ResourceBundle labels = ResourceBundle.getBundle("credentials");
	    String user = labels.getString("postgres.user");
	    String password = labels.getString("postgres.password");
	    logger.info("Using stub postgres connection class\n Connecting to mysql server with adress: {}", getUrl());
	    try{
            Thread.sleep(1000);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
	    open = user.equals(credentials.get("user")) && password.equals(credentials.get("password"));
	    if(isOpen()) {
	        logger.info("User {} connected succesfully", credentials.get("user"));
	    } else {
	        logger.error("Something went wrong while connecting, incorrect user or password?");
	    }
    }
}