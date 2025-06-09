package com.whatsapp.whatsapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.whatsapp.whatsapp.dto.Message;
import com.whatsapp.whatsapp.entity.Chat;
import com.whatsapp.whatsapp.service.ChatService;

@RestController
@CrossOrigin("*")
public class ChatRestController {

	@Autowired
	private ChatService chatService;

	@PostMapping("/chat/getAllMessages")
	public List<Message> getAllMessages(@RequestBody Chat chat) {
		return chatService.getAllMessages(chat);
	}

}
