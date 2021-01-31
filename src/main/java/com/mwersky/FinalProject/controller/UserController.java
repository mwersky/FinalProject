package com.mwersky.FinalProject.controller;

import javax.naming.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mwersky.FinalProject.entity.Credentials;
import com.mwersky.FinalProject.entity.User;
import com.mwersky.FinalProject.service.UserService;



@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService authService;
	
	@RequestMapping(value="/register", method=RequestMethod.POST) //Create
	public ResponseEntity<Object> register(@RequestBody Credentials cred) {
		try {
			return new ResponseEntity<Object>(authService.register(cred), HttpStatus.CREATED);
		} catch (AuthenticationException e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST) //Authenticate
	public ResponseEntity<Object> login(@RequestBody Credentials cred) {
		try {
			return new ResponseEntity<Object>(authService.login(cred), HttpStatus.OK);
		} catch (AuthenticationException e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.UNAUTHORIZED);
		}
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<Object> getUsers() {
		return new ResponseEntity<Object>(authService.getAllUsers(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method=RequestMethod.GET)
	public ResponseEntity<Object> getUser(@PathVariable Long id) {
		try {
			return new ResponseEntity<Object>(authService.getUserById(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Object> updateUser(@RequestBody User user, @PathVariable Long id) {
		try {
			return new ResponseEntity<Object>(authService.updateUser(user, id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Object> deleteUser(@PathVariable Long id) {
		try {
			authService.deleteUser(id);
			return new ResponseEntity<Object>("Successfully deleted user with id: " + id, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

}