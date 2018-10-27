package com.ex.exceptionhandling;

public class BankTransactionException extends Exception {
	
	public BankTransactionException(){}
	
	public BankTransactionException(String message){
		super(message);
	}
	
	public BankTransactionException(String message, Throwable cause){
		super(message, cause);
	}
	
}
