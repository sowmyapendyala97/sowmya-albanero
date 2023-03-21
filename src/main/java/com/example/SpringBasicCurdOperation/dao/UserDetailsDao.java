package com.example.SpringBasicCurdOperation.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.SpringBasicCurdOperation.entity.UserDetails;

public interface UserDetailsDao extends MongoRepository<UserDetails, String> {

	public UserDetails getByUserName(String username);
	
	public List<UserDetails> deleteByUserName(String userName);
}
