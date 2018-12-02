package com.kristen;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.kristen.dao.CrimeDao;
import com.kristen.dao.SuperVillianDao;
import com.kristen.model.Crime;
import com.kristen.util.HibernateUtil;

public class Main {
	public static final SuperVillianDao scdao = new SuperVillianDao();
	public static final CrimeDao cdao = new CrimeDao();

	public static void main(String[] args) {
		// not required because of confirguration and session factory created is in the
		// hibernate.cfg.xml file
		// Session ses = HibernateUtil.getSession();
		// ses.close();
		insertInitialValues();
		HibernateUtil.closeSession();

	}

	private static void insertInitialValues() {
		//CRimes
		Crime crime1 = new Crime("Aggravated Assault", "Causing Bodily Harm");
		Crime crime2 = new Crime("Arson", "Birning buildings, land or property");
		Crime crime3 = new Crime("Pineapples on Pizza", "who would do such a thing?");
		Crime crime4 = new Crime("The Twilight series", "Those movies are illegal, right?");
cdao.insert(crime1);
cdao.insert(crime2);
cdao.insert(crime3);
cdao.insert(crime4);

//Villains
List<Crime>CrimeList = new ArrayList<>();
crimeList.add(crime1);
crimeList.add(crime4);
	}
}
