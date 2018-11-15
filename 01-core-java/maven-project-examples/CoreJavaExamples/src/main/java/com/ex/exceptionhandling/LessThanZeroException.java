package com.ex.exceptionhandling;

public class LessThanZeroException extends RuntimeException{
	
	public LessThanZeroException(){}
	
	public LessThanZeroException(String message){
		super(message);
	}
	
	public LessThanZeroException(String message, Throwable cause){
		super(message, cause);
	}
	
	
}
