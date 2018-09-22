package com.globant.bootcamp.repository;

/**
 * Contract for the Connection class
 */
public interface Connection {
	/**
	 * Tries to connect to a database
	 */
	void connect();

	/**
	 * @return status: If connection with the database is established 
	 */
	boolean getStatus();
	
	/**
	 * Closes the connection
	 */
	void close();

	String getUrl();
}
