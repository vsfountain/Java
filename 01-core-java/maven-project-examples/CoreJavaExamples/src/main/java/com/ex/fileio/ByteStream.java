package com.ex.fileio;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ByteStream {
	public static void main(String[] args) {
		
		String filename = "src/main/java/com/ex/fileio/sampleByteFile.txt";
		
//		writeByteStream(filename);
//		readByteStream(filename);
		
		readThisClassFile();
	}
	
	static void readByteStream(String filename){
		try(InputStream is = new FileInputStream(filename)){
			
			int i;
			while((i = is.read()) != -1){
				System.out.print(i + " ");
			}
			//return;
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			//logic
			//System.exit(0);
			//System.out.println("Finally");
		}
	}
	
	static void writeByteStream(String filename){
		
		try(OutputStream os = new FileOutputStream(filename)){
			
			os.write(65);
			os.write(66);
			os.write(67);
			os.write(200);
			os.write(300);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	static void readThisClassFile(){
		String filename = "target/classes/com/ex/fileio/ByteStream.class";
		try(InputStream is = new FileInputStream(filename)){
			
			byte[] first4Bytes = new byte[4];
			is.read(first4Bytes);
			
			for(byte b:first4Bytes){				
				System.out.print(Integer.toHexString(b).substring(6));
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	
	
	
}
