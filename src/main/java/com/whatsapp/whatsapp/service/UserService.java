package com.whatsapp.whatsapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whatsapp.whatsapp.entity.User;
import com.whatsapp.whatsapp.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	public User getUserById(Integer userId) {
		return userRepository.findById(userId).get();
	}
	
	public User createUser(User userEntity) {
		return userRepository.save(userEntity);
	}
	
	public User userLogin(String userEmail,String userPassword) {
		return userRepository.findByUserEmailAndUserPassword(userEmail, userPassword);
	}
}
