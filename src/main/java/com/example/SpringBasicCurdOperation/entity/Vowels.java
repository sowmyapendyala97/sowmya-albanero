package com.example.SpringBasicCurdOperation.entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("Vowels")
public class Vowels {

	private String name;
	private int countOfVowels;
	private int countOfSplCharacters;
	public int getCountOfSplCharacters() {
		return countOfSplCharacters;
	}
	public void setCountOfSplCharacters(int countOfSplCharacters) {
		this.countOfSplCharacters = countOfSplCharacters;
	}
	public int getCountOfVowels() {
		return countOfVowels;
	}
	public void setCountOfVowels(int countOfVowels) {
		this.countOfVowels = countOfVowels;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
