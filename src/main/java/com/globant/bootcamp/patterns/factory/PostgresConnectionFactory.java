package com.globant.bootcamp.patterns.factory;

import com.globant.bootcamp.patterns.builder.ConnectionProperties;
import com.globant.bootcamp.patterns.sinlgeton.PostgresConnection;
import com.globant.bootcamp.repository.Connection;

public class PostgresConnectionFactory extends ConnectionAbstractFactory {
    @Override
    public Connection getConnection(ConnectionProperties properties) {
        return PostgresConnection.getInstance(properties);
    }
}
