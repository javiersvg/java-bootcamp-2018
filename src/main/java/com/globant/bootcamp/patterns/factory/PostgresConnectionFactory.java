package com.globant.bootcamp.patterns.factory;

import com.globant.bootcamp.patterns.sinlgeton.PostgresConnectionSingleton;
import com.globant.bootcamp.repository.Connection;

public class PostgresConnectionFactory extends ConnectionAbstractFactory {
    
    @Override
    public Connection getPostgresConnection(String dbName) {
        return PostgresConnectionSingleton.getPostgresInstance(dbName);
    }
    
    @Override
    public Connection getSqlConnection(String dbName) {
        return null;
    }
}
