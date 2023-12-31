package com.example;

import java.util.ArrayList;
import java.util.List;

import com.example.dao.CrimeDao;
import com.example.dao.SuperVillainDao;
import com.example.model.Crime;
import com.example.model.SuperVillain;
import com.example.util.HibernateUtil;

public class Main {

	public static final SuperVillainDao svdao = new SuperVillainDao();
	public static final CrimeDao cdao = new CrimeDao();
	
	public static void main(String[] args) {
		// This is for demo purposes
		// Session ses= HibernateUtil.getSession();
		// ses.close();

		insertInitialValues();
		
		System.out.println("Select by Id 2:   "+svdao.selectById(6));
		
		System.out.println("Select by name:    "+svdao.selectByName("'Phillip'"));
		
		System.out.println("VILLAINS: ");
		System.out.println("\t"+svdao.selectAll()+"\n");
		
		System.out.println("CRIMES: ");
		System.out.println("\t"+cdao.selectAll()+"\n");
		
		System.out.println("done");
		HibernateUtil.closeSession();
	}

	public static void insertInitialValues() {

		//CRIMES
		Crime crime1 = new Crime("Aggravated Assault", "Causing Bodily Harm");
		Crime crime2 = new Crime("Arson", "Burning buildings, land, or property");
		Crime crime3 = new Crime("Pineapples on Pizza", "Who would do such a thing?");
		Crime crime4 = new Crime("The Twilight Series", "Those movies are illegal, right?");
		cdao.insert(crime1);
		cdao.insert(crime2);
		cdao.insert(crime3);
		cdao.insert(crime4);
		
		//VILLAINS
		List<Crime> crimeList= new ArrayList<>();
		crimeList.add(crime1);
		crimeList.add(crime4);
		
		SuperVillain vill1= new SuperVillain("Sean", "Aviators", 5, crimeList);
		crimeList= new ArrayList<>();
		crimeList.add(crime1);
		crimeList.add(crime2);
		crimeList.add(crime3);
		SuperVillain vill2= new SuperVillain("Michael J", "Angular", 70, crimeList);
		
		crimeList= new ArrayList<>();
		crimeList.add(crime1);
		SuperVillain vill3= new SuperVillain("Phillip", "Hating on the best pokemon", 3, crimeList);
		
		svdao.insert(vill1);
		svdao.insert(vill2);
		svdao.insert(vill3);
		
		
		/*SuperVillain vill = new SuperVillain("Syndrome", "Power Remote", 50_000);
		svdao.insert(vill);
		
		vill = new SuperVillain("ScreenSlaver", "Hypnotism", 70_000);
		svdao.insert(vill);
		
		vill = new SuperVillain("Joker", "Infectious Laugh", 123_500);
		svdao.insert(vill);
		
		vill = new SuperVillain("Scar", "Too much reading", 99_000);
		svdao.insert(vill);
		
		vill = new SuperVillain("Yzma", "Long eyelashes", 50);
		svdao.insert(vill);*/
	}
}
