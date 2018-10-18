package com.globant.bootcamp.repository;

import com.globant.bootcamp.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	boolean existsByName(String name);
}
