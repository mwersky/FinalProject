package com.mwersky.FinalProject.service;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mwersky.FinalProject.entity.Card;
import com.mwersky.FinalProject.entity.Deck;
import com.mwersky.FinalProject.entity.Decklist;
import com.mwersky.FinalProject.repository.CardRepository;
import com.mwersky.FinalProject.repository.DeckRepository;
import com.mwersky.FinalProject.repository.DecklistRepository;

@Service
public class DecklistService {
	
	private static final Logger logger = LogManager.getLogger(DecklistService.class);
	
	@Autowired
	private DecklistRepository decklistRepo;
	
	@Autowired
	private DeckRepository deckRepo;
	
	@Autowired
	private CardRepository cardRepo;

	public Iterable<Decklist> getDecklist() {
		return decklistRepo.findAll();
	}
	
	public Decklist newCardEntry(Decklist decklist, Long deckId, long cardId, int value) throws Exception {
		Deck deck = deckRepo.findOne(deckId);
		Card card = cardRepo.findOne(cardId);
		if (deck == null || card == null) {
			throw new Exception("Deck or Card does not exist.");
		}
		decklist.setCard(card);
		decklist.setDeck(deck);
		decklist.setAmount(value);
		return decklistRepo.save(decklist);
	}
	

	public Decklist updateDecklist(Decklist decklist, Long deckId) throws Exception {
		Decklist foundDecklist = decklistRepo.findOne(deckId);
		if (foundDecklist == null) {
			throw new Exception("decklist not found.");
		}
		foundDecklist.setAmount(decklist.getAmount());
		foundDecklist.setCard(decklist.getCard());
		return decklistRepo.save(foundDecklist);
	}

	public void deleteDecklist(Long decklistId) {
		try {
			decklistRepo.delete(decklistId);
		} catch (Exception e) {
			logger.error("Exception occurred when trying to delete customer: " + decklistId, e);
		}
	}

	
}
