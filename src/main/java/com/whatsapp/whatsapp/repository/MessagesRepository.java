package com.whatsapp.whatsapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.whatsapp.whatsapp.entity.MessagesEntity;

public interface MessagesRepository extends JpaRepository<MessagesEntity, Integer> {

	List<MessagesEntity> findByUserId(Integer userId);

}
