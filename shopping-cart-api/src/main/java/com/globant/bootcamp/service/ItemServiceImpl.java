package com.globant.bootcamp.service;

import com.globant.bootcamp.domain.Item;
import com.globant.bootcamp.repository.ItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ItemServiceImpl implements ItemService {

	private final ItemRepository itemRepository;

	@Override
	public Item createOrUpdate(Item item) {
		Item newItem = itemRepository.save(item);
		itemRepository.flush();
		return newItem;
	}

	@Override
	public Item get(Long id) {
		return itemRepository.findById(id).orElse(null);
	}

	@Override
	public void remove(Long id) {
		itemRepository.deleteById(id);
	}

	@Override
	public boolean itemAlreadyExists(Long id) {
		return itemRepository.existsById(id);
	}

	@Override
	public List<Item> getAllItems() {
		return itemRepository.findAll();
	}
}
