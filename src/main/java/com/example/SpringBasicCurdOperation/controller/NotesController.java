package com.example.SpringBasicCurdOperation.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringBasicCurdOperation.entity.Notes;
import com.example.SpringBasicCurdOperation.exception.NotesException;
import com.example.SpringBasicCurdOperation.service.NotesService;

@RestController
public class NotesController {

    Logger logger = LoggerFactory.getLogger(NotesController.class);

	@Autowired
	private NotesService notesService;

	@PostMapping("/createNote")
	public ResponseEntity<Notes> createANote(@RequestBody Notes notes) throws NotesException {
		logger.debug("Entered createNotes API");
		return notesService.createANote(notes);

	}

	@PutMapping("/updateNotes/{id}")
	public ResponseEntity<?> updateANote(@PathVariable(value = "id") String id, @RequestBody Notes notes) throws NotesException {
		logger.debug("Entered updateANote API");
		return notesService.updateANote(id, notes);

	}

	@GetMapping("/getAllNotes")
	public ResponseEntity<List<Notes>> getAllNotes() {
		logger.debug("Entered getAllNotes API");
		return notesService.getAllNotes();
	}
	
	@GetMapping("/getByID/{title}")
	public ResponseEntity<?> getByID(@PathVariable (value="title") String title) {
		logger.debug("Entered getByID API");
		return notesService.getByID(title);
	}


	@DeleteMapping("/deleteById/{id}")
	public ResponseEntity<?> deleteByID(@PathVariable(value = "id") String id) {
		logger.debug("Entered deleteNote API");
		return notesService.deleteNote(id);

	}
}
