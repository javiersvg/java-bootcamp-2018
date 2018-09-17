package com.globant.bootcamp.patterns.factory;

import com.globant.bootcamp.repository.Connection;

public abstract class ConnectionAbstractFactory {
	public abstract Connection getConnection(String dbName);
}