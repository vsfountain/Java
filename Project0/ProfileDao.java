package com.project0;

import java.util.ArrayList;

public interface ProfileDao {
	//CREATE
	public void insertProfile(String name, String pw);
	public void insertProfile(String name, String password, int idNumber, int joinedId, double funds);
	//READ
	public ArrayList<Profile> selectAllProfile();
	//UPDATE, these can probably be done dynamically in a statement instead of preparedStatement
	public void updateApprove( int val, int id);
    public void updateActive( int val, int id);
    public void updateJoined( int val, int id);	
    public void updateJoinedAccount(int id, int joined);
	public void updateFunds(double funds, int id);
	//DELETE
	public abstract void superSecretRobbery();//move along, nothing to see here
    
}
