package com.mwersky.FinalProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mwersky.FinalProject.entity.Card;
import com.mwersky.FinalProject.service.CardService;


@RestController
@RequestMapping("/cards")
public class CardController {
	
	@Autowired
	private CardService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Object> getCard(@PathVariable Long id) {
		try {
			return new ResponseEntity<Object>(service.getCardById(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<Object> getCards() {
		return new ResponseEntity<Object>(service.getCards(), HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Object> createCard(@RequestBody Card card) {
		return new ResponseEntity<Object>(service.createCard(card), HttpStatus.CREATED);
	}

	@RequestMapping(value="/{id}", method=RequestMethod.PUT) 
	public ResponseEntity<Object> updateCard(@RequestBody Card card, @PathVariable Long id) {
		try {
			return new ResponseEntity<Object>(service.updateCard(card, id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Object> deleteCard(@PathVariable Long id) {
		try {
			service.deleteCard(id);
			return new ResponseEntity<Object>("Successfully deleted card with id: " + id, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
}
