package com.globant.bootcamp.repository;

/**
 * Abstract stub class for a database connection
 */
public abstract class Connection {

	protected String dbUrl;

	protected boolean status;

	/**
	 * @return status: If connection with the database is established 
	 */
	public boolean getStatus() {
		return status;
	}

	public String getUrl() {
		return dbUrl;
	}
}
