package com.globant.bootcamp;

public class MySQLConnection implements Connection {
    
    private String userName;
    private String password;

    public MySQLConnection(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
    
    public MySQLConnection() {}

    @Override
    public void open() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void close() {
        // TODO Auto-generated method stub
        
    }
}
