package com.practice.controller;

import java.util.List;

import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.practice.dao.CustomerDAO;
import com.practice.model.Customer;


@Controller("/users")
public class UserController {

		public CustomerDAO customer;
		@RequestMapping("/getusers.serv")
		@ResponseBody 
		public List<Customer> getAll(){
			return customer.selectAll();
		}
	
}
