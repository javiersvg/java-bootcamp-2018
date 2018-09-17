package com.globant.bootcamp.patterns.factory;

import com.globant.bootcamp.patterns.sinlgeton.SqlConnectionSingleton;
import com.globant.bootcamp.repository.Connection;

public class SqlConnectionFactory extends ConnectionAbstractFactory {
    @Override
    public Connection getConnection(String dbName) {
        return SqlConnectionSingleton.getSqlInstance(dbName);
    }
}
