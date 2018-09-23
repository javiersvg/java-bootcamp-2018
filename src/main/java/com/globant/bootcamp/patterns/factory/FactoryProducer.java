package com.globant.bootcamp.patterns.factory;

import com.globant.bootcamp.repository.DBType;

public class FactoryProducer {

	public static ConnectionAbstractFactory getFactory(DBType choice) {
		ConnectionAbstractFactory selectedFactory;
		switch (choice) {
		case MYSQL:
			selectedFactory = new SqlConnectionFactory();
			break;
		case POSTGRES:
			selectedFactory = new PostgresConnectionFactory();
			break;
		default:
		    selectedFactory = new NullConnectionFactory();
			break;
		}
		return selectedFactory;
	}
}
