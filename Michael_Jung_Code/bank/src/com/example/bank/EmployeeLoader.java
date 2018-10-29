package com.example.bank;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class EmployeeLoader {

	public static ArrayList<Employee> loadEmployee() {
		
		String filename = "C:\\Users\\Michael's Laptop\\Documents\\workspace-spring-tool-suite-4-4.0.0.RELEASE\\Bank\\Employee.txt"/*"C:\\Users\\Michael's Laptop\\Documents\\workspace-spring-tool-suite-4-4.0.0.RELEASE\\Bank\\src\\com\\example\\bank\\Customer.txt"*/;
				
				ArrayList<Employee> aaa = new ArrayList<>();
				
				try(ObjectInputStream ois = new ObjectInputStream(
						new FileInputStream(filename)))
				{
					System.out.println(ois.available());
					
					while(true) {
					Object obj = ois.readObject();//de-serialization
					Employee a = (Employee) obj;
					aaa.add(a);
					/*System.out.println(obj);*/
					System.out.println(a);
					}
					
					/*Object oaa = ois.readObject();
					Customer aaa = (Customer) oaa;
					System.out.println(oaa);*/
					
					
				}catch(EOFException e) {
					e.printStackTrace();
					return aaa;
					
				}catch(FileNotFoundException e) {
					e.printStackTrace();
				}catch(IOException e) {
					e.printStackTrace();
				}catch(ClassNotFoundException e) {
					e.printStackTrace();
				}
				return aaa;
				
				
				
				
				
			}
	
}
