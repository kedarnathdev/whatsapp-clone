package com.whatsapp.whatsapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whatsapp.whatsapp.entity.UserEntity;
import com.whatsapp.whatsapp.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	public List<UserEntity> getAllUsers(){
		return userRepository.findAll();
	}
	
	public UserEntity getUserById(Integer userId) {
		return userRepository.findById(userId).get();
	}
	
	public UserEntity createUser(UserEntity userEntity) {
		return userRepository.save(userEntity);
	}
	
	public Integer login(String email,String password) {
		return userRepository.login(email, password);
	}
}
