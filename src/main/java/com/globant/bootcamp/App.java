package com.globant.bootcamp;

import com.globant.bootcamp.patterns.builder.ConnectionProperties;
import com.globant.bootcamp.patterns.builder.ConnectionProperties.ConnectionPropertiesBuilder;
import com.globant.bootcamp.patterns.sinlgeton.SqlConnection;
import com.globant.bootcamp.repository.Connection;

public class App {
	public static void main(String[] argsStrings) {
		ConnectionProperties connectionProperties = new ConnectionPropertiesBuilder("jdbc:mysql:store", "admin",
				"admin").prefetch(true).createConnectionProperties();
		Connection connection = SqlConnection.getInstance(connectionProperties);
		connection.connect();
	}
}
