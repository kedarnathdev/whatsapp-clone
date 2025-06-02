package com.whatsapp.whatsapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.whatsapp.whatsapp.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
	@Query(value="select user_id from user where user_Email=? and User_Password=?",nativeQuery = true)
	public Integer login(String email,String password);
}
