package com.globant.bootcamp.patterns.sinlgeton;

import org.apache.log4j.Logger;

import com.globant.bootcamp.patterns.builder.ConnectionProperties;
import com.globant.bootcamp.repository.Connection;
import com.globant.bootcamp.repository.PostgresConnection;

/**
 * Singleton of a database connection
 */
public class PostgresConnectionSingleton {

	final static Logger logger = Logger.getLogger(PostgresConnectionSingleton.class);

	private static Connection instance;

	public static Connection getInstance(ConnectionProperties properties) {
		if (instance == null) {
			logger.info("Creating static instance of Postgres connection");
			instance = new PostgresConnection(properties);
		}
		if ((instance.getStatus() == false) && instance.getUrl() == null){
		    logger.info("Replacing closed connection with new instance");
		    instance = new PostgresConnection(properties);
		}
		return instance;
	}
}