package com.example.Hotel.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Data
public class HotelModel {
	@Id
	private String id;
	private String name;
	private String location;
	private String about;

}
