package com.globant.bootcamp;

public class MySQLConnectionFactory implements ConnectionFactory {

    @Override
    public Connection getConnection() {
        return new MySQLConnection();
    }
}
