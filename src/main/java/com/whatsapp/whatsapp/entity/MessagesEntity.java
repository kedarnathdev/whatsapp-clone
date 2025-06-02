package com.whatsapp.whatsapp.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "messages")
public class MessagesEntity {
	
	@Id
	@Column(name = "message_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer messageId;
	
	@Column(name= "user_id")
	private Integer userId;
	
	@Column(name = "message_value")
	private String messageValue;
	
	@Column(name = "message_date")
	private String messageDate;

	public Integer getMessageId() {
		return messageId;
	}

	public void setMessageId(Integer messageId) {
		this.messageId = messageId;
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
