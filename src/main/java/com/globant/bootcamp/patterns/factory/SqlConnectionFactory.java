package com.globant.bootcamp.patterns.factory;

import com.globant.bootcamp.repository.SqlConnection;
import com.globant.bootcamp.repository.Connection;

public class SqlConnectionFactory extends ConnectionAbstractFactory {
    @Override
    public Connection getConnection(String dbName) {
       return new SqlConnection(dbName);
    }
}
