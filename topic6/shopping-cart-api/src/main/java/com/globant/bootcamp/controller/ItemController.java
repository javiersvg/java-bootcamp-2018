package com.globant.bootcamp.controller;

import com.globant.bootcamp.assembler.ItemAssembler;
import com.globant.bootcamp.domain.Item;
import com.globant.bootcamp.model.ItemDTO;
import com.globant.bootcamp.service.ItemService;
import io.swagger.annotations.*;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/api/items")
@AllArgsConstructor(onConstructor = @__(@Autowired))
@Api
public class ItemController {

	private final ItemService itemService;

	private final ItemAssembler itemAssembler;

	@PostMapping(value = "/")
	@ApiOperation(value = "Create item", notes = "Creates a item with different attributes")
	@ApiResponses({
			@ApiResponse(code = 201, message = "Created item sucessfully"),
	})
	public ResponseEntity<ItemDTO> newItem(
			@ApiParam(required = true, name = "JSONRequest", value = "Json with the item model")
			@Valid @RequestBody ItemDTO item) {
		log.info("Creating item {}", item.getName());
		Item createdItem = itemService.createOrUpdate(itemAssembler.toEntity(item));
		log.info("Item {} with id {} created successfully", createdItem.getName(), createdItem.getId());
		return new ResponseEntity<>(itemAssembler.toModel(createdItem), HttpStatus.CREATED);
	}

	@GetMapping(value = "/{itemID}")
	@ApiOperation(value = "Get item with id", notes = "Returns the removed item")
	@ApiResponses({
			@ApiResponse(code = 404, message = "Item with given id cannot be found"),
	})
	public ResponseEntity<ItemDTO> getItem(
			@Validated @PathVariable Long itemID
	) {
		ResponseEntity<ItemDTO> response;
		log.info("Reading item with id {} ", itemID);
		if (itemService.itemAlreadyExists(itemID))
			response = new ResponseEntity<>(itemAssembler.toModel(itemService.get(itemID)), HttpStatus.OK);
		else
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		return response;
	}

	@DeleteMapping(value = "/{itemID}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Delete item with id", notes = "Returns the Item with the given id if exists")
	@ApiResponses({
			@ApiResponse(code = 404, message = "Item with given id cannot be found"),
	})
	public ResponseEntity<Void> removeItem(
			@PathVariable Long itemID
	) {
		ResponseEntity<Void> response;
		log.info("Removing item with id {} ", itemID);
		if (itemService.itemAlreadyExists(itemID)) {
			itemService.remove(itemID);
			response = new ResponseEntity<>(HttpStatus.OK);
		}
		else
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		return response;
	}

	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Get all items", notes = "Returns all the stored items in the database")
	public ResponseEntity<List<ItemDTO>> getItems() {
		log.info("Getting all the items ");
		List<ItemDTO> storedItems = itemService.getAllItems().stream().map(itemAssembler::toModel)
				.collect(Collectors.toList());
		return new ResponseEntity<>(storedItems, HttpStatus.OK);
	}

	@GetMapping(value = "/filter/", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Get all items with the applied filters", notes = "Returns all the stored items in the database")
	public ResponseEntity<List<ItemDTO>> getItemsByCategory(
			@ApiParam(required = false, name = "category", value = "Category of the item")
			@RequestParam(required = false) String category,
			@ApiParam(required = false, name = "namelike", value = "Part of the item name")
			@RequestParam(required = false) String namelike
	) {
		List<ItemDTO> allItems = itemService.getAllItems()
				.stream()
				.map(itemAssembler::toModel)
				.collect(Collectors.toList());

		if (category != null) {
			log.info("Filtering all the items with category {}", category);
			allItems.removeIf(item -> !item.getCategory().equals(category));
		}

		if (namelike != null) {
			log.info("Filtering all the items with name like {}", namelike);
			allItems.removeIf(item -> !containsIgnoreCase(item.getName(), namelike));
		}
		return new ResponseEntity<>(allItems, HttpStatus.OK);
	}

	public static boolean containsIgnoreCase(String str, String searchStr) {
		if (str == null || searchStr == null)
			return false;

		final int length = searchStr.length();
		if (length == 0)
			return true;

		for (int i = str.length() - length; i >= 0; i--) {
			if (str.regionMatches(true, i, searchStr, 0, length))
				return true;
		}
		return false;
	}
}
