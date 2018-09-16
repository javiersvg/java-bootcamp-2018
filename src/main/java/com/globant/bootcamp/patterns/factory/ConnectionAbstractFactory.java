package com.globant.bootcamp.patterns.factory;

import com.globant.bootcamp.repository.Connection;

public abstract class ConnectionAbstractFactory {

	public abstract Connection getSqlConnection(String dbName);

	public abstract Connection getPostgresConnection(String dbName);
}