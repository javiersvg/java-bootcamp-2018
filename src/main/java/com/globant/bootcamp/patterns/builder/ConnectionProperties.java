package com.globant.bootcamp.patterns.builder;


/**
 * Builder class for creating connection properties with optional parameters
 * Only username and password are required
 */
public class ConnectionProperties {

	private final String dbUrl;

	private final String username;

	private final String password;

	private final boolean prefetch;

	private final String errors;

	private final String dateFormat;

	private ConnectionProperties(final String dbUrl, final String username, final String password,
			final boolean prefetch, final String errors, final String dateFormat) {
		this.dbUrl = dbUrl;
		this.username = username;
		this.password = password;
		this.prefetch = prefetch;
		this.errors = errors;
		this.dateFormat = dateFormat;
	}

	public String getUrl() {
		return this.dbUrl;
	}

	public String getDateFormat() {
		return this.dateFormat;
	}

	public String getUsername() {
		return this.username;
	}

	public String getPassword() {
		return this.password;
	}

	public String getErrors() {
		return this.errors;
	}

	public boolean getPrefetch() {
		return this.prefetch;
	}

	public static class ConnectionPropertiesBuilder {

		private final String nestedDbUrl;

		private final String nestedUsername;

		private final String nestedPassword;

		private boolean nestedPrefetch;

		private String nestedErrors;

		private String nestedDateFormat;

		/* Obligatory fields */
		public ConnectionPropertiesBuilder(final String newDbUrl, final String newUsername, final String newPassword) {
			this.nestedDbUrl = newDbUrl;
			this.nestedUsername = newUsername;
			this.nestedPassword = newPassword;
		}
        
		public ConnectionPropertiesBuilder prefetch(final boolean newPrefetch) {
			this.nestedPrefetch = newPrefetch;
			return this;
		}

		public ConnectionPropertiesBuilder errors(final String newErrors) {
			this.nestedErrors = newErrors;
			return this;
		}

		public ConnectionPropertiesBuilder dateFormat(final String newDateFormat) {
			this.nestedDateFormat = newDateFormat;
			return this;
		}

		public ConnectionProperties createConnectionProperties() {
			return new ConnectionProperties(nestedDbUrl, nestedUsername, nestedPassword, nestedPrefetch, nestedErrors,
					nestedDateFormat);
		}
	}
}
