package com.globant.bootcamp;

public class ConnectionProxy implements Connection {
    
    private Connection connection;

    public ConnectionProxy(ConnectionFactory factory) {
        this.connection = factory.getConnection();
    }

    @Override
    public void open() {
        this.connection.open();
    }

    @Override
    public void close() {
        this.connection.close();
    }
}
