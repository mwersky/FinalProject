package com.mwersky.FinalProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mwersky.FinalProject.entity.DecklistBody;
import com.mwersky.FinalProject.service.DecklistService;


@RestController
@RequestMapping("/users/{userId}/decks/{deckId}")
public class DeckListController {

	
	@Autowired
	private DecklistService service;
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Object> createDecklist(@PathVariable Long deckId,@RequestBody DecklistBody body) {
		try {
			return new ResponseEntity<Object>(service.newCardEntry(deckId, body.cardId, body.amount), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(method=RequestMethod.PUT)
	public ResponseEntity<Object> updateDecklist(@RequestBody DecklistBody body, @PathVariable Long deckId) {
		try {
			return new ResponseEntity<Object>(service.updateDecklist(body, deckId), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(method=RequestMethod.DELETE)
	public ResponseEntity<Object> deleteDecklistEntry(@PathVariable Long deckId, @RequestBody DecklistBody body) {
		try {
			service.deleteDecklist(body, deckId);
			return new ResponseEntity<Object>("Successfully deleted the card!" , HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
}
