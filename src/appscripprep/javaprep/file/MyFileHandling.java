package appscripprep.javaprep.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MyFileHandling {
//	Create a file
	public static void createFile() {
		File file = new File("Test.txt");
		try {
			if(file.createNewFile()) {
				System.out.println("File is creafted.");
				System.out.println(file.getAbsolutePath());
				System.out.println(file.getName());
			}else {
				System.out.println("File is already created.");
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
//	Read from file using File class
	public static void readFromFile() {
		File file = new File("Test.txt");
		try {
			Scanner scanner = new Scanner(file);
			while(scanner.hasNext()) {
				System.out.println(scanner.next());
			}
			scanner.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
//	Read from fileReader using File class
	public static void readFromFile2() {
		File file = new File("Test.txt");
		try {
			FileReader reader = new FileReader(file);
			int ch;
			while((ch=reader.read())  != -1) {
				System.out.print((char)ch);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//Write To a file
	public static void writeToFile() {
		try {
			FileWriter writer = new FileWriter("Test.txt");
			writer.append(" Avilash");
			writer.close();
			readFromFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//Delete a file
	public static void deleteFile() {
		File file = new File("Test.txt");
		try {
			if(file.delete()) {
				System.out.println("File is deleted");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	//Method to demonstrate BufferReader
		public static void read1() {
			FileReader reader;
			try {
				reader = new FileReader("Test.txt");
				BufferedReader bf = new BufferedReader(reader);
				//markSupported
				if(bf.markSupported()) {
					System.out.println("Mark is supported.");
					//mark()
					bf.mark(120);
				}
				//Skipping 6 character
				char[] ch=new char[20];
				
				bf.skip(6);
				if(bf.ready()) {
					//Read line
					System.out.println(bf.readLine());
					//read(char[])
					bf.read(ch);
					for (int i = 0; i < ch.length; i++) {
						System.out.print(ch[i]);
					}
					System.out.println();
					
					//reset()
					bf.reset();
					for (int i = 0; i < 6; i++) {
						System.out.print((char)bf.read());
					}
					System.out.println();
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	public static void main(String[] args) {
//		createFile();
//		readFromFile();
//		writeToFile();
//		deleteFile();
//		readFromFile2();
		read1();
	}

}
