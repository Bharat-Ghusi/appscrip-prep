package appscripprep.javaprep.standards;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Standards {

	public static void main(String[] args) {
		solve1();
	}
//	Variable Scopes, Readability, and Lambda Expression
	public static void solve1() {
		Integer[] arr= {4,5,3,1,2};
		List<Integer> list = Arrays.asList(arr);
//		List<Integer> collect = list.stream().sorted().collect(Collectors.toList());
		List<Integer> collect = list.stream().sorted().filter(num -> num > 2).collect(Collectors.toList());
		System.out.println(collect);
	}
}
