package com.whatsapp.whatsapp.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.whatsapp.whatsapp.entity.MessagesEntity;

public interface MessagesRepository extends JpaRepository<MessagesEntity, Integer> {

}
