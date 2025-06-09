package com.whatsapp.whatsapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whatsapp.whatsapp.dto.Message;
import com.whatsapp.whatsapp.entity.Chat;
import com.whatsapp.whatsapp.repository.ChatRepository;

@Service
public class ChatService {

	@Autowired
	ChatRepository chatRepository;

	public Chat saveChat(Chat chat) {
		return chatRepository.save(chat);
	}
	
	public List<Message> saveMessage(Message message) {
		
		Chat chat = chatRepository.findByChatId(message.getChatId());
		List<Message> chatMessagesList = Optional.ofNullable(chat)
				.map(Chat::getMessages).filter(CollectionUtils::isNotEmpty)
				.orElse(new ArrayList<>());
		chatMessagesList.add(message);
		Chat nonNullChat = Optional.ofNullable(chat).orElse(new Chat());
		nonNullChat.setChatId(message.getChatId());
		nonNullChat.setMessages(chatMessagesList);
		chatRepository.save(nonNullChat);
		return chatMessagesList;
		
	}
	
	public List<Message> getAllMessages(Chat chat) {
		Chat retrievedChat = chatRepository.findByChatId(chat.getChatId());
		List<Message> chatMessagesList = Optional.ofNullable(retrievedChat)
				.map(Chat::getMessages).filter(CollectionUtils::isNotEmpty)
				.orElse(new ArrayList<>());
		return chatMessagesList;
	}

}
