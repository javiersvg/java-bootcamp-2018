package com.globant.bootcamp.patterns.builder;

import java.util.Properties;

import com.globant.bootcamp.patterns.factory.FactoryProducer;
import com.globant.bootcamp.repository.Connection;
import com.globant.bootcamp.repository.DBType;

/**
 * Builder class for creating connections with optional parameters
 * Required fields: Database Type, Url, Username, Password
 */
public class ConnectionBuilder {

	private final DBType dbType;

	private final String dbUrl;

	private final String username;

	private final String password;

	private String prefetch = "false";

	private String logLevel = "DEBUG";

	private String dateFormat = "yyyy/MM/dd";

	/* Obligatory fields */
	public ConnectionBuilder(final DBType newDbType, final String newDbUrl, final String newUsername,
			final String newPassword) {
		dbType = newDbType;
		dbUrl = newDbUrl;
		username = newUsername;
		password = newPassword;
	}

	public ConnectionBuilder prefetch(final boolean newPrefetch) {
		prefetch = String.valueOf(newPrefetch);
		return this;
	}

	public ConnectionBuilder errors(final String newErrors) {
		logLevel = newErrors;
		return this;
	}

	public ConnectionBuilder dateFormat(final String newDateFormat) {
		dateFormat = newDateFormat;
		return this;
	}

	public Connection createConnection() {
		Properties connectionProperties = new Properties();
		connectionProperties.setProperty(Connection.PropertiesKey.USER.name(), username);
		connectionProperties.setProperty(Connection.PropertiesKey.PASSWORD.name(), password);
		connectionProperties.setProperty(Connection.PropertiesKey.URL.name(), dbUrl);
		connectionProperties.setProperty(Connection.PropertiesKey.PREFETCH.name(), prefetch);
		connectionProperties.setProperty(Connection.PropertiesKey.ERRORS.name(), logLevel);
		connectionProperties.setProperty(Connection.PropertiesKey.DATEFORMAT.name(), dateFormat);
		return FactoryProducer.getFactory(dbType).getConnection(connectionProperties);
	}
}
