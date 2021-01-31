package com.mwersky.FinalProject.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mwersky.FinalProject.entity.Card;
import com.mwersky.FinalProject.repository.CardRepository;

@Service
public class CardService {
	
	private static final Logger logger = LogManager.getLogger(CardService.class);

	@Autowired
	private CardRepository repo;
	
	public Card getCardById(Long id) throws Exception {
		try {
			return repo.findOne(id);
		} catch (Exception e) {
			logger.error("Exception occurred while trying to retrieve customer: " + id, e);
			throw e;
		}
	}
	
	public Iterable<Card> getCards() {
		return repo.findAll();
	}
	
	public Card createCard(Card card) {
		return repo.save(card);
	}
	
	public Card updateCard(Card card, Long id) throws Exception {
		try {
			Card oldCard = repo.findOne(id);
			oldCard.setCardName(card.getCardName());
			oldCard.setGame(card.getDetails());
			oldCard.setDetails(card.getDetails());
			return repo.save(oldCard);
		} catch (Exception e) {
			logger.error("Excception occurred while trying to update card: " + id, e);
			throw new Exception("Unable to update Card.");
		}
	}
	
	public void deleteCard(Long id) throws Exception {
		try {
			repo.delete(id);
		} catch (Exception e) {
			logger.error("Exception occurred when trying to delete customer: " + id, e);
			throw new Exception("Unable to delete customer.");
		}
	}
}
