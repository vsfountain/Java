package com.example;

public class Converter {
	ConversionService cserv;
	
	public Converter(ConversionService cserv) {
		this.cserv= cserv;
	}
	
	public int milesToFeet(int i) {
		//return i * cserv.findMilesToFeetMultiplier();
		
		return i * 5280;
	}
}
