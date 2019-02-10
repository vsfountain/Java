package com.dikokosolutions.dao;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Main {

    // Complete the activityNotifications function below.
    static void activityNotifications(int[] expenditure, int d) {
        List <Integer> trail = new ArrayList<Integer>();
        int count = 0;
        
        for(int i = 0 ; i < expenditure.length; i++) {
        	for(int j = expenditure.length;j > d;j--) {
        		System.out.println(expenditure[j]);
        	}
        }
        
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
    	int[] array = {1,2,3,4,4};
    	
    	activityNotifications(array,3);
    }
}
