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
	
//	public User findByEmail(String email) {
//		return userRepo.findByEmail(email);
//	}

	public User loginUser(String email, String password) {
		 User user = userRepo.findByEmail(email).orElseThrow(()-> new RuntimeException("Invalid Email"));
		 
		 if(!user.getEmail().equals(email)) {
			 throw new RuntimeException("Invalid email or password");
		 }
		
	        
	     if (!user.getPassword().equals(password)) {
	         throw new RuntimeException("Invalid email or password");
	     }
	     
	     if(user != null && user.getPassword().equals(user.getPassword())) {
				return user;
			}else {
				throw new RuntimeException("Invalid Login credentials");
			}
	}
}
