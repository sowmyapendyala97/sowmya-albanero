package com.example.SpringBasicCurdOperation.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.SpringBasicCurdOperation.entity.Vowels;

public interface VowelsDetails extends MongoRepository<Vowels,String>{
	Vowels findByName(String category);
}
