package com.globant.bootcamp.patterns.builder;

import java.util.Properties;

/**
 * Builder class for creating connection properties with optional parameters
 * Only username and password are required
 */
@SuppressWarnings("serial")
public class ConnectionProperties extends Properties{
    
	private static final String usernameKey = "username";

	private static final String passwordKey = "password";

	private static final String prefetchKey = "prefetch";

	private static final String errorsKey = "errors";

	private static final String dateFormatKey = "date_format";
	
	private ConnectionProperties(final String username, final String password, final boolean prefetch,
		       String errors, String dateFormat) {
	    super();
		this.setProperty(usernameKey, username);
		this.setProperty(passwordKey, password);
		this.setProperty(prefetchKey, String.valueOf(prefetch));
		this.setProperty(errorsKey, String.valueOf(errors));
		this.setProperty(dateFormatKey, String.valueOf(dateFormat));
	}

	public String getDateFormat() {
		return super.getProperty(dateFormatKey);
	}

	public String getUsername() {
		return super.getProperty(usernameKey);
	}

	public String getPassword() {
		return super.getProperty(passwordKey);
	}

	public String getErrors() {
		return super.getProperty(errorsKey);
	}

	public boolean getPrefetch() {
		return Boolean.parseBoolean(super.getProperty(prefetchKey));
	}

	public static class ConnectionPropertiesBuilder {
		private final String nestedUsername;

		private final String nestedPassword;
		
		private boolean nestedPrefetch;

		private String nestedErrors;

		private String nestedDateFormat;

		/* Obligatory fields */
		public ConnectionPropertiesBuilder(final String newUsername, final String newPassword) {
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
			return new ConnectionProperties(nestedUsername, nestedPassword, nestedPrefetch, nestedErrors,
					nestedDateFormat);
		}
	}
}
