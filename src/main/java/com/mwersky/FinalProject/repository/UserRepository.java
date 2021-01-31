package com.mwersky.FinalProject.repository;

import org.springframework.data.repository.CrudRepository;

import com.mwersky.FinalProject.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {

	public User findByUsername(String username); //spring does most of the work HOWEVER this tells it to perform a query based on this persons User name. re-watch later to confirm this.
}