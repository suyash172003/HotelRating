package com.example.UserService.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.UserService.UserServiceApplication;
import com.example.UserService.Model.Login;
import com.example.UserService.Model.Rating;
import com.example.UserService.Repository.LoginRepository;

import ch.qos.logback.classic.Logger;

@RestController
public class LoginController {
	
	@Autowired
	LoginRepository loginRepo;
	
	@Autowired
	RestTemplate restTemplate;
	
	@PostMapping("/register")
	private ResponseEntity<String> storeUser(@RequestBody Login login){
		login.setUserId(UUID.randomUUID().toString());
		loginRepo.save(login); 
		return ResponseEntity.ok("User registered successfully");
	}
	
	@GetMapping("/register/{id}")
	private Optional<Login> getUser(@PathVariable String id){
		Login login=loginRepo.findById(id).get();
		ArrayList<Rating> data=restTemplate.getForObject("http://localhost:8083/rating/userId/c0677428-5558-4fe3-b10a-405b18def886", ArrayList.class);
		login.setRating(data);
		return loginRepo.findById(id);
	}
	
	@GetMapping("/register")
	private Optional<List<Login>> getUser(){
		return Optional.of(loginRepo.findAll());
	}
}
