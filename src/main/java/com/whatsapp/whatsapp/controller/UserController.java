package com.whatsapp.whatsapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.whatsapp.whatsapp.entity.UserEntity;
import com.whatsapp.whatsapp.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService service;
	
	@GetMapping("/getAll")
	public List<UserEntity> getAllUsers(){
		return service.getAllUsers();
	}
	
	@GetMapping("/getAll/{id}")
	public UserEntity getUserById(@PathVariable Integer id){
		return service.getUserById(id);
	}
	
	@PostMapping("/createuser")
	public UserEntity createUser(@RequestBody UserEntity userEntity) {
		return service.createUser(userEntity);
	}
	
	@GetMapping("/login/{email}/{password}")
	public UserEntity login(@PathVariable String email, @PathVariable String password) {
		return service.userLogin(email, password);
	}
}
