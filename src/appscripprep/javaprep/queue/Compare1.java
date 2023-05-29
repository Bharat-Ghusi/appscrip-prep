package appscripprep.javaprep.queue;

import java.util.Comparator;

public class Compare1 implements Comparator<Student>{

	@Override
	public int compare(Student o1, Student o2) {
		return (o1.getId() < o2.getId())? 1:0;
	}
	

}
