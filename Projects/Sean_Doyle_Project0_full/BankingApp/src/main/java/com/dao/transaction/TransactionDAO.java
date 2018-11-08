package com.dao.transaction;

import java.util.ArrayList;

import com.profiles.Transaction;

public interface TransactionDAO {
	//CREATE
	public int insertTransaction(Transaction t);
	
	//READ
	public ArrayList<Transaction> selectAllTransactions(int clientNum);
	
	

	public void wipeDB(String verify);
	
}
