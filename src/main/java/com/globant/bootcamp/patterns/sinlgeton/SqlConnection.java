package com.globant.bootcamp.patterns.sinlgeton;

import java.util.Properties;
import java.util.ResourceBundle;

import lombok.Getter;

import org.apache.log4j.Logger;

import com.globant.bootcamp.repository.Connection;

/**
 * Stub class for a "sql database connection" with static user and password authentication
 */
public class SqlConnection implements Connection {

	private static Connection instance;

    final static Logger logger = Logger.getLogger(SqlConnection.class);

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
			logger.info("Creating static instance of Sql connection");
			instance = new SqlConnection(dbName);
		}
		return instance;
	}
	
	@Override
	public void connect(Properties credentials) {
	    ResourceBundle labels = ResourceBundle.getBundle("credentials");
	    String user = labels.getString("mysql.user");
	    String password = labels.getString("mysql.password");
	    logger.info("Using stub mysql connection class\n Connecting to mysql server with adress; " + getUrl());
	    try{
            Thread.sleep(1000);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
	    open = user.equals(credentials.get("user")) && password.equals(credentials.get("password"));   
	    if (isOpen()){
	        logger.info("User "+credentials.get("user")+ " connected successfully");
	    } else {
	        logger.error("Something went wrong while connecting, incorrect user or password?");
	    }
    }
}

