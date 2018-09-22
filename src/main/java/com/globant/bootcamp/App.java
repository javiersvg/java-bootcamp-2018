package com.globant.bootcamp;

import com.globant.bootcamp.patterns.sinlgeton.SqlConnection;
import com.globant.bootcamp.repository.Connection;

import java.util.Properties;

public class App {

	public static void main(String[] argsStrings) {
		Properties credentials = new Properties();
		credentials.put("user", "admin");
		credentials.put("password", "admin");

		Connection connection = SqlConnection.getInstance("store");
		connection.connect(credentials);
	}
}
