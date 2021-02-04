package com.mwersky.FinalProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mwersky.FinalProject.entity.Deck;
import com.mwersky.FinalProject.service.DeckService;

@RestController
@RequestMapping("/users/{userId}/decks")
public class DeckController {
	
	@Autowired
	private DeckService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<Object> getAllDecks() {
		return new ResponseEntity<Object>(service.getAllDecks(), HttpStatus.OK);
	}
	
	@RequestMapping(value="/{deckId}", method=RequestMethod.GET)
	public ResponseEntity<Object> getDeck(@PathVariable Long deckId) {
		return new ResponseEntity<Object>(service.getDeck(deckId), HttpStatus.OK);
	}
	
	@RequestMapping(value="/{deckId}", method=RequestMethod.PUT)
	public ResponseEntity<Object> updateDeck(@RequestBody Deck deck, @PathVariable Long deckId) {
		try {
			return new ResponseEntity<Object>(service.updateDeck(deck, deckId), HttpStatus.OK);			
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Object> createDeck(@RequestBody Deck deck, @PathVariable Long deckId) {
		try {
			return new ResponseEntity<Object>(service.createDeck(deck, deckId), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}


}
