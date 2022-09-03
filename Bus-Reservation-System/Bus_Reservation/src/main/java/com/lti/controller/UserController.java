package com.lti.controller;

import java.math.BigInteger;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.entity.User;
import com.lti.exception.RecordAlreadyPresentException;
import com.lti.exception.RecordNotFoundException;
import com.lti.exception.UserNotFoundException;
import com.lti.service.UserService;



@ComponentScan(basePackages = "com.lti")
@RestController
@RequestMapping("/busapp")
@CrossOrigin("http://localhost:4200")
public class UserController {
	
	@Autowired
	UserService userService;

	@PostMapping("/users")
	public User addUser(@RequestBody User newUser) {

		return userService.createUser(newUser);
	}

	@GetMapping("/readAllUsers")
	public Iterable<User> readAllUsers() {

		return userService.getUserDetails();
	}

	@PutMapping("/updateUser")
	public User updateUser(@RequestBody User updateUser) throws RecordNotFoundException {

		return userService.updateUser(updateUser);
	}



	@DeleteMapping("/deleteUser/{id}")
	public String deleteBookingByID(@PathVariable("id") Integer userId) throws RecordNotFoundException {

		return "Deleted";
	}
	
	@GetMapping("/searchUser/{name}")
	public User searchUserByID(@PathVariable("name") String userName) throws UserNotFoundException {

		return userService.findByUserName(userName);
	}
}
