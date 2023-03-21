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

import com.example.SpringBasicCurdOperation.entity.UserDetails;
import com.example.SpringBasicCurdOperation.entity.Vowels;
import com.example.SpringBasicCurdOperation.service.UserService;
import com.example.SpringBasicCurdOperation.service.VowelsService;

@RestController
public class UserDetailsController {

	@Autowired
	private VowelsService vowelsService;
	
	@Autowired
	private UserService userService;
	
	
	@GetMapping("/getVowelAndSplCharacter/{name}")
	public Vowels getCountOfVowelsInString(@PathVariable ("name") String name) {
		return vowelsService.getCountOfVowelsInString(name);
		
	}
	
	@GetMapping("/getAllUsers")
	public List<UserDetails> getAllUsers() {
		return userService.getAllUsers();
		
	}
	
	@PutMapping("/updateFullNameBasedOnUserName/{userName}")
	public  List<UserDetails> updateFullName(@PathVariable ("userName") String uName) {
		return userService.updateFullName(uName);
	}
	
	@PostMapping("/addUserDetails")
	public String addUserData(@RequestBody UserDetails userDet) {
		return userService.addUserData(userDet);
		
	}
	
	@DeleteMapping("/deleteByUserName/{uName}")
	public List<UserDetails> deleteUserData(@PathVariable ("uName") String userName) {
		System.out.println(userName);
	return userService.deleteUserData(userName);
		
	}
	
}
