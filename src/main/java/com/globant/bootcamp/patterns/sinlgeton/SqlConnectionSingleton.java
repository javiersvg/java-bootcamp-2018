package com.globant.bootcamp.patterns.sinlgeton;

import org.apache.log4j.Logger;
import com.globant.bootcamp.repository.Connection;
import com.globant.bootcamp.repository.SqlConnection;

/**
 * Singleton of a database connection
 */
public class SqlConnectionSingleton {

	final static Logger logger = Logger.getLogger(SqlConnectionSingleton.class);

	private static Connection instance;

	public static Connection getSqlInstance(String dbName) {
		if (instance == null) {
			logger.info("Creating static instance of Sql connection");
			instance = new SqlConnection(dbName);
		}
		return instance;
	}
}
