package com.globant.bootcamp;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import com.globant.bootcamp.patterns.builder.ConnectionBuilder;
import com.globant.bootcamp.repository.Connection;
import com.globant.bootcamp.repository.DBType;

/**
 * Simple tests for different types of connections
 */
@RunWith(Parameterized.class)
public class ConnectionTest {
    
    private Connection connection;
    
    private final String url;
    private final String username;
    private final String password;
    private final DBType dbType;
    private final boolean expected;
    
    public ConnectionTest(DBType dbType, String url, String username, String password, boolean expected){
        this.url = url;
        this.username = username;
        this.password = password;
        this.dbType = dbType;
        this.expected = expected;
    }
    
    @Parameterized.Parameters(name = "{index}: Test connection with user={2}, password={3}, result: {4}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] {
            {DBType.MYSQL,"cars","admin", "admin", true},
            {DBType.MYSQL,"eshop","pepe", "123456seven", false},
            {DBType.POSTGRES, "petstore", "root", "admin", true},
            {DBType.POSTGRES,"facebook", "", "", false}
        });
    }
    
    @Before
    public void createConneciton(){
        connection = new ConnectionBuilder(dbType, url, username, password).createConnection();
    }
    
    @Test
    public void sqlConnect_validUser(){
        connection.connect();
        assertThat(connection.isOpen(),is(equalTo(expected)));
    }
    
    @After
    public void closeConnection(){
        connection.close();
    }
}
