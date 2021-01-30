package com.mwersky.FinalProject.entity;

//import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {

	private Long id;
	private String hash;
	private String username;
	private String email;
//	private Set<Deck> decks;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}
	
	@Column(unique=true)
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	
//	@OneToMany(mappedBy = "users")
//	public Set<Deck> getDecks() {
//		return decks;
//	}
//
//	public void setDecks(Set<Deck> decks) {
//		this.decks = decks;
//	}

	@Column(unique=true)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	


}
