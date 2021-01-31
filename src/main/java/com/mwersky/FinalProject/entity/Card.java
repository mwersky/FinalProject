package com.mwersky.FinalProject.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cards")
public class Card {

	private Long id;
	private String game;
	private String cardName;
	private String details;
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(unique= true)
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
	
	@Column(unique= true)
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
}
