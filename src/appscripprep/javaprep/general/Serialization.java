package appscripprep.javaprep.general;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Serialization {

	public static void main(String[] args) {
			Student s1 = new Student(2, "Avilash",48268216);
			FileOutputStream fos=null;
			ObjectOutputStream oos=null;
			try {
				fos = new FileOutputStream("student1.ser");
				oos = new ObjectOutputStream(fos);
				//Serializing student object
				oos.writeObject(s1);
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			finally {
				try {
					oos.close();
					fos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println("Serialized done");
	}
	

}
