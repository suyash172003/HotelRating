package com.example.Hotel.Controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Hotel.Model.HotelModel;
import com.example.Hotel.Repository.HotelRepository;

@RestController
public class HotelController {
	
	@Autowired
	HotelRepository hotelRepo;
	
	@GetMapping("/hotel")
	public List<HotelModel> getHotels(){
		return hotelRepo.findAll();
	}
	
	@PostMapping("/hotel")
	public ResponseEntity<String> storeHotel(@RequestBody HotelModel hotel) {
		String hotelId=UUID.randomUUID().toString();
		hotel.setId(hotelId);
		hotelRepo.save(hotel);
		return ResponseEntity.ok("Successfully stored");
	}
	
	@GetMapping("/hotel/{hotelId}")
	public Optional<HotelModel> getHotelsById(@PathVariable String hotelId){
		return hotelRepo.findById(hotelId);
	}
}
