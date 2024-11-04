package com.example.UserService.Model;

import com.example.UserService.Model.Hotel.Hotel;

import lombok.Data;

@Data
public class Rating {
	
	private String ratingId;
	private String userId;
	private String hotelId;
	private int rating;
	private String feedback;
	private Hotel hotel;

}
