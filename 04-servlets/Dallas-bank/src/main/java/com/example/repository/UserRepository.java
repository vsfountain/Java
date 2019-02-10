package com.example.repository;

import javax.persistence.Id;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;;

@Repository
public interface UserRepository<User> extends CrudRepository<User, Id>{
	
	}