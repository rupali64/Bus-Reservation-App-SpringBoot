package com.lti.service;

import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.dao.UserDao;
import com.lti.entity.Booking;
import com.lti.entity.Bus;
import com.lti.entity.User;
import com.lti.exception.BusNotFoundException;
import com.lti.exception.RecordNotFoundException;
import com.lti.exception.UserNotFoundException;
@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserDao userdao;

	@Override
	public List<User> getUserDetails() {
		
		return userdao.findAll();
	}

	@Override
	@Transactional
	public User createUser(User newUser) {
		Optional<User> findUserById = userdao.findById(newUser.getUserId());
		    userdao.save(newUser);
			return newUser;
	
	}

	@Override
	@Transactional
	public User updateUser(User updateUser) {
		
		Optional<User> findUserById = userdao.findById(updateUser.getUserId());
		if (findUserById.isPresent()) {
			userdao.save(updateUser);
		} 
		return updateUser;
	}

	@Override
	@Transactional
	public String deleteUser(int userId) throws RecordNotFoundException {
		Optional<User> findBookingById = userdao.findById(userId);
		if (findBookingById.isPresent()) {
			userdao.deleteById(userId);
			return "User deleted successfully ";
		}
		
		
		else
			throw new RecordNotFoundException("User not found for the entered UserID");
	}
		
	

	@Override
	public Optional<User> findUserById(int userId) throws UserNotFoundException {
		
		Optional<User> user = userdao.findById(userId);
		if(user == null) {
			throw new UserNotFoundException("User Id: " + userId + "");
		}
	return user;
		
		
	}
	
	@Override
	public User findByUserName(String userName) throws UserNotFoundException {
		
		Optional<User> user= userdao.findByUserName(userName);
		if(!user.isPresent()) {
			throw new UserNotFoundException("User name: " + userName + "");
		}
		return user.get();
	}

}
