package com.globant.bootcamp;

import com.globant.bootcamp.patterns.factory.ConnectionAbstractFactory;
import com.globant.bootcamp.patterns.factory.FactoryProducer;
import com.globant.bootcamp.patterns.sinlgeton.SqlConnectionSingleton;
import com.globant.bootcamp.repository.Connection;
import java.util.Properties;

/**
 * Hello world!
 *
 */
public class App {

	public static void main(String[] argsStrings) {
		Properties credentials = new Properties();
		credentials.put("user", "admin");
		credentials.put("password", "admin");

		Connection connection = SqlConnectionSingleton.getSqlInstance("store");
		connection.connect(credentials);
	}
}
