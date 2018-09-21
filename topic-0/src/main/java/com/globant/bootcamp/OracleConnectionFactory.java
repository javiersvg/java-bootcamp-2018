package com.globant.bootcamp;

public class OracleConnectionFactory implements ConnectionFactory {

    @Override
    public Connection getConnection() {
        return new OracleConnection();
    }
}
