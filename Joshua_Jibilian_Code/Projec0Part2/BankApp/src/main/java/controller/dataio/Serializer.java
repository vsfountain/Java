package controller.dataio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


// TODO: Auto-generated Javadoc
/**
 * The Class Serializer. Handles the loading and saving of the generic entered
 *
 * @param <T> the generic type
 */
public class Serializer<T> {

	/**
	 * Loads a singleton of type T.
	 *
	 * @param f the file where saved singleton is located
	 * @return T saved singleton
	 */
	@SuppressWarnings("unchecked")
	public T load(File f) {
		//System.out.println("loading");
		T obj = null;
		//open files
		try (ObjectInputStream objectInputStream =
				new ObjectInputStream(new FileInputStream(f))) {
			//if file not already created, also makes one if not
			if (!f.createNewFile()) {
				//System.out.println("the file " + f);
				//read file
				obj = (T) objectInputStream.readObject();
				objectInputStream.close();

			}
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}

		return obj;

	}

	/**
	 * Save object of type T.
	 *
	 * @param item the item
	 * @param f the f
	 */
	public void save(T item, File f) {
		//System.out.println("Serializer: Saving");
		//System.out.println(item);
		try (ObjectOutputStream objectOutputStream =
				new ObjectOutputStream(new FileOutputStream(f))) {

			//System.out.println("Before write" + item);
			objectOutputStream.writeObject(item);
			objectOutputStream.flush();
			objectOutputStream.close();
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}

	}
}
