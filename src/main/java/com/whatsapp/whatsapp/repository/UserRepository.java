package com.whatsapp.whatsapp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.whatsapp.whatsapp.entity.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

	User findByUserEmailAndUserPassword(String userEmail, String userPassword);
	
	User findByUserId(String userId);
	
	User findByUserEmail(String userEmail);
	
}
