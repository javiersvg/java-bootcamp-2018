package com.globant.bootcamp.patterns.proxy;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.globant.bootcamp.model.Model;
import com.globant.bootcamp.repository.Connection;
import com.globant.bootcamp.repository.DAO.DAO;
import com.globant.bootcamp.repository.DAO.SqlDAO;

public class ProxySqlDAO implements DAO {
    
    private final static Logger LOGGER = LoggerFactory.getLogger(ProxySqlDAO.class);
    
    private SqlDAO realDAO;
    
    private Connection connection;
    
    public ProxySqlDAO(Connection connection) {
        LOGGER.info("Creating proxy at {}", new Date());
        this.connection = connection;
    }
    
    @Override
    public void save(Model thing) {
        if (realDAO == null) {
			realDAO = new SqlDAO(connection);
		}
        realDAO.save(thing);
    }
    
    @Override
    public Object load(String objectId) {
        if (realDAO == null) {
			realDAO = new SqlDAO(connection);
		}
        return realDAO.load(objectId);
    }
}
