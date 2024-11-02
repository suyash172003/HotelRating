package com.example.UserService.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.UserService.Model.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login,String>{

}
