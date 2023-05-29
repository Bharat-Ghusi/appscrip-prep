package appscripprep.javaprep.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class InputOutputPractice {

	public static void main(String[] args) throws IOException {
		File file = new File("C:\\Users\\3Embed\\eclipse-workspace\\appscripprep\\");
//		System.out.println("getAbsolutePath: " + file.getAbsolutePath());
//		System.out.println("getPath: " + file.getPath());
//		System.out.println("getCanonicalPath: " + file.getCanonicalPath());
//		System.out.println("getFreeSpace: " + file.getFreeSpace());
//		System.out.println("getName: " + file.getName());
//		System.out.println("getParent: " + file.getParent());
//		System.out.println("getTotalSpace: " + file.getTotalSpace());
//		System.out.println("getUsableSpace: " + file.getUsableSpace());
//		System.out.println("getAbsoluteFile: " + file.getAbsoluteFile());
//		System.out.println("getParentFile: " + file.getParentFile());
//		System.out.println("getCanonicalFile: " + file.getCanonicalFile());
		
//		1 Write a Java program to get a list of all file/directory names in the given directory
		System.out.println("list: " + Arrays.toString(file.list()));
//		2. Write a Java program to get specific files with extensions from a specified folder.
		String[] str = file.list(new FilenameFilter() {

			@Override
			public boolean accept(File dir, String name) {
				if (name.toLowerCase().endsWith(".txt")) {
					return true;
				}

				return false;
			}
		});
		System.out.println("get specific files with extensions: " + Arrays.toString(str));

//		3. Write a Java program to check if a file or directory specified by pathname exists or not
		System.out.println("check if a file or directory specified by pathname exists or not: "+file.exists());
//		4. Write a Java program to check if a file or directory has read and write permissions.
		System.out.println("check if a file or directory has read and write permissions: "+file.canRead());
//		5. Write a Java program to check if the given pathname is a directory or a file.
		System.out.println("check if the given pathname is a directory or a file: " + (file.isDirectory() ? true:false)   );
//		6. Write a Java program to compare two files lexicographically.
		File file2 = new File("C:\\Users\\3Embed\\eclipse-workspace\\appscripprep\\Test.txt");
		System.out.println("to compare two files lexicographically: "+file.equals(file2));
//		7. Write a Java program to determine the last modified date of a file
		Date date = new Date(file.lastModified());
		System.out.println("to determine the last modified date of a file: "+date );
//		8. Write a Java program to read input from the Java console.
//		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//		String readLine = bufferedReader.readLine();
//		System.out.println("Read from console: "+readLine);
//		9. Write a Java program to get the file size in bytes, KB, MB.
		System.out.println("File size in bytes: "+file2.length() );
		System.out.println("File size in KB: "+(double)file2.length()/1024 );
		System.out.println("File size in MB: "+(double) file2.length()/(1024* 1024) );
		
//		10. Write a Java program to read the contents of a file into a byte array.
//		FileInputStream fis = new FileInputStream(file2);
//		byte[] contentByte=new byte[2* 2024];
//		int read=0;
//		while((read =  fis.read(contentByte) ) > 0) {
//			System.out.println(new String(contentByte, 0, read-1));
//		}
		
//		11. Write a Java program to read file content line by line. 
		BufferedReader bufferedReader = new BufferedReader(new FileReader(file2));
//		String str1=null;
//		while(( str1=bufferedReader.readLine()) != null) {
//			System.out.println(str1);
//		}
		
//		14. Write a Java program to store text file content line by line in an array.
//		String str1=null;
//		ArrayList<String> list = new ArrayList<>();
//		while(( str1=bufferedReader.readLine()) != null) {
//			list.add(str1);
//		}
//		System.out.println(Arrays.toString(list.toArray()));
		
//		FileWriter writer = new FileWriter(file2);
		
//		16. Write a Java program to append text to an existing file.
//		BufferedWriter bufferedWriter = new BufferedWriter(writer);
//		bufferedWriter.write("Text is appende or not? ");
//		bufferedWriter.newLine();
		
//		17. Write a Java program to read the first 3 lines of a file. 
//		LineNumberReader lineNumberReader = new LineNumberReader(bufferedReader);
//		String str1="";
//		while((str1 = lineNumberReader.readLine()) != null && lineNumberReader.getLineNumber() <= 3) {
//			System.out.println(str1);
//		}
		
		//18. Write a Java program to find the longest word in a text file.
//		Scanner sc = new Scanner(file2);
//		String longestWord="";
//		while(sc.hasNext()) {
//			String next = sc.next();
//			if(next.length() > longestWord.length()) {
//				longestWord=next;
//			}
//		}
//		System.out.println(longestWord);
		
		
		
		
//		sc.close();
//		bufferedWriter.close();
		bufferedReader.close();
//		writer.flush();
//		writer.close();
		bufferedReader.close();
//		fis.close();
	}

}
