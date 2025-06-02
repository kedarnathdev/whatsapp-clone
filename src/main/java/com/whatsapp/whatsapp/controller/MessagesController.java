package com.whatsapp.whatsapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.whatsapp.whatsapp.entity.MessagesEntity;
import com.whatsapp.whatsapp.repository.MessagesRepository;

@RestController
@RequestMapping("/")
public class MessagesController {
	
	@Autowired
	MessagesRepository messagesRepository;
	
	@GetMapping("/test")
	public String testMethod() {
		return "Heloooo";
	}
	
	@GetMapping("/get")
	public List<MessagesEntity> get() {
		return messagesRepository.findAll();
	}
	
	@PostMapping("/update")
	public MessagesEntity updateMessage(@RequestBody MessagesEntity messageEntity) {
		messagesRepository.save(messageEntity);
		return messageEntity;
		
	}

}
