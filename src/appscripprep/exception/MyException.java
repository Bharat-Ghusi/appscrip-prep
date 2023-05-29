package appscripprep.exception;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class MyException {

	public static void main(String[] args) {
//		writeToFile();
		doMath();
	}

//	Checked Exception
	public static void writeToFile() {
		String str="Hello Avilash";
		BufferedWriter writer =null;
		try {
			writer = new BufferedWriter(new FileWriter("C:\\Users\\3Embed\\Desktop\\TestFile.txt"));
			writer.write(str);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
//	Unchecked Exception
	public static void doMath() {
		int a=9;
		int b=0;
		System.out.println("Program Starts here");
		try {
			System.out.println(a/b);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("Program ends here");
	}
	
}
