package com.globant.bootcamp.repository;

/**
 * Stub class for a "sql database connection" with static user and password authentication
 */
public class SqlConnection extends Connection {

	private static final String SQL_ADMIN_USER = "admin";
	private static final String SQL_ADMIN_PASSWORD = "admin";

	public SqlConnection(String dbName, String user, String password) {
		super.dbUrl = "jdbc:mysql:" + dbName;
		super.status = false;

		if (!SQL_ADMIN_USER.equals(user)) {
			return;
		}

		if (!SQL_ADMIN_PASSWORD.equals(password)) {
			return;
		}

		super.status = true;
	}
}
