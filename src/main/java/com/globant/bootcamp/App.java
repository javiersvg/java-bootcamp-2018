package com.globant.bootcamp;

import com.globant.bootcamp.patterns.sinlgeton.SqlConnectionSingleton;
import com.globant.bootcamp.repository.Connection;

/**
 * Hello world!
 *
 */
public class App {

	public static void main(String[] argsStrings) {
		Connection SqlCon = SqlConnectionSingleton.getSqlInstance("store", "admin", "admin");

		System.out.println("Connecting to:" + SqlCon.getUrl());

		if (SqlCon.getStatus()) {
			System.out.println("Ready to go");
		}
		else {
			System.out.println("Something went wrong!");
		}
	}
}
