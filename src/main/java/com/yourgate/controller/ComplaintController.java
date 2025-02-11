package com.yourgate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yourgate.entity.Complaint;
import com.yourgate.repository.ComplaintRepository;

@RestController
@RequestMapping("/api")
public class ComplaintController {
	
	
	@Autowired
	public ComplaintRepository comRepo;

	
	@PostMapping("/addComplaint")
	public Complaint addComplain(@RequestBody Complaint com) {
		
		return comRepo.save(com);
	}
}
