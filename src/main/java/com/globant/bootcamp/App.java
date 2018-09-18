package com.globant.bootcamp;

import com.globant.bootcamp.patterns.builder.ConnectionProperties;
import com.globant.bootcamp.patterns.builder.ConnectionProperties.ConnectionPropertiesBuilder;
import com.globant.bootcamp.patterns.sinlgeton.SqlConnectionSingleton;
import com.globant.bootcamp.repository.Connection;

/**
 * Hello world!
 *
 */
public class App {

	public static void main(String[] argsStrings) {
		ConnectionProperties connectionProperties = new ConnectionPropertiesBuilder("admin", "admin").prefetch(true)
				.createConnectionProperties();
		Connection connection = SqlConnectionSingleton.getInstance("store");
		connection.connect(connectionProperties);
	}
}
