package appscripprep.javaprep.assignment;

import java.util.Comparator;

public class MathComparator implements Comparator<Student>{

	@Override
	public int compare(Student o1, Student o2) {
		
		return o1.getMath()-o2.getMath();
	}

}
