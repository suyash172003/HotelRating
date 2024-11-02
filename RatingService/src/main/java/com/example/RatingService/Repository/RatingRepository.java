package com.example.RatingService.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.RatingService.Model.RatingModel;

@Repository
public interface RatingRepository extends JpaRepository<RatingModel, String>{

	List<RatingModel> findByUserId(String userId);

	List<RatingModel> findByHotelId(String hotelId);

}
