package com.minifullstack.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.minifullstack.model.Users;

public interface UserDao extends CrudRepository<Users, Integer>{

	public Users findBYUserName(Users users);
	public List<Users> findByUserName();

public Users saveUser(Users users);
}


