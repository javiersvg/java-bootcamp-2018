package com.globant.bootcamp.repository;

public interface Connection {
	void connect();

	boolean isOpen();

	void close();
	
	String getUrl();
	
	enum PropertiesKey {
	    URL, USER, PASSWORD, PREFETCH, ERRORS, DATEFORMAT
	}
}
