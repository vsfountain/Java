package com.minifullstack.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;


import com.minifullstack.dao.UserDao;
import com.minifullstack.model.Users;


public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static UserDao userdao = new UserDao();

	public MyServlet() {
		insertInitialValues();
	}

	public void insertInitialValues() {
		Users user1 = new Users("John", "password", "John", "Johnson", "johnny@email.com",2);
		Users user2 = new Users("Peter", "password", "Peter", "Snow", "petersnow@email.com",1);
		userdao.insert(user1);
		userdao.insert(user2);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("\t" + userdao.selectAll() + "\n");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("\t" + userdao.selectAll() + "\n");
	}
}
