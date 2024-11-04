package com.example.UserService.Controller;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.UserService.Model.Rating;

@FeignClient(name="RATINGSERVICE")
public interface FeignService {
	@GetMapping("/rating/userId/{userId}")
	public List<Rating> getByUserId(@PathVariable String userId);
}
