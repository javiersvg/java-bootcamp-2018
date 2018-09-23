package com.globant.bootcamp.patterns.factory;

import java.util.Properties;

import com.globant.bootcamp.patterns.sinlgeton.PostgresConnection;
import com.globant.bootcamp.repository.Connection;

public class PostgresConnectionFactory extends ConnectionAbstractFactory {
    @Override
    public Connection getConnection(Properties properties) {
        return PostgresConnection.getInstance(properties);
    }
}
