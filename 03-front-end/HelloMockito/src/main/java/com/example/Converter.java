package com.example;

public class Converter {
	ConversionService cserv;
	
	public Converter(ConversionService cserv) {
		this.cserv=cserv;
	}
	
	public int milestoFeet(int i) {
		return i * cserv.findMilesToFeet();
		
		//return i*5280;
	}
}
