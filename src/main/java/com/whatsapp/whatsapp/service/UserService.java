package com.whatsapp.whatsapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whatsapp.whatsapp.dto.Contact;
import com.whatsapp.whatsapp.entity.User;
import com.whatsapp.whatsapp.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	public User getUserById(String userId) {
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
	
	public List<Contact> getContacts(User user) throws Exception {
		User returnedUser = userRepository.findByUserId(user.getUserId());
		if (Objects.nonNull(returnedUser)) {
			List<String> userContacts = Objects.nonNull(returnedUser.getUserContacts()) ? returnedUser.getUserContacts(): new ArrayList<String>();
			List<Contact> contactsList = new ArrayList<Contact>();
			for (String str: userContacts) {
				Contact contact = new Contact();
				User contactUser = userRepository.findByUserId(str);
				contact.setUserName(contactUser.getUserName());
				contact.setUserId(contactUser.getUserId());
				contactsList.add(contact);
			}
			return contactsList;
			
		} else {
			throw new Exception("user not found");
		}
	}
	
	
	public User saveContact(User user) throws Exception {
		
		User contact = userRepository.findByUserEmail(user.getUserEmail());
		User mainUser = userRepository.findByUserId(user.getUserId());
		
		if (Objects.nonNull(contact)) {
			List<String> userContacts = Objects.nonNull(mainUser.getUserContacts()) ? mainUser.getUserContacts(): new ArrayList<String>();
			if (userContacts.contains(contact.getUserId())) {
				throw new Exception("contact already saved");
			} else {
				userContacts.add(contact.getUserId());
				mainUser.setUserContacts(userContacts);
				return userRepository.save(mainUser);
			}
			
		}
		
		throw new Exception("entered email address not found");
	}
	
	
}
