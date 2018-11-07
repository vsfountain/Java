package com.bank.registration.service;

import java.util.List;

import com.bank.registration.dao.RegistrationDAO;
import com.bank.registration.dao.RegistrationDAOImpl;
import com.bank.registration.model.Registration;

public class RegistrationServiceImpl implements RegistrationService {
	
	private RegistrationDAO registrationDAO = new RegistrationDAOImpl();
	
	@Override
	public List<Registration> getAllRegistration() {
		return registrationDAO.selectAllRegistration();
	}

	@Override
	public int createRegistrationDB() {
		return registrationDAO.createRegistrationDB();
	}

	@Override
	public int addRegistration(Registration registration) {
		return registrationDAO.insertRegistration(registration);
	}

	@Override
	public int removeRegistration(Registration registration) {
		return registrationDAO.deleteRegistation(registration);
	}
	
}
