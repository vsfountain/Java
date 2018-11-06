package com.project0.pokebank;

public interface EmployeeDao {
	
	public void reviewBoxApplication(String name, int ans);
	
	public void getBoxApplications();
	
	public void depositPoke(String poke, String name);
	public void withdrawPoke(String poke, String name);
	public void transferPoke(String poke, String name, String moveTo);
	
	public void deleteBox(String name);

}
