package com.globant.bootcamp.patterns.sinlgeton;

import com.globant.bootcamp.repository.Connection;
import com.globant.bootcamp.repository.SqlConnection;

/**
 * Singleton of a database connection
 */
public class SqlConnectionSingleton {
	private static Connection instance;

	public static Connection getSqlInstance(String dbName, String user, String password) {
		if (instance == null) {
			instance = new SqlConnection(dbName, user, password);
		}
		return instance;
	}
}
