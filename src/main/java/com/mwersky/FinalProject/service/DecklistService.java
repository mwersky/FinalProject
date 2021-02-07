package com.mwersky.FinalProject.service;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mwersky.FinalProject.entity.Card;
import com.mwersky.FinalProject.entity.Deck;
import com.mwersky.FinalProject.entity.Decklist;
import com.mwersky.FinalProject.entity.DecklistBody;
import com.mwersky.FinalProject.entity.DecklistId;
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
	
	public Decklist newCardEntry(Long deckId, long cardId, int value) throws Exception {
		Deck deck = deckRepo.findOne(deckId);
		Card card = cardRepo.findOne(cardId);
		if (deck == null || card == null) {
			throw new Exception("Deck or Card does not exist.");
		}
		Decklist decklist = new Decklist();
		decklist.setCard(card);
		decklist.setDeck(deck);
		decklist.setAmount(value);
		return decklistRepo.save(decklist);
	}
	

	public Decklist updateDecklist(DecklistBody body, Long deckId) throws Exception {
		Decklist foundDecklist = decklistRepo.findOne(new DecklistId(deckId, body.cardId));
		if (foundDecklist == null) {
			throw new Exception("decklist not found.");
		}
		foundDecklist.setAmount(body.amount);
		return decklistRepo.save(foundDecklist);
	}

	public void deleteDecklist(DecklistBody body, Long deckId) {
		try {
			decklistRepo.delete(new DecklistId(deckId, body.cardId));
		} catch (Exception e) {
			logger.error("Exception occurred when trying to delete the card entry.", e);
		}
	}

	
}
