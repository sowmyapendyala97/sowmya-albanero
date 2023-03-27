package com.example.SpringBasicCurdOperation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	
	@Autowired
	private NotesService notesService;
	
	
	@PostMapping("/createNote")
	public List<Notes> createANote(@RequestBody Notes notes) throws NotesException{
		return notesService.createANote(notes);
		
	}
	
	@PutMapping("/updateNotes/{id}")
	public List<Notes> updateANote(@PathVariable (value="id") String id , @RequestBody Notes notes){
		return notesService.updateANote(id, notes);
		
	}
	
	
	@GetMapping("/getAllNotes")
	public List<Notes> getAllNotes(){
		return notesService.getAllNotes();
	}

	
	@DeleteMapping("/deleteById/{id}")
	public List<Notes> deleteByID(@PathVariable (value="id") String id){
		return notesService.deleteNote(id);
		
	}
}
