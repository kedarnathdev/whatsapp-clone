package com.whatsapp.whatsapp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.whatsapp.whatsapp.entity.Chat;

public interface ChatRepository extends MongoRepository<Chat, String> {
	
	Chat findByChatId(String chatId);

}
