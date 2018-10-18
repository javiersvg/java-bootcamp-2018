package com.globant.bootcamp.controller;

import com.globant.bootcamp.assembler.UserAssembler;
import com.globant.bootcamp.domain.User;
import com.globant.bootcamp.model.UserDTO;
import com.globant.bootcamp.service.UserService;
import io.swagger.annotations.*;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/api/users")
@AllArgsConstructor(onConstructor = @__(@Autowired))
@Api
public class UserController {

	private final UserService userService;

	private final UserAssembler userAssembler;

	@PostMapping(value = "/new")
	@ApiOperation(value = "Create user with password", notes = "Creates a user with the given name and password")
	@ApiResponses({
			@ApiResponse(code = 201, message = "Created user sucessfully"),
			@ApiResponse(code = 409, message = "Conflict, user already exists")
	})
	public ResponseEntity<UserDTO> newUser(
			@ApiParam(required = true, name = "JSONRequest", value = "Json with the user model")
			@Valid @RequestBody UserDTO user) {
		log.info("Creating user {} with password {}", user.getName(), user.getPassword());
		ResponseEntity<UserDTO> responseEntity;
		if (userService.userAlreadyExists(userAssembler.toEntity(user))) {
			log.warn("User {} already exists", user.getName());
			responseEntity = new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		else {
			User createdUser = userService.createOrUpdate(userAssembler.toEntity(user));
			log.info("User created successfully");
			responseEntity = new ResponseEntity<>(userAssembler.toModel(createdUser), HttpStatus.CREATED);
		}
		return responseEntity;
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<UserDTO>> getAll() {
		List<UserDTO> storedUsers = userService.getAll()
				.stream()
				.map(userAssembler::toModel)
				.collect(Collectors.toList());
		return new ResponseEntity<>(storedUsers, HttpStatus.OK);
	}
}
