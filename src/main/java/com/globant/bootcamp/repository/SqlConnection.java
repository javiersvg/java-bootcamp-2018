package com.globant.bootcamp.repository;

import org.apache.log4j.Logger;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 * Stub class for a "sql database connection" with static user and password authentication
 */
public class SqlConnection extends Connection {

    final static Logger logger = Logger.getLogger(SqlConnection.class);

	public SqlConnection(String dbName) {
		super("jdbc:mysql:" + dbName);
	}
	
	@Override
	public void connect(Properties credentials) {
	    ResourceBundle labels = ResourceBundle.getBundle(CREDENTIALS);
	    String user = labels.getString("mysql.user");
	    String password = labels.getString("mysql.password");
	    logger.info("Using stub mysql connection class\n Connecting to mysql server with adress; "+this.getUrl());
	    this.updateStatus(user.equals(credentials.get("user")) && password.equals(credentials.get("password")));   
	    if (this.getStatus()){
	        logger.info("User "+credentials.get("user")+ " connected successfully");
	    } else {
	        logger.error("Something went wrong while connecting, incorrect user or password?");
	    }
    }
}
