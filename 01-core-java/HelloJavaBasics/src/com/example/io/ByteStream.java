package com.example.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ByteStream {

	public static void main(String[] args) {

		String filename = "./ByteFile.txt";

		//readThisClassFile();
		readByteStream(filename);
		 //writeByteStream(filename);
	}

	static void readByteStream(String filename) {

		//try with resources
		//	has to be a AutoCloseable object
		try (InputStream is = new FileInputStream(filename)) {
			int i;
			while ((i = is.read()) != -1) {
				System.out.println(i + " ");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {

		} finally {
			// we don't need to close resources because we have try with
			// resources
		}
	}

	static void writeByteStream(String filename) {

		try (OutputStream os = new FileOutputStream(filename)) {
			os.write(65);
			os.write(66);
			os.write(67);
			os.write(200);
			os.write(300);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {

		}
	}

	static void readThisClassFile() {
		String filename = "./bin/com/example/io/ByteStream.class";
		try (InputStream is = new FileInputStream(filename)) {
			byte[] first4 = new byte[4];
			is.read(first4);

			for (byte b : first4) {
				System.out.print(Integer.toHexString(b).substring(6));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {

		}
	}
}