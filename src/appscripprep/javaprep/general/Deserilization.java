package appscripprep.javaprep.general;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Deserilization {

	public static void main(String[] args) {
		try {
			FileInputStream fin = new FileInputStream("student1.ser");
			ObjectInputStream oin = new ObjectInputStream(fin);
			Object student1 = oin.readObject();
			System.out.println(student1);
			oin.close();
			fin.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
