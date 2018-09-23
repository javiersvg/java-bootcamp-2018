package com.globant.bootcamp.repository;

public interface Connection {
	void connect();

	boolean isOpen();

	void close();
	
	String getUrl();
}
