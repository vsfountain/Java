package com.service;

import com.profiles.Account;
import com.profiles.Client;

public interface ClientService {
	public String clientCreator();

	public String clientLogin();

	public void canBank(Client c, Account a);

	public boolean changeClientPassword(Client c, String verify);
		
	public boolean linkAccount(Client c, Account a);

	public void mutateName(Client c);

}
