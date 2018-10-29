package Admin;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Person implements Serializable, CharSequence{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1934685242800545179L;
	
	private String name; 
	private int pin;
	private transient Integer ssn;
	protected static int accessLevel;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPin() {
		return pin;
	}
	public void setAge(int pin) {
		this.pin = pin;
	}
	public Integer getSsn() {
		return ssn;
	}
	public void setSsn(Integer ssn) {
		this.ssn = ssn;
	}
	public void setAccessLevel(int accessLevel) {
		this.accessLevel = accessLevel;
	}
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", pin=" + pin + ", ssn=" + ssn + "]";
	}
	
	public Person(String name, int pin, Integer ssn, int accessLevel) {
		super();
		this.name = name;
		this.pin = pin;
		this.ssn = ssn;
		this.accessLevel = accessLevel;
	}
	@Override
	public int length() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public char charAt(int index) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public CharSequence subSequence(int start, int end) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	protected static boolean readObject(String filename, Person person) {
		try(ObjectInputStream ois = new ObjectInputStream(
				new FileInputStream(filename)))
		{
			Object obj = ois.readObject();//de-serialization
			BufferedReader bf = new BufferedReader(new FileReader(filename));
			
			System.out.println("readline"+bf.readLine());
			System.out.println("obj class"+obj.toString());
			System.out.println("person class"+person.toString());
			System.out.println("deserialized obj"+obj);
			
			if(obj.toString()==person.toString()) {
				System.out.println("Customer Info Found");
				return true;
			}
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("New person");
		return false;
	}
	protected static void writeObject(String filename, Person person) {
		System.out.println("Writing new customer information");
		//FileWriter writer = new FileWriter(filename,true);
		try(ObjectOutputStream oos = new ObjectOutputStream(
				new FileOutputStream(filename,true)))
		{
			Object obj = person;
			oos.writeObject("/n");
			oos.writeObject(obj); //serialization
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}

