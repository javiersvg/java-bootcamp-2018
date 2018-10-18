package com.globant.bootcamp.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel(value = "Shopping Cart", description = "A shopping cart that holds items for a user")
public class ShoppingCartDTO {

	@ApiModelProperty(value = "id of the shopping cart", readOnly = true, required = true)
	@NotNull
	private Long id;

	@ApiModelProperty(value = "User of the cart", required = true)
	@NotNull(message = "Cart must have an owner")
	private UserDTO user;

	@ApiModelProperty(value = "Added items in the cart", required = true)
	private List<ItemDTO> items = new ArrayList<>();

	@ApiModelProperty(value = "Total value of all the items in this cart")
	public long getPurchaseTotal() {
		long total = 0L;
		if (!items.isEmpty())
			total = items.stream().mapToLong(ItemDTO::getPrice).sum();
		return total;
	}

}
