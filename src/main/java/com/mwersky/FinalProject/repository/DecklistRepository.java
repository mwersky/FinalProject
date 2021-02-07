package com.mwersky.FinalProject.repository;

import org.springframework.data.repository.CrudRepository;

import com.mwersky.FinalProject.entity.Decklist;
import com.mwersky.FinalProject.entity.DecklistId;

public interface DecklistRepository extends CrudRepository<Decklist, DecklistId> {
	
}
