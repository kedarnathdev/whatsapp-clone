package com.whatsapp.whatsapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whatsapp.whatsapp.entity.Message;
import com.whatsapp.whatsapp.repository.MessagesRepository;

@Service
public class MessagesService {
	
	@Autowired
	private MessagesRepository messagesRepository;
	
	public List<Message> getAllMessages() {
		return messagesRepository.findAll();
	}
	
	public Message updateMessage(Message messageEntity) {
		return messagesRepository.save(messageEntity);
	}
	
	public List<Message> getMessagesByUserId(String userId) {
		return messagesRepository.findBySenderUserId(userId);
	}
	
}
