package com.example.SpringBasicCurdOperation.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.SpringBasicCurdOperation.dao.NotesDao;
import com.example.SpringBasicCurdOperation.entity.Notes;
import com.example.SpringBasicCurdOperation.exception.NotesException;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;

@Service
public class NotesService {

	@Autowired
	private NotesDao notesDao;

	MongoTemplate mongoTemplate;

	private HttpStatus httpStatus;

	public ResponseEntity<Notes> createANote(Notes notes) throws NotesException {

		notes.setCreatedDate(new Date().toString());
		Notes createdNotes = notesDao.save(notes);
		return new ResponseEntity<>(createdNotes, httpStatus.CREATED);

	}

	public ResponseEntity<?> updateANote(String id, Notes notes) throws NotesException {

		Notes retriveNotes = notesDao.findById(id).orElse(null);
		if (retriveNotes == null) {
			return new ResponseEntity<>("Unable to find the Notes with ID= "+id, httpStatus.NOT_FOUND);
		}
		retriveNotes.setTitle(notes.getTitle());
		retriveNotes.setText(notes.getText());
		retriveNotes.setUpdatedDate(new Date().toString());
		Notes updatedNotes = notesDao.save(retriveNotes);
		return new ResponseEntity<>(updatedNotes, httpStatus.OK);

	}

	@Deprecated
	private String getResourceName(Notes notes) {
		String resourceName = null;
		if (notes.getTitle() != null) {
			// notes.getTitle().c
		}
		return null;

	}

	private boolean validateNotes(Notes notes) {
		if (notes != null && (notes.getTitle() != null || notes.getText() != null)) {
			return true;
		} else {
			return false;
		}

	}

	public ResponseEntity<List<Notes>> getAllNotes() {
		// TODO Auto-generated method stub
		List<Notes> listOfNotes = notesDao.findAll();
		return new ResponseEntity<List<Notes>>(listOfNotes, httpStatus.OK);
	}

	public ResponseEntity<?> deleteNote(String id) {

		Notes retriveNotes = notesDao.findById(id).orElse(null);
		if (retriveNotes == null) {
			return new ResponseEntity<>("Unable to find the Notes with ID= "+id, httpStatus.NOT_FOUND);
		}
		notesDao.deleteById(id);

		return new ResponseEntity<>("Notes deleted successfully", HttpStatus.OK);

	}

	@ExceptionHandler(value = InvalidFormatException.class)
	public ResponseEntity<?> handleInvalidFormatException(InvalidFormatException e) {
		return new ResponseEntity<>("Invalid format: " + e.getMessage(), HttpStatus.BAD_REQUEST);
	}

	// Exception handling for other exceptions
	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<?> handleException(Exception e) {
		return new ResponseEntity<>("An error occurred: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	public ResponseEntity<?> getByID(String title) {
		Notes retriveNotes = notesDao.findById(title).orElse(null);
		if (retriveNotes == null) {
			return new ResponseEntity<>("Unable to find the Notes with title= "+ title, httpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(retriveNotes, HttpStatus.OK);
	}
}
