//package com.mwersky.FinalProject.entity;
//
//import java.io.Serializable;
//
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//
////This is a composite primary key for my deck lists table!
//@SuppressWarnings("serial")
//public class DeckListPK implements Serializable {
//
//	@ManyToOne
//	@JoinColumn(name = "deck_id")
//	private Deck deckId;
//	
//	@ManyToOne
//	@JoinColumn(name = "card_id")
//	private Card cardId;
//	
//	public DeckListPK(Deck deckId, Card cardId) {
//		this.deckId = deckId;
//		this.cardId = cardId;
//	}
//}
