package com.example.RatingService.Controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.RatingService.Model.RatingModel;
import com.example.RatingService.Repository.RatingRepository;

@RestController
public class RatingController {
	
	@Autowired
	RatingRepository ratingRepo;
	
	@PostMapping("/rating")
	public ResponseEntity<String> storeRating(@RequestBody RatingModel rating){
		rating.setRatingId(UUID.randomUUID().toString());
		ratingRepo.save(rating);
		return ResponseEntity.ok("Successfully stored");
	}
	
	@GetMapping("/rating")
	public List<RatingModel> getRating(){
		return ratingRepo.findAll();
	}
	
	@GetMapping("/rating/userId/{userId}")
	public List<RatingModel> getByUserId(@PathVariable String userId){
		return ratingRepo.findByUserId(userId);
	}
	
	@GetMapping("/rating/hotelId/{hotelId}")
	public List<RatingModel> getByHotelId(@PathVariable String hotelId){
		return ratingRepo.findByHotelId(hotelId);
	}
	
}
