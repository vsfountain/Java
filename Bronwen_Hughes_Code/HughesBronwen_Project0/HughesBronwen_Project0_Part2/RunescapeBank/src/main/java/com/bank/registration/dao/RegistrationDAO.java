package com.bank.registration.dao;

import java.util.List;

import com.bank.registration.model.Registration;

public interface RegistrationDAO {

	public int insertRegistration(Registration r);
	
	public List<Registration> selectAllRegistration();
	public Registration selectRegistrationById(int id);
	//public Registration selectRegistrationrByUsername (String username);
	
	public int updateRegistration(Registration r);
	
	public int deleteRegistation(Registration r);
	
	public int createRegistrationDB();
}
