package com.globant.bootcamp.patterns.factory;

import java.util.Properties;

import com.globant.bootcamp.repository.Connection;

public class NullConnectionFactory extends ConnectionAbstractFactory {
    @Override
    public Connection getConnection(Properties properties) {
        return null;
    }
}
