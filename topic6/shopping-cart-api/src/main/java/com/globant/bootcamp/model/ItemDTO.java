package com.globant.bootcamp.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ApiModel(value = "Item", description = "A item that can be added to a shopping cart")
public class ItemDTO {

	@EqualsAndHashCode.Include
	@ApiModelProperty(value = "id of the item", hidden = true, readOnly = true, required = true)
	private Long id;

	@ApiModelProperty(value = "Item name", required = true)
	@NotNull(message = "Item must have a name")
	private String name;

	@ApiModelProperty(value = "Category of the item", required = false)
	private String category;

	@ApiModelProperty(value = "Price of the item", required = true)
	@NotNull(message = "Item must have a price")
	private Long price;
}
