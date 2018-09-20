package com.globant.bootcamp.patterns.sinlgeton;

import org.apache.log4j.Logger;
import com.globant.bootcamp.repository.Connection;
import com.globant.bootcamp.repository.PostgresConnection;

/**
 * Singleton of a database connection
 */
public class PostgresConnectionSingleton {

	final static Logger logger = Logger.getLogger(PostgresConnectionSingleton.class);

	private static Connection instance;

	public static Connection getInstance(String dbName) {
		if (instance == null) {
			logger.info("Creating static instance of Postgres connection");
			instance = new PostgresConnection(dbName);
		}
		if ((instance.getStatus() == false) && instance.getUrl() == null){
		    logger.info("Replacing closed connection with new instance");
		    instance = new PostgresConnection(dbName);
		}
		return instance;
	}
}