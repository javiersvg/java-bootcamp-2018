package com.globant.bootcamp.repository.DAO;

import java.util.Properties;

import org.apache.log4j.Logger;

import com.globant.bootcamp.model.Model;
import com.globant.bootcamp.patterns.factory.FactoryProducer;
import com.globant.bootcamp.repository.Connection;
import com.globant.bootcamp.repository.DBType;

public class PostgresDAO implements DAO {
  
    private final Logger logger = Logger.getLogger(PostgresDAO.class);
    private Connection connection;
    
    public PostgresDAO(String dbName, Properties credentials) {
        connection = FactoryProducer.getFactory(DBType.POSTGRES).getConnection(dbName);
        connection.connect(credentials);
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
