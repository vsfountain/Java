package Admin;

import java.io.Serializable;

public class Person implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1934685242800545179L;
	
	private String name; 
	private int pin;
	private Integer ssn;
	protected int accessLevel;
	
	
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
		return "Person [name=" + name + ", pin=" + pin + ", ssn=" + ssn + ",accessLevel=" + accessLevel+"]";
	}
	
	public Person(String name, int pin, Integer ssn, int accessLevel) {
		super();
		this.name = name;
		this.pin = pin;
		this.ssn = ssn;
		this.accessLevel = accessLevel;
	}

}

