package bank.main;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class example {
static void printTo(ArrayList<Object> sting) {
	String fileName = "./storage.txt";
	try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
		out.writeObject(sting);
	}catch (Exception e) {
		e.printStackTrace();
	}
}
static void repopulate(ArrayList<Object> sting) {
	String fileName = "./storage.txt";
	try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
		sting = in.readObject();
	}catch (Exception e) {
		e.printStackTrace();
	}
}
}
