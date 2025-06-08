package com.whatsapp.whatsapp.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.whatsapp.whatsapp.entity.Message;

public interface MessagesRepository extends MongoRepository<Message, Integer> {

	List<Message> findBySenderUserId(String userId);

}
