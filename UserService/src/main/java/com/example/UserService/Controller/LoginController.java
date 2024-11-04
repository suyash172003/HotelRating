package com.example.UserService.Controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

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
import com.example.UserService.Model.Hotel.Hotel;
import com.example.UserService.Repository.LoginRepository;

import ch.qos.logback.classic.Logger;
import feign.Feign;

@RestController
public class LoginController {
	
	@Autowired
	LoginRepository loginRepo;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	FeignService fiegn;
	
	@PostMapping("/register")
	private ResponseEntity<String> storeUser(@RequestBody Login login){
		login.setUserId(UUID.randomUUID().toString());
		loginRepo.save(login); 
		return ResponseEntity.ok("User registered successfully");
	}
	
	@GetMapping("/register/{id}")
	private Optional<Login> getUser(@PathVariable String id){
		Login login=loginRepo.findById(id).get();
//		Rating[] array=restTemplate.getForObject("http://RATINGSERVICE/rating/userId/"+login.getUserId(), Rating[].class);
		List<Rating> data=fiegn.getByUserId(login.getUserId());
		List<Rating> list=data.stream().map(rating->{
		   Hotel hotelData=restTemplate.getForObject("http://HOTEL/hotel/"+rating.getHotelId(), Hotel.class);
		   rating.setHotel(hotelData);
		   return rating;
		}).collect(Collectors.toList());
		login.setRating((ArrayList<Rating>) list);
		return loginRepo.findById(id);
		
	}
	
	@GetMapping("/register")
	private Optional<List<Login>> getUser(){
		return Optional.of(loginRepo.findAll());
	}
}
