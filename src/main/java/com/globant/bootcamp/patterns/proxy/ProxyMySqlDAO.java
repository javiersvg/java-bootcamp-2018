package com.globant.bootcamp.patterns.proxy;

import java.util.Date;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.globant.bootcamp.model.Model;
import com.globant.bootcamp.repository.DAO.DAO;
import com.globant.bootcamp.repository.DAO.MySqlDAO;

public class ProxyMySqlDAO implements DAO {
    
    private final Logger logger = Logger.getLogger(ProxyMySqlDAO.class);
    
    private MySqlDAO realDAO;
    
    private String dbName;
    
    private Properties credentials;
    
    public ProxyMySqlDAO(String dbName, Properties credentials) {
        logger.info("Creating proxy at " + new Date());
        this.dbName = dbName;
        this.credentials = credentials;
    }
    
    @Override
    public void save(Model thing) {
        if (realDAO == null) {
			realDAO = new MySqlDAO(dbName, credentials);
		}
        realDAO.save(thing);
    }
    
    @Override
    public Object load(String objectId) {
        if (realDAO == null) {
			realDAO = new MySqlDAO(dbName, credentials);
		}
        return realDAO.load(objectId);
    }
}
