package com.mwersky.FinalProject.service;

import javax.naming.AuthenticationException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.mwersky.FinalProject.entity.Credentials;
import com.mwersky.FinalProject.entity.User;
import com.mwersky.FinalProject.repository.UserRepository;

@Service
public class AuthService {
	
	private static final Logger logger = LogManager.getLogger(AuthService.class);
	
	@Autowired
	private UserRepository userRepository;
	
	//CREATE
	public User register(Credentials cred) throws AuthenticationException {
		
		User user = new User();
		user.setUsername(cred.getUsername());
		user.setEmail(cred.getEmail());
		user.setHash((BCrypt.hashpw(cred.getPassword(), BCrypt.gensalt())));
		try {
			
			userRepository.save(user);
			return user;
		} catch (DataIntegrityViolationException e) {
			throw new AuthenticationException("Username not available");
		}
	}
	//NOT SURE
	public User login(Credentials cred) throws AuthenticationException {
		User foundUser = userRepository.findByUsername(cred.getUsername());
		if (foundUser != null && BCrypt.checkpw(cred.getPassword(), foundUser.getHash())) {
			return foundUser;
		}
		throw new AuthenticationException("Incorrect username or password");
	}
	
	
	
	
	//READ ALL
	public Iterable<User> getAllUsers() {
		return userRepository.findAll();
	}
	
	//READ
	public User getUserById(Long id) throws Exception {
		try {
			return userRepository.findOne(id);
		} catch (Exception e) {
			logger.error("Exception occurred while trying to retrieve customer: " + id, e);
			throw e;
		}
	}
	
	//UPDATE
	public User updateUser(User user, Long id) throws Exception {
		try {
			User oldUser = userRepository.findOne(id);
			oldUser.setUsername(user.getUsername());
			oldUser.setEmail(user.getEmail());
//			oldUser.setDecks(user.getDecks());
			return userRepository.save(oldUser);
		} catch (Exception e) {
			logger.error("Exception occurred while trying to update User: " + id, e);
			throw new Exception("Unable to update customer");
		}
	}
	//DELETE
	public void deleteUser(Long id) throws Exception {
		try {
			userRepository.delete(id);
		} catch (Exception e) {
			logger.error("Exception occurred when trying to delete customer: " + id, e);
		}
	}
	
	
}