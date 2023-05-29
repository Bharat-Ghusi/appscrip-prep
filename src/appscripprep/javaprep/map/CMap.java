package appscripprep.javaprep.map;

import java.util.HashMap;
import java.util.Map;

public class CMap {
	public static void main(String[] args) {
		solve1();
	}
	
	//HashMap
	public static void solve1() {
		HashMap<String, Integer> map = new HashMap<>();
		map.put("India", 91);
		map.put("America", 34);
		map.put("China", 56);
		
		for(Map.Entry<String, Integer> entry:map.entrySet()) {
			System.out.println(entry.getKey()+" : "+entry.getValue());
		}
	}
}
