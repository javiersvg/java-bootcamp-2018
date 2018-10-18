package com.globant.bootcamp.service;

import com.globant.bootcamp.domain.User;
import com.globant.bootcamp.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;

	@Override
	public User createOrUpdate(User user) {
		User storedUser = userRepository.save(user);
		userRepository.flush();
		return storedUser;
	}

	@Override
	public boolean userAlreadyExists(User user) {
		Long userId = user.getId();
		String name = user.getName();
		return (user.getId() != null && userRepository.existsById(userId)) || userRepository.existsByName(name);
	}

	@Override
	public User get(Long id) {
		return userRepository.findById(id).orElse(null);
	}

	@Override
	public void remove(Long id) {
		userRepository.deleteById(id);
	}

	@Override
	public List<User> getAll() {
		return userRepository.findAll();
	}
}
