package appscripprep.javaprep.graph;

import java.util.ArrayList;
import java.util.Arrays;

public class Test {
int value=8;
	public static void main(String[] args) {
		ArrayList<ArrayList<Test>> arr = new ArrayList<>();
		arr.add(0,new ArrayList<>());
		arr.add(new ArrayList<>());
		arr.get(0).add(new Test());
		System.out.println(arr);
		
	}
}
