package com.example.throwable;

public class MyException extends RuntimeException {
	public MyException() {
	}
	
	public MyException(String message) {
		super(message);
	}
	
	public MyException(String message, Throwable clause) {
		super(message, clause);
	}
}
