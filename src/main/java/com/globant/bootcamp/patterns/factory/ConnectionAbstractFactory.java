package com.globant.bootcamp.patterns.factory;

import com.globant.bootcamp.patterns.builder.ConnectionProperties;
import com.globant.bootcamp.repository.Connection;

public abstract class ConnectionAbstractFactory {
	public abstract Connection getConnection(ConnectionProperties properties);
}