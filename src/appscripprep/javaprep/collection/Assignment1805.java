package appscripprep.javaprep.collection;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Assignment1805 {
	public static void solve1(List<Integer> list) {
		list.stream().filter(e -> e % 2 == 0).forEach(e -> System.out.println(e));
	}

	public static void solve2(List<Integer> list) {
		int sum = list.stream().mapToInt(e -> e.intValue()).sum();
		list.stream().reduce(0, (a, i) -> a + i);
		System.out.println(sum);
	}

	public static void solve3(List<Integer> list) {
		list.stream().map(e -> e * 2 - 1).forEach(e -> System.out.println(e));
	}

	// Kadane's Algorithm
	static long maxSubarraySum(int arr[], int n) {
		long max=Long.MIN_VALUE;
		long sum=0;
		for (int i = 0; i < arr.length; i++) {
			sum +=arr[i];
			if(sum > max) {
				max=sum;
			}
			else if(sum < 0) {
				sum=0;
			}
		}
		return max;
	}

	public static void main(String[] args) {
//		solve3(List.of(1, 2, 3, 4, 5, 6));
		System.out.println(maxSubarraySum(new int[] {2,3,-10,3,4},5));
	}

}
