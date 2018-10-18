package com.globant.bootcamp.service;

import com.globant.bootcamp.domain.Item;

import java.util.List;

public interface ItemService {

	Item createOrUpdate(Item item);

	Item get(Long id);

	void remove(Long id);

	boolean itemAlreadyExists(Long id);

	List<Item> getAllItems();
}
