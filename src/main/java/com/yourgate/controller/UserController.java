package com.yourgate.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yourgate.dto.UserDTO;
import com.yourgate.entity.Roles;
import com.yourgate.entity.User;
import com.yourgate.repository.RoleRepository;
import com.yourgate.repository.UserRepository;
import com.yourgate.service.UserService;

@RestController
@RequestMapping("/api")		
public class UserController {

	//for commit
	
	@Autowired
	public UserService userSvc;
	
	@Autowired
	public UserRepository userRepo;
	
	@Autowired
	public RoleRepository roleRepo;
	
	
	@PostMapping("/signup")
	public User saveUser(@RequestBody UserDTO userDTO) {
		 // Fetch role based on roleId from DTO
        Roles role = roleRepo.findById(userDTO.getRoleId())
                .orElseThrow(() -> new RuntimeException("Role not found with ID: " + userDTO.getRoleId()));
       
        // Create User object and assign the role
        User user = new User();
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setRole(role);

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
		return userRepo.findById(id).orElseThrow(() -> new RuntimeException("User not found with ID: " + id));
	}
	
	@PutMapping("/updateUser/{id}")
	public User updateUser(@PathVariable("id") Long id, @RequestBody User user) {
		User existingUser = userRepo.findById(id).orElseThrow(()-> new RuntimeException("Existing user not found"+ user.getName()));
		
		
		existingUser.setName(user.getName());
		existingUser.setEmail(user.getEmail());
		
		return userSvc.saveUser(existingUser);
		
	}
	
	

}
