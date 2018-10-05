package com.globant.bootcamp;

public class DataBaseConnection {
    
    private DataBaseConnection(){}
    
    public static DataBaseConnection getInstance() {
        return new DataBaseConnection();
    }
}
