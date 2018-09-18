package com.globant.bootcamp;

import java.util.Arrays;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;

import com.globant.bootcamp.patterns.builder.ConnectionProperties;
import com.globant.bootcamp.patterns.builder.ConnectionProperties.ConnectionPropertiesBuilder;
import com.globant.bootcamp.patterns.factory.FactoryProducer;
import com.globant.bootcamp.repository.Connection;
import com.globant.bootcamp.repository.DBType;

/**
 * Simple tests for different types of connections
 */
@RunWith(Parameterized.class)
public class ConnectionTest {

    final static Logger logger = Logger.getLogger(ConnectionTest.class);
    
    private Connection connection;
    
    private final ConnectionProperties credentials;
    private final String dbName;
    private final Enum<DBType> dbType;
    private final boolean expected;
    
    public ConnectionTest(Enum<DBType> dbType, String dbName, String user, String password, boolean expected){
        this.credentials = new ConnectionPropertiesBuilder(user, password).createConnectionProperties();
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
    
    @Before
    public void createConneciton(){
        connection = FactoryProducer.getFactory(dbType).getConnection(dbName);
    }
    
    @Test
    public void sqlConnect_validUser(){
        connection.connect(credentials);
        assertThat(connection.getStatus(),is(equalTo(expected)));
    }
    
    @After
    public void closeConnection(){
        logger.info("Clossing connection " + connection.getUrl());
        //TODO Close connection
    }
}
