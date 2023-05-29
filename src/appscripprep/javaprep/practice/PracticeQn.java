package appscripprep.javaprep.practice;

import java.util.ArrayList;
import java.util.Collections;

public class PracticeQn {
//	Take 5 element in arraylist and check positon of one of the element.
	public static void solve1() {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		System.out.println(list.indexOf(4));
	}
	
//	Take 5 string name and sort them alphabetically with first Character. 
	public static void solve2() {
		ArrayList<String> list = new ArrayList<>();
		list.add("Kunal");
		list.add("Avilash");
		list.add("Bharat");
		list.add("Ghusi");
		Collections.sort(list);
		System.out.println(list);
		
	}
	
	
	public static void main(String[] args) {
		solve2();
	}
}
