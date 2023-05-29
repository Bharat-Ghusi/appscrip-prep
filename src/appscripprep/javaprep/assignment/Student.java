package appscripprep.javaprep.assignment;

public class Student {
	private int id;
	private int math;
	private int eng;
	private int hindi;
	public Student(int id, int math, int eng, int hindi) {
		super();
		this.id = id;
		this.math = math;
		this.eng = eng;
		this.hindi = hindi;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getHindi() {
		return hindi;
	}
	public void setHindi(int hindi) {
		this.hindi = hindi;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", math=" + math + ", eng=" + eng + ", hindi=" + hindi + "]";
	}
	
}
