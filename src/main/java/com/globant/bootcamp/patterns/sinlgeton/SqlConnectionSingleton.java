package com.globant.bootcamp.patterns.sinlgeton;

import org.apache.log4j.Logger;

import com.globant.bootcamp.patterns.builder.ConnectionProperties;
import com.globant.bootcamp.repository.Connection;
import com.globant.bootcamp.repository.SqlConnection;

/**
 * Singleton of a database connection
 */
public class SqlConnectionSingleton {

	final static Logger logger = Logger.getLogger(SqlConnectionSingleton.class);

	private static Connection instance;

	public static Connection getInstance(ConnectionProperties properties) {
		if (instance == null) {
			logger.info("Creating static instance of Sql connection");
			instance = new SqlConnection(properties);
		}
		if ((instance.getStatus() == false) && instance.getUrl() == null){
		    logger.info("Replacing closed connection with new instance");
		    instance = new SqlConnection(properties);
		}
		return instance;
	}
}
