package com.globant.bootcamp.repository;

import java.util.Properties;

public interface Connection {
	/**
	 * Tries to connect to a database using the given properties with keys for "user" and "password"
	 */
	void connect(Properties credentials);
	
	boolean isOpen();

	String getUrl();
}
