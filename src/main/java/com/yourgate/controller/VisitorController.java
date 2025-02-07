package com.yourgate.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yourgate.entity.Visitor;
import com.yourgate.repository.VisitorRepository;
import com.yourgate.service.VisitorService;

@RestController
@RequestMapping("/api/visitors")
public class VisitorController {

	
	@Autowired
	public VisitorRepository visitorRepo;
	
	@Autowired
	public VisitorService visitorSvc;
	
	
	@PostMapping
	public Visitor addVisitor(@RequestBody Visitor visitor) {
		return visitorRepo.save(visitor);
	}
	
	
	@GetMapping
	public List<Visitor> getVisitor() {
		return  visitorRepo.findAll();
	}
	
	
	@PutMapping("/{id}/checkout")
	public Visitor ischeckout(@PathVariable("id") Long id,@RequestBody Visitor visitor) {
		Visitor existingVisitor = visitorRepo.findById(id).orElseThrow(()-> new RuntimeException("Visitor not found"));
//		LocalDateTime dateTime = LocalDateTime.now();
		
		String dateTime = java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(java.time.LocalDateTime.now());
		existingVisitor.setCheckout(dateTime);
		
		return visitorRepo.save(existingVisitor);
	}
	
	
}
