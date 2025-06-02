package com.whatsapp.whatsapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whatsapp.whatsapp.entity.MessagesEntity;
import com.whatsapp.whatsapp.repository.MessagesRepository;

@Service
public class MessagesService {
	
	@Autowired
	private MessagesRepository messagesRepository;
	
	public List<MessagesEntity> getAllMessages() {
		return messagesRepository.findAll();
	}
	
	public MessagesEntity updateMessage(MessagesEntity messageEntity) {
		return messagesRepository.save(messageEntity);
	}
	
	public List<MessagesEntity> getMessagesByUserId(Integer userId) {
		return messagesRepository.findByUserId(userId);
	}
	
}
