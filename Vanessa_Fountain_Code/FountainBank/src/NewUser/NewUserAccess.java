package NewUser;

import java.io.IOException;

import Admin.Person;

public class NewUserAccess {

	public static void main(Person person) throws ClassNotFoundException, IOException {
		String filename = "./NewUserInformation";
		NewUserBase.readObject(filename, person);
		NewUserBase.writeObject(filename, person);
	}
}
