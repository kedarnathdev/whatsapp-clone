package com.whatsapp.whatsapp.service;

import java.util.List;
import java.util.Objects;

import javax.management.RuntimeErrorException;

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
	
	public User loginUser(User user) throws Exception {
		User returnedUser =  userRepository.findByUserEmailAndUserPassword(user.getUserEmail(), user.getUserPassword());
		
		if (Objects.nonNull(returnedUser)) {
			return returnedUser;
		} else {
			throw new Exception("user not found");
		}
	}
	
	
}
