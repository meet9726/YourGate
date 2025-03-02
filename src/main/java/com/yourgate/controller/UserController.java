package com.yourgate.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yourgate.dto.UserDTO;
import com.yourgate.entity.Complaint;
import com.yourgate.entity.Roles;
import com.yourgate.entity.Society;
import com.yourgate.entity.User;
import com.yourgate.repository.ComplaintRepository;
import com.yourgate.repository.RoleRepository;
import com.yourgate.repository.SocietyRepository;
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
	
	@Autowired
	public ComplaintRepository comRepo;
	
	@Autowired
	public SocietyRepository scoRepo;
	
	@PostMapping("/users/register")
	public User createUser(@RequestBody UserDTO userDTO) {
		 // Fetch role based on roleId from DTO
        Roles role = roleRepo.findById(userDTO.getRoleId())
                .orElseThrow(() -> new RuntimeException("Role not found with ID: " + userDTO.getRoleId()));
       
        Society sco = scoRepo.findById(userDTO.getSociety())
        		 .orElseThrow(() -> new RuntimeException("Society not found with ID: " + userDTO.getRoleId()));
     
        if (userRepo.findByEmail(userDTO.getEmail()).isPresent()) {
        	throw new RuntimeException("Email Already Register");
        	
        }else {
        // Create User object and assign the role
        User user = new User();
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setPhone(userDTO.getPhone());
        user.setFlatNo(userDTO.getFlatNo());
        user.setBlock(userDTO.getBlock());
        user.setRole(role);
        user.setSociety(sco);
        user.setPassword(userDTO.getPassword());
        user.setStatus(userDTO.getStatus());
        return userRepo.save(user);
        }
	}
	
	
	@PostMapping("/login")
	public User loginUser(@RequestBody Map<String, String> loginData,User user) {		
		User token = userSvc.loginUser(loginData.get("email"), loginData.get("password"));
        return token;
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
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable("id") Long id){
		 User user = userRepo.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
		 
		userRepo.deleteById(id);
		return ResponseEntity.ok("User Id  "+ id  + "deleted successfully.");
	}
	
	

}
