package com.whatsapp.whatsapp.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "messages")
public class Message {

	@Id
	private String messageId;

	private String senderUserId;

	private String receiverUserId;

	private String messageValue;

	private String messageDate;

	public String getMessageId() {
		return messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	public String getSenderUserId() {
		return senderUserId;
	}

	public void setSenderUserId(String senderUserId) {
		this.senderUserId = senderUserId;
	}

	public String getReceiverUserId() {
		return receiverUserId;
	}

	public void setReceiverUserId(String receiverUserId) {
		this.receiverUserId = receiverUserId;
	}

	public String getMessageValue() {
		return messageValue;
	}

	public void setMessageValue(String messageValue) {
		this.messageValue = messageValue;
	}

	public String getMessageDate() {
		return messageDate;
	}

	public void setMessageDate(String messageDate) {
		this.messageDate = messageDate;
	}

}
