package com.globant.bootcamp;

public class MySQLConnectionBuilder {
    private String password;
    private String userName;

    public MySQLConnectionBuilder withPassword(String password){
        this.password = password;
        return this;
    }
    
    public MySQLConnectionBuilder withUserName(String userName) {
        this.userName = userName;
        return this;
    }
    
    public Connection build() {
        return new MySQLConnection(userName, password);
    }
}
