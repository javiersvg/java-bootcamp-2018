package com.globant.bootcamp.patterns.builder;

import java.util.Properties;

import lombok.Getter;

import com.globant.bootcamp.patterns.factory.FactoryProducer;
import com.globant.bootcamp.repository.Connection;
import com.globant.bootcamp.repository.DBType;

/**
 * Builder class for creating connections with optional parameters
 * Required fields: Database Type, Url, Username, Password
 */
public class ConnectionBuilder {

	@Getter private final DBType dbType;

	@Getter private final String dbUrl;

	@Getter private final String username;

	@Getter private final String password;

	@Getter private String prefetch = "false";

	@Getter private String logLevel = "DEBUG";

	@Getter private String dateFormat = "yyyy/MM/dd";

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
