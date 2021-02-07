package com.mwersky.FinalProject.repository;

import org.springframework.data.repository.CrudRepository;

import com.mwersky.FinalProject.entity.Card;


public interface CardRepository extends CrudRepository<Card, Long> {

}
