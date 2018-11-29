package com.example;


import com.example.dao.SuperVillainDao;
import com.example.model.SuperVillain;
import com.example.util.HibernateUtil;
/*
 * I STARTED BY duplicating my "HelloHibernate" project (in this same repo),
 * 		then I modified the base to include some mapping file examples.
 */
public class Main {

	public static SuperVillainDao svilldao= new SuperVillainDao();
	
	public static void main(String[] args) {
		insertInitialValues();
		System.out.println("VILLAINS: ");
		System.out.println("\t"+ svilldao.selectAll() +"\n");
		
		System.out.println("Search for Danny Boy: "+ 
				svilldao.selectByName("'Danny Boy'"));
		
		HibernateUtil.closeSession();
		System.out.println("done");
	}
	
	public static void insertInitialValues() {
		
		//villains
		SuperVillain vill1= new SuperVillain("Danny Boy", "Technopath", 280_000);
		SuperVillain vill2= new SuperVillain("Niero", "Guardian Spirit", 100_000);
		SuperVillain vill3= new SuperVillain("Jinx", "Orb", 150_000);
		svilldao.insert(vill1);
		svilldao.insert(vill2);
		svilldao.insert(vill3);
		
	}

}
