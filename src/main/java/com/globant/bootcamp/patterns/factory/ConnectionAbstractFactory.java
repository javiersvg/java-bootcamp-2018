package com.globant.bootcamp.patterns.factory;

import java.util.Properties;

import com.globant.bootcamp.repository.Connection;

public abstract class ConnectionAbstractFactory {
	public abstract Connection getConnection(Properties properties);
}