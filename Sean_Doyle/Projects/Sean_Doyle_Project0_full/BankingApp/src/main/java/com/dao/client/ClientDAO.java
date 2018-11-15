package com.dao.client;

import java.util.ArrayList;

import com.profiles.Account;
import com.profiles.Client;


public interface ClientDAO {
		//CREATE
		public int insertClient(Client c);
		
		//READ
		public ArrayList<Client> selectAllClients();
		public ArrayList<Integer> getClients(String p);
		
		//UPDATE
		public int updateCLient(Client c);
		public int addJoint(Account a, Client c);
		public int activateClient(Client c, int anum);
		
		//DELETE
		public int deleteClient(Client c);
}
