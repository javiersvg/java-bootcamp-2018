package com.globant.bootcamp.repository.DAO;

import com.globant.bootcamp.model.Model;

public interface DAO {
	/**
	 * Save an object to persistence storage
	 * @param  thing to be stored
	 */
	void save(Model thing);

	/**
	 * Load from storage an object
	 * @param   objectId the string that identifies the stored object
	 * @return  The object wich id is objectId 
	 */
	Object load(String objectId);
}
