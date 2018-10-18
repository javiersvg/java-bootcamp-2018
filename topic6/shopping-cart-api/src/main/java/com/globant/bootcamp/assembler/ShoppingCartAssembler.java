package com.globant.bootcamp.assembler;

import com.globant.bootcamp.domain.Item;
import com.globant.bootcamp.domain.ShoppingCart;
import com.globant.bootcamp.domain.User;
import com.globant.bootcamp.model.ItemDTO;
import com.globant.bootcamp.model.ShoppingCartDTO;
import com.globant.bootcamp.model.UserDTO;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ShoppingCartAssembler implements Assembler<ShoppingCartDTO, ShoppingCart> {

	private ItemAssembler itemAssembler;

	private UserAssembler userAssembler;

	@Override
	public ShoppingCart toEntity(ShoppingCartDTO object) {
		List<Item> items = new ArrayList<>(itemAssembler.toEntityList(object.getItems()));
		User user = userAssembler.toEntity(object.getUser());
		return ShoppingCart.builder().user(user).items(items).id(object.getId()).build();

	}

	@Override
	public ShoppingCartDTO toModel(ShoppingCart entity) {
		List<ItemDTO> items = new ArrayList<>(itemAssembler.toModelList(entity.getItems()));
		UserDTO user = userAssembler.toModel(entity.getUser());
		return ShoppingCartDTO.builder().user(user).items(items).id(entity.getId()).build();
	}

	@Override
	public Collection<ShoppingCart> toEntityList(Collection<ShoppingCartDTO> dtos) {
		return dtos.stream().map(this::toEntity).collect(Collectors.toList());
	}

	@Override
	public Collection<ShoppingCartDTO> toModelList(Collection<ShoppingCart> entities) {
		return entities.stream().map(this::toModel).collect(Collectors.toList());
	}
}
