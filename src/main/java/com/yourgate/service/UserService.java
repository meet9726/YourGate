package com.yourgate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yourgate.dto.UserDTO;
import com.yourgate.entity.User;
import com.yourgate.repository.UserRepository;

@Service
public class UserService {

	
	@Autowired
	public UserRepository userRepo;
	
	
	
	public User saveUser(User user) {
		return userRepo.save(user);
	}
	
	public User findByEmail(String email) {
		return userRepo.findByEmail(email);
	}
}
