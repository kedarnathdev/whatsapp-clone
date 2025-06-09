package com.whatsapp.whatsapp.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.whatsapp.whatsapp.dto.Message;
import com.whatsapp.whatsapp.service.ChatService;

@Controller
@CrossOrigin("*")
public class ChatController {

	@Autowired
	private ChatService chatService;

	@Autowired
	private SimpMessagingTemplate messagingTemplate;

	
	 // Receiver for /app/chat
    @MessageMapping("/chat")
	public void processMessage(@Payload Message message) {

		message.setTimeStamp(LocalDateTime.now().toString());
		message.setMessageStatus("SENT");
		
		List<Message> chatMessageslist = chatService.saveMessage(message);
		
		// Push to receiver
        messagingTemplate.convertAndSend("/topic/messages/" + message.getReceiverId(), message);

	}

}
