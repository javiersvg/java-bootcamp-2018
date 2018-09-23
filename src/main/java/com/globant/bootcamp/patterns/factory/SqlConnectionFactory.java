package com.globant.bootcamp.patterns.factory;

import java.util.Properties;

import com.globant.bootcamp.patterns.sinlgeton.SqlConnection;
import com.globant.bootcamp.repository.Connection;

public class SqlConnectionFactory extends ConnectionAbstractFactory {
    @Override
    public Connection getConnection(Properties properties) {
        return SqlConnection.getInstance(properties);
    }
}
