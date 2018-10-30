package com.bankofdikoko.main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class UserSerializable implements Serializable {

	public static User readObject(String filename) {
		User e = null;
		try {
			FileInputStream fileIn = new FileInputStream(filename);
			ObjectInputStream in = new ObjectInputStream(fileIn);
			e = (User) in.readObject();
			in.close();
			fileIn.close();
		} catch (IOException i) {
			i.printStackTrace();
			return e;
		} catch (ClassNotFoundException c) {
			System.out.println("User class not found");
			c.printStackTrace();
			return e;
		}

		System.out.println("Deserialized Employee...");
		System.out.println("Name: " + e.getFirstName() + " " + e.getLastName());
		System.out.println("Username: " + e.getUserName());
		System.out.println("Password: " + e.getPassword());
		return e;

	}

	public void writeObject(String filename, Object obj) {

		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename, true))) {

			oos.writeObject(obj);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
