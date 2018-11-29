package com.example;

import com.example.dao.SuperVillainDao;
import com.example.model.SuperVillain;

public class Main {

	public static final SuperVillainDao svdao = new SuperVillainDao();
	
	public static void main(String[] args) {
		// This is for demo purposes
		// Session ses= HibernateUtil.getSession();
		// ses.close();

		insertInitialValues();
		
		System.out.println("Select by Id 2:   "+svdao.selectById(2));
		
		System.out.println("Select All:       "+svdao.selectAll());
		
		System.out.println("done");
	}

	public static void insertInitialValues() {

		SuperVillain vill = new SuperVillain("Syndrome", "Power Remote", 50_000);
		svdao.insert(vill);
		
		vill = new SuperVillain("ScreenSlaver", "Hypnotism", 70_000);
		svdao.insert(vill);
		
		vill = new SuperVillain("Joker", "Infectious Laugh", 123_500);
		svdao.insert(vill);
		
		vill = new SuperVillain("Scar", "Too much reading", 99_000);
		svdao.insert(vill);
		
		vill = new SuperVillain("Yzma", "Long eyelashes", 50);
		svdao.insert(vill);
	}
}
