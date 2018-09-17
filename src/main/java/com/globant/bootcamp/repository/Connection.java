package com.globant.bootcamp.repository;

import java.util.Properties;

/**
 * Contract for the Connection class
 */
public interface Connection {
	/**
	 * Tries to connect to a database using the given properties with keys for "user" and "password"
	 */
	public abstract void connect(Properties credentials);

	/**
	 * @return status: If connection with the database is established 
	 */
	public boolean getStatus();

	public String getUrl();
}
