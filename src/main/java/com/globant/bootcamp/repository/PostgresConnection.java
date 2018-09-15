package com.globant.bootcamp.repository;

/**
 * Stub class for a "postgres database connection" with static user and password authentication
 */
public class PostgresConnection extends Connection {

	private static final String PG_ADMIN_USER = "admin";
	private static final String PG_ADMIN_PASSWORD = "admin";

	public PostgresConnection(String dbName, String user, String password) {
		super.dbUrl = "jdbc:postgres:" + dbName;
		super.status = false;

		if (!PG_ADMIN_USER.equals(user)) {
			return;
		}

		if (!PG_ADMIN_PASSWORD.equals(password)) {
			return;
		}

		super.status = true;
	}
}
