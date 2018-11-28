package VaultMain;

import org.apache.log4j.Logger;

import ServiceLayer.VaultService;
import ServiceLayer.VaultServiceImplementation;

public class Main {

	public static void main(String[] args) {
		Logger log = Logger.getLogger(VaultServiceImplementation.class);
		
		log.info("logged in: ");
	}

}
