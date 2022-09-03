package com.lti.service;

import java.util.List;
import java.util.Optional;

import com.lti.entity.User;
import com.lti.exception.RecordNotFoundException;
import com.lti.exception.UserNotFoundException;

public interface UserService {
	
	List<User> getUserDetails();
	
	User createUser(User newUser);
	User updateUser(User newUser);
	String deleteUser(int userId) throws RecordNotFoundException;
	Optional<User> findUserById(int userId) throws UserNotFoundException;
	User findByUserName(String userName) throws UserNotFoundException;
	

}
