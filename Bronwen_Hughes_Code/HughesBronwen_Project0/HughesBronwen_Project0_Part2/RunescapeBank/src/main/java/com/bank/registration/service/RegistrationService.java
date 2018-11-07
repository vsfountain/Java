package com.bank.registration.service;

import java.util.List;

import com.bank.registration.model.Registration;

public interface RegistrationService {
	public int createRegistrationDB();
	public List<Registration> getAllRegistration();
	public int addRegistration(Registration registration);
	public int removeRegistration(Registration registration);
}
