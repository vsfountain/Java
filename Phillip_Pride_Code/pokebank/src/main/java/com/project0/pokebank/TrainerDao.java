package com.project0.pokebank;

import java.util.List;

public interface TrainerDao {
	//CREATE
	public void createTrainer(String name, String passw);
	//READ
	public List<Trainer> getAllTrainers();
	public int getTrainerId(String name);
	public List<String> getTrainerBox(String name);
	//UPDATE
	public void applyForBox(String name);
	public void depositPoke(String poke, String name);
	public void withdrawPoke(String poke, String name);
	public void transferPoke(String poke, String name, String moveTo);

}
