package com.hw1.q20;

//Java Program to illustrate reading from FileReader 
//using Scanner Class reading entire File 
//without using loop 
import java.io.File; 
import java.io.FileNotFoundException; 
import java.util.Scanner; 

//Java program to illustrate reading data from file 
//using nio.File 
import java.util.*; 
import java.nio.charset.StandardCharsets; 
import java.nio.file.*; 
import java.io.*; 
public class ReadFileIntoList 
{ 
public static List<String> readFileInList(String fileName) 
{ 

	List<String> lines = Collections.emptyList(); 
	try
	{ 
	lines = 
	Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8); 
	} 

	catch (IOException e) 
	{ 

	// do something 
	e.printStackTrace(); 
	} 
	return lines; 
} 
public static void main(String[] args) 
{ 
	List l = readFileInList("./Data.txt"); 

	Iterator<String> itr = l.iterator(); 
	while (itr.hasNext()) 
	System.out.println(itr.next()); 
} 
} 
