package com.mwersky.FinalProject.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "decks")
public class Deck {
	
	
	private Long id; // deck id
	
	
	private String name; //deck name
	
	@JsonIgnore
	private User user;
	
	
	private Set<Decklist> decklist;
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name="id")
	public Long getDeckId() {
		return id;
	}
	public void setDeckId(Long deckId) {
		this.id = deckId;
	}
	
	@Column(name="deck_name")
	public String getDeckName() {
		return name;
	}
	public void setDeckName(String deckName) {
		this.name = deckName;
	}
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	@OneToMany(mappedBy = "deck", cascade=CascadeType.ALL)
	public Set<Decklist> getDecklist() {
		return decklist;
	}
	
	public void setDecklist(Set<Decklist> decklist) {
		this.decklist = decklist;
	}
}
