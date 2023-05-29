package appscripprep.javaprep.assignment;

import java.util.ArrayList;
import java.util.Collections;

public class SortStudent {

	public static void main(String[] args) {
		ArrayList<Student> list = new ArrayList<>();
		list.add(new Student(1, 80, 78, 5));
		list.add(new Student(2, 70, 78, 5));
		list.add(new Student(3, 60, 78, 5));
		list.add(new Student(4, 50, 78, 5));
		list.add(new Student(1, 40, 78, 5));
		Collections.sort(list,new MathComparator());
		System.out.println(list);
	}

}
