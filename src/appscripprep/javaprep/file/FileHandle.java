package appscripprep.javaprep.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class FileHandle {

	public static void main(String[] args) throws IOException {
		
		//Using Buffered writer
		FileWriter writer = new FileWriter("Test.txt");
		BufferedWriter bufferedWriter = new BufferedWriter(writer);
		bufferedWriter.write("How are you buddy?");
		bufferedWriter.newLine();
		bufferedWriter.write("I'm doing good.");
		bufferedWriter.flush();
		bufferedWriter.close();
		writer.close();
		//Using Buffered reader
		 FileReader reader = new FileReader("Test.txt");
		 BufferedReader bufferedReader = new BufferedReader(reader);
		 String readLine = "";
		 while( (readLine =bufferedReader.readLine()) != null) {
			System.out.println(readLine); 
		 }
		 
//		 PrintWriter printWriter = new PrintWriter("Test.txt");
//		 printWriter.format("%25s", "Avilash Ghusi");
//		 printWriter.println();
//		 printWriter.println("New line ");
//		 printWriter.flush();
//		 printWriter.close();
//		 
	}
	

}
