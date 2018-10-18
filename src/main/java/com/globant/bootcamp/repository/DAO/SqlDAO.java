package com.globant.bootcamp.repository.DAO;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.globant.bootcamp.model.Model;
import com.globant.bootcamp.repository.Connection;

public class SqlDAO implements DAO {
    
    private final static Logger LOGGER = LoggerFactory.getLogger(SqlDAO.class);
    private Connection connection;
    
    public SqlDAO(Connection connection) {
        this.connection = connection;
        connection.connect();
    }
    
    @Override
    public void save(Model thing) {
        if(connection.isOpen()) {
            LOGGER.info("Storing thing wih id: {}", thing.getKey()); //TODO Store the thing
        } else {
            LOGGER.warn("Connection to storage not established, thing with id: {} not saved", thing.getKey());
        }        
    }
    
    @Override
    public Object load(String objectId) {
        if(connection.isOpen()) {
            LOGGER.info("Storing thing wih id: {}", objectId); //TODO: Get the thing
        } else {
            LOGGER.warn("Connection to storage not established, can't read thing with id: " + objectId);
        }
        return null;
    }
}