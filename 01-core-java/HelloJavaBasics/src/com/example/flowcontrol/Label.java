package com.example.flowcontrol;

public class Label {

	public static void main(String[] args) {

		Alex:
		for(int i=0; i<3; i++) {
		Vanessa:
			for(int j=0;j<4;j++) {
				if(j==1)
					continue Alex;
				System.out.println(i+ " "+ j);
				//one hundred billion lines of code
			}
			//go here
		}
	}

}
