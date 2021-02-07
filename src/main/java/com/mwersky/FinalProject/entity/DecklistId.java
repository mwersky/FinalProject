package com.mwersky.FinalProject.entity;

import java.io.Serializable;

@SuppressWarnings("serial")
public class DecklistId implements Serializable
{
    private Long deck;
    private Long card;
    
    //SECRET SAUCE
    public DecklistId(Long deckId, Long cardId) {
    	this.deck = deckId;
    	this.card = cardId;
	}
    
    public DecklistId() {
    	
    }

	public Long getDeck() {
        return deck;
    }

    public void setDeck(Long deck) {
        this.deck = deck;
    }


    public Long getCard() {
        return card;
    }

    public void setCard(Long card) {
        this.card = card;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DecklistId that = (DecklistId) o;

        if (deck != null ? !deck.equals(that.deck) : that.deck != null) return false;
        if (card != null ? !card.equals(that.card) : that.card != null) return false;

        return true;
    }
    
    @Override
    public int hashCode() {
        int result;
        result = (deck != null ? deck.hashCode() : 0);
        result = 31 * result + (card != null ? card.hashCode() : 0);
        return result;
    }
    
}