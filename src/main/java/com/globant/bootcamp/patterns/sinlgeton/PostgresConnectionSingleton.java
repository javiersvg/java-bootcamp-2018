package com.globant.bootcamp.patterns.sinlgeton;

import com.globant.bootcamp.repository.Connection;
import com.globant.bootcamp.repository.PostgresConnection;

/**
 * Singleton of a database connection
 */
public class PostgresConnectionSingleton {
	private static Connection instance;

	public static Connection getPostgresInstance(String dbName, String user, String password) {
		if (instance == null) {
			instance = new PostgresConnection(dbName, user, password);
		}
		return instance;
	}
}