package com.example.service;

import com.example.dao.TransactionDao;
import com.example.dao.TransactionDaoImpl;
import com.example.model.Transaction;

public class TransactionServiceImpl implements TransactionService {

	
	TransactionDao transaction = new TransactionDaoImpl();
	
	
	@Override
	public int createTransaction(Transaction t) {
		// TODO Auto-generated method stub
		return transaction.insertTransaction(t);
		
		//return 0;
	}

}
