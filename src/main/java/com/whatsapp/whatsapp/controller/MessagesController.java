package com.whatsapp.whatsapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.whatsapp.whatsapp.entity.Message;
import com.whatsapp.whatsapp.service.MessagesService;

@RestController
@RequestMapping("/")
public class MessagesController {

	@Autowired
	MessagesService messagesService;

	@GetMapping("/test")
	public String testMethod() {
		return "Heloooo";
	}

	@GetMapping("/getAllMessages")
	public List<Message> getAllMessages() {
		return messagesService.getAllMessages();
	}

	@PostMapping("/updateMessage")
	public Message updateMessage(@RequestBody Message messageEntity) {
		return messagesService.updateMessage(messageEntity);
	}
	
	@GetMapping("/getMessagesByUserId/{userId}")
	public List<Message> getMessagesByUserId(@PathVariable String userId) {
		return messagesService.getMessagesByUserId(userId);
	}

}
