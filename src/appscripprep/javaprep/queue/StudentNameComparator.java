package appscripprep.javaprep.queue;

import java.util.Comparator;

public class StudentNameComparator implements Comparator<Student>{

	@Override
	public int compare(Student o1, Student o2) {
		
		return (o1.getName().compareTo(o2.getName()));
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

}
