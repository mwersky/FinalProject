package com.mwersky.FinalProject.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
//import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Embeddable
public class DecklistId implements Serializable { //Don't ask me how this works because I don't know.
	
	@ManyToOne
//	@JoinColumn(name = "deck_id")
    private Deck deck;
	
	@ManyToOne
//	@JoinColumn(name = "card_id")
    private Card card;


    
    public Deck getDeck() {
        return deck;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }


    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DecklistId that = (DecklistId) o;

        if (deck != null ? !deck.equals(that.deck) : that.deck != null) return false;
        if (card != null ? !card.equals(that.card) : that.card != null)
            return false;

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