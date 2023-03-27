package com.example.SpringBasicCurdOperation.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.CriteriaDefinition;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.SpringBasicCurdOperation.dao.NotesDao;
import com.example.SpringBasicCurdOperation.entity.Notes;
import com.example.SpringBasicCurdOperation.exception.NotesException;

@Service
public class NotesService {
	
	@Autowired
	private NotesDao notesDao;
	
	
	MongoTemplate mongoTemplate;
	
	public List<Notes> createANote(Notes notes) throws NotesException{
		List<Notes> noteList=null;
		if(validateNotes(notes)) {
			
			 notes.setCreatedDate(new Date().toString());
		//	 notes.setName(getResourceName(notes));
			 notesDao.save(notes);
			 noteList=notesDao.findAll();
		}
		else {
			noteList=	notesDao.findAll();
		}
		return noteList;
		
	}
	
	
	public List<Notes> updateANote(String id,  Notes notes){
		
		/*
		 * if(validateNotes(notes)) { Query query=new Query(); if(notes.getTitle() !=
		 * null && notes.getTitle() !=null) {
		 * query.addCriteria(Criteria.where("title").orOperator(Criteria.where("text")))
		 * ; }else if(notes.getName() != null){
		 * query.addCriteria(Criteria.where("title")); }else if (notes.getTitle() !=
		 * null) { query.addCriteria(Criteria.where("text")); } List<Notes>list=
		 * mongoTemplate.find(query, Notes.class);
		 * 
		 * 
		 * } return null;
		 */
		
		if(id != null) {
			Optional<Notes> noteOptional=notesDao.findById(id);
			
			if(noteOptional.isPresent()) {
				Notes n =noteOptional.get();
				n.setTitle(notes.getTitle());
				n.setText(notes.getText());
				n.setUpdatedDate(new Date().toString());
				notesDao.save(n);
			}
		}
	return	notesDao.findAll();
		
	}

	@Deprecated
	private String getResourceName(Notes notes) {
		String resourceName=null;
		if(notes.getTitle() != null) {
			//notes.getTitle().c
		}
		return null;
		
		
	}

	private boolean validateNotes(Notes notes) {
	if(notes != null && (notes.getTitle()!=null || notes.getText() != null) ) {
		return true;
	}else {
		return false;
	}

	}


	public List<Notes> getAllNotes() {
		// TODO Auto-generated method stub
		return notesDao.findAll();
	}
	
	
	public List<Notes> deleteNote(String id){
		
	if(id != null) {
		notesDao.deleteById(id);
	}
		
		return	notesDao.findAll();
				
				
	}
}
