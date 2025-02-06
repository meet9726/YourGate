package com.yourgate.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yourgate.entity.User;
import com.yourgate.repository.UserRepository;
import com.yourgate.service.UserService;

@RestController
@RequestMapping("/api")		
public class UserController {

	
	
	@Autowired
	public UserService userSvc;
	
	@Autowired
	public UserRepository userRepo;
	
	
	@PostMapping("/signup")
	public User saveUser(@RequestBody User user) {
		return userSvc.saveUser(user);
	}
	
	
	@PostMapping("/login")
	public User loginUser(@RequestBody User user) {
		User existingUser = userSvc.findByEmail(user.getEmail());
		System.out.println("Meet1111");
		if(existingUser != null && user.getPassword().equals(existingUser.getPassword())) {
			return existingUser;
		}else {
			throw new RuntimeException("Invalid Login credentials");
		}
	}
	
	
	@GetMapping("/getuser/{id}")
	public User getUserProfile(@PathVariable("id") Long id) {
		return userRepo.findById(id).orElseThrow(() -> new RuntimeException("Admin not found with ID: " + id));
	}
}
