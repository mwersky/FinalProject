package com.mwersky.FinalProject.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "cards")
public class Card {
	
	
	private Long id;
	
	private String game;
	
	
	private String cardName;
	
	private String details;
	
	
	private Set<Decklist> decklist = new HashSet<Decklist>(0);

	public Card() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id", unique = true)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGame() {
		return game;
	}

	public void setGame(String game) {
		this.game = game;
	}

	@Column(unique = true)
	public String getCardName() {
		return cardName;
	}

	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}
	
	@OneToMany(mappedBy = "card")
	public Set<Decklist> getDecklist() {
		return decklist;
	}

	public void setDecklist(Set<Decklist> decklist) {
		this.decklist = decklist;
	}

	
}
