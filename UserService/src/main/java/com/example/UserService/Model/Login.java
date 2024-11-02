package com.example.UserService.Model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Login {
  @Id
  @Column(name="ID")
  private String userId;
  
  @Column(name="NAME")
  private String name;
  
  @Column(name="EMAIL")
  private String email;
  
  @Column(name="ABOUT")
  private String about;
  
  @Transient
  private ArrayList<Rating> rating=new ArrayList<Rating>();
}
