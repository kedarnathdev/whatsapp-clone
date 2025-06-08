package com.whatsapp.whatsapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whatsapp.whatsapp.repository.ChatRepository;

@Service
public class ChatService {
	
	@Autowired
	ChatRepository chatRepository;
	

}
