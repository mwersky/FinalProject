package com.mwersky.FinalProject.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mwersky.FinalProject.entity.Deck;
import com.mwersky.FinalProject.entity.User;
import com.mwersky.FinalProject.repository.DeckRepository;
import com.mwersky.FinalProject.repository.UserRepository;

@Service
public class DeckService {
	
	@Autowired
	private DeckRepository repo;
	
	@Autowired
	private UserRepository userRepo;
	

	public Iterable<Deck> getAllDecks() {
		return repo.findAll();
	}


	public Deck getDeck(Long deckId) {
		return repo.findOne(deckId);
	}


	public Deck updateDeck(Deck deck, Long id) throws Exception {
		Deck foundDeck = repo.findOne(id);
	if (foundDeck == null) {
		throw new Exception("Post not found.");
	}
	foundDeck.setDeckName(deck.getDeckName());
	return repo.save(foundDeck);
	}
	


	public Deck createDeck(Deck deck, Long userId) throws Exception {
		User user = userRepo.findOne(userId);
		if (user == null) {
			throw new Exception("User not found.");
		}
		deck.setUser(user);
		deck.setDeckName(deck.getDeckName());
		return repo.save(deck);
	}



}
