package com.globant.bootcamp.service;

import com.globant.bootcamp.domain.ShoppingCart;
import com.globant.bootcamp.domain.User;
import com.globant.bootcamp.repository.ShoppingCartRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ShoppingCartServiceImpl implements ShoppingCartService {

	private ShoppingCartRepository shoppingCartRepository;

	private UserService userService;

	@Override
	public ShoppingCart createOrUpdate(ShoppingCart shoppingCart) {
		ShoppingCart storedCart = shoppingCartRepository.save(shoppingCart);
		shoppingCartRepository.flush();
		return storedCart;
	}

	@Override
	public ShoppingCart get(Long id) {
		return shoppingCartRepository.findById(id).orElse(null);
	}

	@Override
	public void remove(Long id) {
		ShoppingCart cartToRemove = get(id);
		if (cartToRemove != null) {
			User owner = cartToRemove.getUser();
			owner.removeCart();
			userService.createOrUpdate(owner);
		}
	}

	@Override
	public boolean shoppingCartExists(Long id) {
		return shoppingCartRepository.existsById(id);
	}

	@Override
	public List<ShoppingCart> getAll() {
		return shoppingCartRepository.findAll();
	}
}
