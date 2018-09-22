package com.globant.bootcamp.patterns.sinlgeton;

import java.util.Properties;
import java.util.ResourceBundle;

import lombok.Getter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.globant.bootcamp.repository.Connection;

/**
 * Stub class for a "sql database connection" with static user and password authentication
 */
public class SqlConnection implements Connection {

	private static Connection instance;

    private final static Logger LOGGER = LoggerFactory.getLogger(SqlConnection.class);

	@Getter private String Url;

	@Getter private boolean open;

	private SqlConnection(String dbName) {
		if (dbName == null) {
			throw new IllegalArgumentException("Database URL can't be null");
		}
		this.Url = "mysql:postgres:" + dbName;
	}

	public static Connection getInstance(String dbName) {
		if (instance == null) {
			LOGGER.info("Creating static instance of Sql connection");
			instance = new SqlConnection(dbName);
		}
		return instance;
	}
	
	@Override
	public void connect(Properties credentials) {
	    ResourceBundle labels = ResourceBundle.getBundle("credentials");
	    String user = labels.getString("mysql.user");
	    String password = labels.getString("mysql.password");
	    LOGGER.info("Using stub mysql connection class\n Connecting to mysql server with adress: {}", getUrl());
	    try{
            Thread.sleep(1000);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
	    open = user.equals(credentials.get("user")) && password.equals(credentials.get("password"));   
	    if (isOpen()){
	        LOGGER.info("User {} connected succesfully", credentials.get("user"));
	    } else {
	        LOGGER.error("Something went wrong while connecting, incorrect user or password?");
	    }
    }
}

