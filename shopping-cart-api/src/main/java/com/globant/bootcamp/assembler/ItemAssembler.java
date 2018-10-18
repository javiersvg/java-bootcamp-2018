package com.globant.bootcamp.assembler;

import com.globant.bootcamp.domain.Item;
import com.globant.bootcamp.model.ItemDTO;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.stream.Collectors;

@Component
public class ItemAssembler implements Assembler<ItemDTO, Item> {

	@Override
	public Item toEntity(ItemDTO item) {
		return Item.builder()
				.name(item.getName())
				.id(item.getId())
				.category(item.getCategory())
				.price(item.getPrice())
				.build();
	}

	@Override
	public ItemDTO toModel(Item entity) {
		return ItemDTO.builder()
				.name(entity.getName())
				.id(entity.getId())
				.category(entity.getCategory())
				.price(entity.getPrice())
				.build();
	}

	@Override
	public Collection<Item> toEntityList(Collection<ItemDTO> dtos) {
		return dtos.stream().map(this::toEntity).collect(Collectors.toList());
	}

	@Override
	public Collection<ItemDTO> toModelList(Collection<Item> entities) {
		return entities.stream().map(this::toModel).collect(Collectors.toList());
	}
}
