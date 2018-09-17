package com.globant.bootcamp;

import java.util.Arrays;
import java.util.Properties;

import org.apache.log4j.Logger;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.assertThat;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;

import com.globant.bootcamp.patterns.factory.FactoryProducer;
import com.globant.bootcamp.repository.Connection;
import com.globant.bootcamp.repository.DBType;

/**
 * Simple tests for different types of connections
 */
@RunWith(Parameterized.class)
public class ConnectionTest {

    final static Logger logger = Logger.getLogger(ConnectionTest.class);
    
    private final Properties credentials;
    private final String dbName;
    private final Enum<DBType> dbType;
    private final boolean expected;
    
    public ConnectionTest(Enum<DBType> dbType, String dbName, String user, String password, boolean expected){
        Properties secret = new Properties();
        secret.put("user", user);
        secret.put("password", password);
        this.credentials = secret;
        this.dbType = dbType;
        this.dbName = dbName;
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
    
    @Test
    public void sqlConnect_validUser(){
        Connection connection = FactoryProducer.getFactory(dbType).getConnection(dbName);
        connection.connect(credentials);
        assertThat(connection.getStatus(),is(equalTo(expected)));
    }
}
