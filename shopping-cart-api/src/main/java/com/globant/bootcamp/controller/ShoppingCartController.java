package com.globant.bootcamp.controller;

import com.globant.bootcamp.assembler.ShoppingCartAssembler;
import com.globant.bootcamp.domain.Item;
import com.globant.bootcamp.domain.ShoppingCart;
import com.globant.bootcamp.domain.User;
import com.globant.bootcamp.model.ShoppingCartDTO;
import com.globant.bootcamp.service.ItemService;
import com.globant.bootcamp.service.ShoppingCartService;
import com.globant.bootcamp.service.UserService;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/api/shoppingcart")
@AllArgsConstructor(onConstructor = @__(@Autowired))
@Api
public class ShoppingCartController {

	private ShoppingCartService shoppingCartService;

	private UserService userService;

	private ItemService itemService;

	private ShoppingCartAssembler cartAssembler;

	@PostMapping(value = "/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ShoppingCartDTO> newShoppingCart(@PathVariable Long userId) {
		User owner = userService.get(userId);
		ResponseEntity<ShoppingCartDTO> response;
		if (owner != null) {
			ShoppingCart shoppingCart = new ShoppingCart();
			owner.setShoppingCart(shoppingCart);
			owner = userService.createOrUpdate(owner);
			response = new ResponseEntity<>(cartAssembler.toModel(owner.getShoppingCart()),
					HttpStatus.CREATED);
		}
		else {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return response;
	}

	@PutMapping(value = "/{shoppingCartId}/{itemId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ShoppingCartDTO> addItemToCart(@PathVariable Long shoppingCartId,
			@PathVariable Long itemId) {
		ShoppingCart shoppingCart = shoppingCartService.get(shoppingCartId);
		Item item = itemService.get(itemId);
		ResponseEntity<ShoppingCartDTO> response;
		if (shoppingCart != null && item != null) {
			shoppingCart.addItem(item);
			shoppingCart = shoppingCartService.createOrUpdate(shoppingCart);
			response = new ResponseEntity<>(cartAssembler.toModel(shoppingCart), HttpStatus.OK);
		}
		else {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return response;
	}

	@DeleteMapping(value = "/{shoppingCartId}/{itemId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ShoppingCartDTO> removeItemFromCart(@PathVariable Long shoppingCartId,
			@PathVariable Long itemId) {
		ShoppingCart shoppingCart = shoppingCartService.get(shoppingCartId);
		ResponseEntity<ShoppingCartDTO> response;
		if (shoppingCart != null && shoppingCart.contains(itemId)) {
			Item itemToRemove = shoppingCart.getItem(itemId).get();
			shoppingCart.removeItem(itemToRemove);
			shoppingCartService.createOrUpdate(shoppingCart);
			response = new ResponseEntity<>(cartAssembler.toModel(shoppingCart), HttpStatus.OK);
		}
		else {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return response;
	}

	@DeleteMapping(value = "{shoppingCartId}")
	public ResponseEntity<Void> removeShoppingCart(@PathVariable Long shoppingCartId) {
		shoppingCartService.remove(shoppingCartId);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ShoppingCartDTO>> getAll() {
		List<ShoppingCartDTO> storedCarts = shoppingCartService.getAll().stream().map(cartAssembler::toModel)
				.collect(
						Collectors.toList());
		return new ResponseEntity<>(storedCarts, HttpStatus.OK);
	}
}
