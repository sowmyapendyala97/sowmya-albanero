package com.example.SpringBasicCurdOperation.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.SpringBasicCurdOperation.entity.Notes;

public interface NotesDao extends MongoRepository<Notes, String> {

	public List<Notes> getByTitleAndText(String title, String text);

}
