package com.whatsapp.whatsapp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.whatsapp.whatsapp.entity.User;

@Repository
public interface UserRepository extends MongoRepository<User, Integer> {

	User findByUserEmailAndUserPassword(String userEmail, String userPassword);
	
}
