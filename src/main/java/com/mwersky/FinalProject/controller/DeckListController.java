package com.mwersky.FinalProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mwersky.FinalProject.entity.Decklist;
import com.mwersky.FinalProject.service.DecklistService;

@RestController
@RequestMapping("/users/{userId}/decks/{deckId}")
public class DeckListController {

	
	@Autowired
	private DecklistService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<Object> getDecklist() {
		return new ResponseEntity<Object>(service.getDecklist(), HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Object> createDecklist(@RequestBody Decklist decklist, @PathVariable Long deckId, @PathVariable Long cardId,
			@PathVariable int amount) {
		try {
			return new ResponseEntity<Object>(service.newCardEntry(decklist, deckId, cardId, amount), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(method=RequestMethod.PUT)
	public ResponseEntity<Object> updateDecklist(@RequestBody Decklist decklist, @PathVariable Long deckId) {
		try {
			return new ResponseEntity<Object>(service.updateDecklist(decklist, deckId), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(method=RequestMethod.DELETE)
	public ResponseEntity<Object> deleteDecklistEntry(@PathVariable Long decklistId) {
		try {
			service.deleteDecklist(decklistId);
			return new ResponseEntity<Object>("Successfully deleted card entry with id: " + decklistId, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
}
