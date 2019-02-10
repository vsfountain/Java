package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;


@Entity	

@Table(name="User")
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private int userId;
	
	@Column
	public String userName;
	
	@Autowired
	public User(String username) {
		this.userName = username;
	}
}
