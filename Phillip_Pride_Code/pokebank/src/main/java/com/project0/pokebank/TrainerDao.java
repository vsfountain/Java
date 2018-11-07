package com.project0.pokebank;

import java.util.ArrayList;
import java.util.List;

public interface TrainerDao {
	//CREATE a new Trainer
	public void createTrainer(String name, String passw);
	//READ to database
	public ArrayList<Trainer> getAllTrainers();
	public int getTrainerId(Trainer trainer);
	public List<String> getTrainerBox(Trainer trainer);
	//UPDATE to trainer Table
	public void applyForBox(Trainer trainer);
	public void depositPoke(String poke, Trainer trainer);
	public void withdrawPoke(String poke, Trainer trainer);
	public void transferPoke(String poke, Trainer trainer, Trainer trainer2);

}
