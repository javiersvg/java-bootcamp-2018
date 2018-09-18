package com.globant.bootcamp.repository;

import com.globant.bootcamp.patterns.builder.ConnectionProperties;

/**
 * Contract for the Connection class
 */
public interface Connection {
	/**
	 * Tries to connect to a database using the given properties with keys for "user" and "password"
	 */
	void connect(ConnectionProperties credentials);

	/**
	 * @return status: If connection with the database is established 
	 */
	boolean getStatus();

	String getUrl();
}
