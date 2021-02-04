package com.mwersky.FinalProject.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "decks")
public class Deck {
	
	
	private Long deckId;
	
	private String deckName;
	
	private User user;
	private Set<Decklist> decklist;
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(unique= true)
	public Long getDeckId() {
		return deckId;
	}
	public void setDeckId(Long deckId) {
		this.deckId = deckId;
	}
	
	
	public String getDeckName() {
		return deckName;
	}
	public void setDeckName(String deckName) {
		this.deckName = deckName;
	}
	
	@ManyToOne
	@JoinColumn(name = "userId")
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	@OneToMany(mappedBy = "user")
	public Set<Decklist> getDecklist() {
		return decklist;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.stock", cascade=CascadeType.ALL)
	public void setDecklist(Set<Decklist> decklist) {
		this.decklist = decklist;
	}
}
