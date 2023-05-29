package appscripprep;

import java.util.HashSet;

public class SubArraySum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solve2(new int[] { 5, 6, 2, 4, 5, 7, 3 }, 10);
	}

//	 Qn-1  program to find pair of subarray which is equals to given sum/target
	
	
	// Time complex- O(N2)
	public static void solve1(int[] arr, int target) {
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] + arr[j] == target) {
					System.out.println(arr[i] + ", " + arr[j]);
				}
			}
		}
	}

	// Time complex-    O(N)
	//Space complexity  O(N)
	public static void solve2(int[] arr, int target) {
		HashSet<Integer> set = new HashSet<>();
		for (int i = 0; i < arr.length; i++) {
			int diff=target-arr[i];
			if(set.contains(diff)) {
				System.out.println(diff + ", "+arr[i]);
			}
			set.add(arr[i]);
		}

	}
	
	
}
