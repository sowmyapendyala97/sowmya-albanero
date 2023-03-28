package com.example.SpringBasicCurdOperation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SpringBasicCurdOperation.dao.UserDetailsDao;
import com.example.SpringBasicCurdOperation.entity.UserDetails;

@Service
public class UserService {

	@Autowired
	private UserDetailsDao userDetailsDao;

	public String addUserData(UserDetails userDet) {
		String response = null;
		UserDetails a = userDetailsDao.save(userDet);
		if (a != null) {
			response = "User details save succesfully";
		} else {
			response = "Unable to add user details";
		}
		return response;

	}

	public List<UserDetails> deleteUserData(String userName) {
		List<UserDetails> response = null;
		UserDetails a = userDetailsDao.getByUserName(userName);
		if (a != null) {
			System.out.println("inside if" + userName);
			List<UserDetails> ulist = userDetailsDao.deleteByUserName(userName);
			return ulist;
		} else {
			return userDetailsDao.findAll();
		}
		// return response;

	}

	public List<UserDetails> getAllUsers() {
		return userDetailsDao.findAll();
	}

	public List<UserDetails> updateFullName(String uName) {
		if (uName != null && !(uName.equals(""))) {
			UserDetails udetails = userDetailsDao.getByUserName(uName);
			if (udetails != null) {
				udetails.setFullName(udetails.getFullName().replaceAll("[aeiou]", "?"));
				userDetailsDao.save(udetails);
				return userDetailsDao.findAll();
			}
		}
		return null;
	}
}
