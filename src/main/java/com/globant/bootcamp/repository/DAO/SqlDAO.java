package com.globant.bootcamp.repository.DAO;

import org.apache.log4j.Logger;

import com.globant.bootcamp.model.Model;
import com.globant.bootcamp.repository.Connection;

public class SqlDAO implements DAO {
    
    private final Logger logger = Logger.getLogger(SqlDAO.class);
    private Connection connection;
    
    public SqlDAO(Connection connection) {
        this.connection = connection;
        connection.connect();
    }
    
    @Override
    public void save(Model thing) {
        if(connection.getStatus()) {
            logger.info("Storing thing wih id: " + thing.getKey()); //TODO Store the thing
        } else {
            logger.warn("Connection to storage not established, thing with id: " + thing.getKey() + " not saved");
        }        
    }
    
    @Override
    public Object load(String objectId) {
        if(connection.getStatus()) {
            logger.info("Storing thing wih id: " + objectId); //TODO: Get the thing
        } else {
            logger.warn("Connection to storage not established, can't read thing with id: " + objectId);
        }
        return null;
    }
}