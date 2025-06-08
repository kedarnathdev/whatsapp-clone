package com.whatsapp.whatsapp.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.whatsapp.whatsapp.dto.Message;

@Document(collection = "chats")
public class Chat {

	@Id
	private String chatId;

	private List<Message> messages;

	public String getChatId() {
		return chatId;
	}

	public void setChatId(String chatId) {
		this.chatId = chatId;
	}

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

}
