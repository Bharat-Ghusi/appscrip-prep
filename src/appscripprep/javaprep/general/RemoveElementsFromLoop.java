package appscripprep.javaprep.general;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class RemoveElementsFromLoop {
	//remove element using Iterator
	public static void solve1(List<Integer> list) {
		Iterator<Integer> itr = list.iterator();
		while(itr.hasNext()) {
			if(itr.next() == 4) {
				itr.remove();
			}
		}
		System.out.println(list);
	}
	
	//Using for loop
	public static void solve2(List<Integer> list) {
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i) == 4) {
				list.remove(i);
			}
		}
		System.out.println(list);
	}
	
	
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		
		solve2(list);
		//Using Stream API
		List<Integer> collect = list.stream().filter(num -> num != 2).collect(Collectors.toList());
		System.out.println(collect);
	}
}
