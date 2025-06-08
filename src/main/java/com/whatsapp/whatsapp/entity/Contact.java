package com.whatsapp.whatsapp.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "contacts")
public class Contact {
	
	@Id
	private String userId;
	
	private String lastMessage;
	
	private String userName;
	
	private String timeStamp;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getLastMessage() {
		return lastMessage;
	}

	public void setLastMessage(String lastMessage) {
		this.lastMessage = lastMessage;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	
	
}
