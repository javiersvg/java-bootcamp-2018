package com.globant.bootcamp;

import com.globant.bootcamp.patterns.builder.ConnectionBuilder;
import com.globant.bootcamp.repository.Connection;
import com.globant.bootcamp.repository.DBType;

public class App {
	public static void main(String[] argsStrings) {
		Connection connection = new ConnectionBuilder(DBType.MYSQL, "jdbc:mysql:store", "admin", "admin")
				.prefetch(true).createConnection();
		connection.connect();
	}
}
