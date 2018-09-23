package com.globant.bootcamp.patterns.factory;

import com.globant.bootcamp.patterns.builder.ConnectionProperties;
import com.globant.bootcamp.patterns.sinlgeton.SqlConnection;
import com.globant.bootcamp.repository.Connection;

public class SqlConnectionFactory extends ConnectionAbstractFactory {
    @Override
    public Connection getConnection(ConnectionProperties properties) {
        return SqlConnection.getInstance(properties);
    }
}
