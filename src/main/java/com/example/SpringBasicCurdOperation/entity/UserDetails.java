package com.example.SpringBasicCurdOperation.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("UserDetails")
public class UserDetails {

	@Id
	private String userName;
	private String fullName;
	private String email;
	private Address address;
	private String mobileNumber;
	private String currentOrganisation;

	// private String
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getCurrentOrganisation() {
		return currentOrganisation;
	}

	public void setCurrentOrganisation(String currentOrganisation) {
		this.currentOrganisation = currentOrganisation;
	}

}
