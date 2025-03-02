package com.yourgate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yourgate.entity.Society;
import com.yourgate.entity.SocietyMain;
import com.yourgate.repository.SocietyMainRepository;
import com.yourgate.repository.SocietyRepository;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api")
public class SocietyMainController {

	@Autowired
	public SocietyMainRepository SocietyMnRepo;
	
	@Autowired
	public SocietyRepository SocietyRepo;
	
	@PostMapping("/addsociety")
	public SocietyMain addSociety(@RequestBody SocietyMain scMain) {
		return SocietyMnRepo.save(scMain);
	}
	
	@PostMapping("/regsociety")
	public Society regSociety(@RequestBody Society scMain) {
		return SocietyRepo.save(scMain);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteSocietyMn(@PathVariable("id") Long id) {
		SocietyMnRepo.findById(id).orElseThrow(()-> new RuntimeException("Existing user not found"));
		SocietyMnRepo.deleteById(id);
		return ResponseEntity.ok("successfully deleted");	
	}
	@GetMapping("/allSociety")
	public List<SocietyMain> getAllSocietyMain() {
		return SocietyMnRepo.findAll();
		
	}
	
	
}
