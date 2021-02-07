package com.mwersky.FinalProject.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;

@SuppressWarnings("serial")
@Entity
@Table(name = "decklists")
@IdClass(DecklistId.class)
public class Decklist implements Serializable
{
    
    private Card card;

    @JsonIgnore
    private Deck deck;

    
    private int amount;
    
    @Id
    @ManyToOne
    @JoinColumn(name = "card_id", referencedColumnName = "id")
    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }
    
    @Id
    @ManyToOne
    @JoinColumn(name = "deck_id", referencedColumnName = "id")
    public Deck getDeck() {
        return deck;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    @Column(name="number_of_cards")    
	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
    
    

}