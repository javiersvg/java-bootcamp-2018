package com.globant.bootcamp.repository;

import org.apache.log4j.Logger;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 * Stub class for a "postgres database connection" with static user and password authentication
 */
public class PostgresConnection extends Connection {
    
    final static Logger logger = Logger.getLogger(PostgresConnection.class);

	public PostgresConnection(String dbName) {
		super("jdbc:postgres:" + dbName);
	}
	
	@Override
	public void connect(Properties credentials) {
	    ResourceBundle labels = ResourceBundle.getBundle(CREDENTIALS);
	    String user = labels.getString("postgres.user");
	    String password = labels.getString("postgres.password");
	    logger.info("Using stub postgres connection class\n Connecting to mysql server with adress; "+this.getUrl());
	    this.updateStatus(user.equals(credentials.get("user")) && password.equals(credentials.get("password")));
	    if (this.getStatus()){
	        logger.info("User "+credentials.get("user")+ " connected successfully");
	    } else {
	        logger.error("Something went wrong while connecting, incorrect user or password?");
	    }
    }
}
