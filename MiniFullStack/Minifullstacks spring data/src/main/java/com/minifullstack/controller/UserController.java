package com.minifullstack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.minifullstack.repository.UserDao;

@Controller
public class UserController {
	
	@Autowired
	private UserDao userDao;
	
	//@GetMapping("/users.app")
	//public @ResponseBody Users findUsers() {
	//return (List<Users>) UserDao.findByUserName();
}

