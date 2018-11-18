package com.kers.main;

import com.kers.daos.ReimbursementDAO;
import com.kers.daos.ReimbursementDAOImpl;

public class Main {
	public static void main(String[] args) {
		//UserDAO userD = new UserDAOImpl();
		//System.out.println(userD.selectUserByUsernameAndPassword("seandoyle", "12345"));
		//System.out.println(userD.selectUserByUsername("bronwenhughes"));
		ReimbursementDAO rdao = new ReimbursementDAOImpl();
		rdao.selectAllReimbursements();
	}
}
