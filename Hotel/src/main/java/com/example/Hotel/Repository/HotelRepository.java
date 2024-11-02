package com.example.Hotel.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Hotel.Model.HotelModel;

@Repository
public interface HotelRepository extends JpaRepository<HotelModel, String>{

}
