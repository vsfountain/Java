package Admin;

import java.io.Serializable;

public class Person implements Serializable, CharSequence{

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
	
	
//	protected static void readObject(String filename, Person person) throws ClassNotFoundException, IOException {
//		List<Object> results = new ArrayList<Object>();
//		FileInputStream f = new FileInputStream(filename);
//		//ObjectInputStream ois = new ObjectInputStream(f);
//
//	    try {
//	    	//FileInputStream f = new FileInputStream(filename);
//	        while (true) {
//	            ObjectInputStream ois = new ObjectInputStream(f);
//	            results.add(ois.readObject());
//	        }
//	    } catch (EOFException ignored) {
//	        // as expected
//	    } finally {
//	        if (f != null) {
//	            f.close();
//	        }
//	    }
//	    System.out.println("results = " + results);
//	}
//	
//	protected static void writeObject(String filename, Person person) {
//		
//		System.out.println("Writing new customer information");
//		try(ObjectOutputStream oos = new ObjectOutputStream(
//				new FileOutputStream(filename,true)))
//		
//		{
//			Object obj = person;
//			oos.reset();
//			oos.writeObject(obj); //serialization
//			
//		}catch(IOException e) {
//			e.printStackTrace();
//		}
//	}

}

