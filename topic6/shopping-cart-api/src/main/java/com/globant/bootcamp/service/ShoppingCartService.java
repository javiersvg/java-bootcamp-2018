package com.globant.bootcamp.service;

import com.globant.bootcamp.domain.ShoppingCart;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ShoppingCartService {

	public ShoppingCart createOrUpdate(ShoppingCart shoppingCart);

	public ShoppingCart get(Long id);

	public void remove(Long id);

	public boolean shoppingCartExists(Long id);

	public List<ShoppingCart> getAll();

}