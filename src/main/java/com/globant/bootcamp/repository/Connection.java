package com.globant.bootcamp.repository;

import java.util.Properties;

/**
 * Abstract stub class for a database connection
 */
public abstract class Connection {

	/* Resource properties file */
	protected final static String CREDENTIALS = "credentials";

	private String dbUrl;

	private boolean status;

	protected Connection(String dbUrl) {

		if (dbUrl == null) {
			throw new IllegalArgumentException("Database URL can't be null");
		}
		this.dbUrl = dbUrl;
	}

	/**
	 * Tries to connect to a database using the given properties with keys for "user" and "password"
	 */
	public abstract void connect(Properties credentials);

	/**
	 * @return status: If connection with the database is established 
	 */
	public boolean getStatus() {
		return status;
	}

	public String getUrl() {
		return dbUrl;
	}

	protected void updateStatus(boolean status) {
		this.status = status;
	}

}
