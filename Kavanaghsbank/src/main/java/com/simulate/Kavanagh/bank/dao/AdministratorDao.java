package com.simulate.Kavanagh.bank.dao;
import java.util.List;

import com.simulate.Kavanagh.bank.model.Administrator;

/**
 *@author Kristen Kavangh 
 *@version 11/4/2018
 */

public interface AdministratorDao {
/**
 * CRUD methods only
 */
	//Create
	public int insertAdministrator(Administrator admin);
	//read
	public List <Administrator>selectAllAdminstrator();
	public Administrator selectAdministratorById (int admin_id);
	public Administrator selectAdministratorByAdminFirstName (String adminFirstName);
	public Administrator selectAdministratorByAdminLastName(String adminLastName);
	public Administrator selectAdministratorByAdminEmail(char adminEmail);
	 //update 
	public int updateAdministrator (Administrator admin);
	//delete
	public int deleteAdministrator(Administrator admin);
	}


