package pokebank;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import com.project0.pokebank.Trainer;
import com.project0.pokebank.TrainerDao;
import com.project0.pokebank.TrainerDaoImpl;

public class BankTester {

	@Test
	public void test() {
		TrainerDao testDao = new TrainerDaoImpl();
		ArrayList<Trainer> testList = testDao.getAllTrainers();
		Trainer testTrainer1 = testList.get(0);
		Trainer testTrainer2 = testList.get(2);
		
		
		assertNotNull(testDao.getAllTrainers());
		
		System.out.println(testTrainer1.getUsername() + ": " + testDao.getTrainerBox(testTrainer1));
		assertNotNull(testDao.getTrainerBox(testTrainer1));
		
		System.out.println(testTrainer2.getUsername() + ": " + testDao.getTrainerBox(testTrainer2));
		assertEquals(new ArrayList<>(), testDao.getTrainerBox(testTrainer2));
	}

}
