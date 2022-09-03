package com.lti.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_deatils")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;
	
	private String userName;
	
	private String fullName;
	
	private String password;
	
	private String gender;
	
	private String address;
	
	private String email;
	
	private String contactNo;
	
	private LocalDate dob;
	
	public User() {}
	
	public User(String userName, String fullName, String password, String gender, String address,
			String email, String contactNo, LocalDate dob) {
		this.userName = userName;
		this.fullName = fullName;
		this.password = password;
		this.gender = gender;
		this.address = address;
		this.email = email;
		this.contactNo = contactNo;
		this.dob = dob;
	}

	public User(int userId, String userName, String fullName, String password, String gender, String address,
			String email, String contactNo, LocalDate dob) {
		this.userId = userId;
		this.userName = userName;
		this.fullName = fullName;
		this.password = password;
		this.gender = gender;
		this.address = address;
		this.email = email;
		this.contactNo = contactNo;
		this.dob = dob;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", fullName=" + fullName + ", password=" + password
				+ ", gender=" + gender + ", address=" + address + ", email=" + email + ", contactNo=" + contactNo
				+ ", dob=" + dob + "]";
	}
	
}
