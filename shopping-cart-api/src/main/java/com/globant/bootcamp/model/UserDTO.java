package com.globant.bootcamp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.globant.bootcamp.assembler.ShoppingCartAssembler;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "User", description = "A user of a shopping cart")
public class UserDTO {

	@JsonIgnore
	@Autowired
	private ShoppingCartAssembler cartAssembler;

	@ApiModelProperty(value = "Id of the user", hidden = true, readOnly = true, required = false)
	private Long id;

	@ApiModelProperty(value = "Name of the user", required = true)
	@NotNull(message = "User must have a name")
	private String name;

	@ApiModelProperty(value = "Password for the user", required = true)
	@NotNull(message = "User must have a secret")
	private String password;
}
