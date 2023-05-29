package appscripprep.javaprep.general;

import java.io.Serializable;

public class Student implements Serializable {
	/**
		 * 
		 */
	private static final long serialVersionUID = 12345L;
	private int id;
	private  String name;
	private transient long acc;
	private static long aadharNo=1111;

	public int getId() {
		return id;
	}

	public long getAcc() {
		return acc;
	}

	public void setAcc(long acc) {
		this.acc = acc;
	}

	public static long getAadharNo() {
		return aadharNo;
	}

	public static void setAadharNo(long aadharNo) {
		Student.aadharNo = aadharNo;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

	public Student(int id, String name, long acc) {
		super();
		this.id = id;
		this.name = name;
		this.acc = acc;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", acc=" + acc + ", Aadhar"+aadharNo+"]";
	}

	

}
