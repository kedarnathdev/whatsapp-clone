package com.whatsapp.whatsapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.whatsapp.whatsapp.entity.Contact;
import com.whatsapp.whatsapp.entity.User;
import com.whatsapp.whatsapp.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService service;
	
	@GetMapping("/getAll")
	public List<User> getAllUsers(){
		return service.getAllUsers();
	}
	
	@GetMapping("/getAll/{id}")
	public User getUserById(@PathVariable Integer id){
		return service.getUserById(id);
	}
	
	@PostMapping("/createuser")
	public User createUser(@RequestBody User userEntity) {
		return service.createUser(userEntity);
	}
	
	@GetMapping("/login/{email}/{password}")
	public User login(@PathVariable String email, @PathVariable String password) {
		return service.userLogin(email, password);
	}
	
	@PostMapping("/contacts")
	public List<Contact> getContacts(@RequestBody User userEntity) {
		return new ArrayList<Contact>();
	}
	
}
