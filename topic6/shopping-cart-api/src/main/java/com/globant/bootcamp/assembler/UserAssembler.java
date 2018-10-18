package com.globant.bootcamp.assembler;

import com.globant.bootcamp.domain.User;
import com.globant.bootcamp.model.UserDTO;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.stream.Collectors;

@Component
public class UserAssembler implements Assembler<UserDTO, User> {

	@Override
	public User toEntity(UserDTO user) {
		return User.builder().id(user.getId()).name(user.getName()).password(user.getPassword()).build();
	}

	@Override
	public UserDTO toModel(User user) {
		return UserDTO.builder().id(user.getId()).name(user.getName()).password(user.getPassword()).build();
	}

	@Override
	public Collection<User> toEntityList(Collection<UserDTO> dtos) {
		return dtos.stream().map(this::toEntity).collect(Collectors.toList());
	}

	@Override
	public Collection<UserDTO> toModelList(Collection<User> entities) {
		return entities.stream().map(this::toModel).collect(Collectors.toList());
	}
}
