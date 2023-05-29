package appscripprep.practice.assignment;

//https://practice.geeksforgeeks.org/problems/permutations-of-a-given-string2041/1
//Permutations of a given string


import java.util.ArrayList;
import java.util.List;

public class PermutationsString {
	//TC: O( N*N! )
	public static void solve1(String str, int left, int right) {
		if (left == right) {
			System.out.println(str);
			return;
		}

		for (int i = left; i < right; i++) {
			str = swap(str, left, i);
			solve1(str, left + 1, right);
			str = swap(str, left, i); //Back Tracking
		}
	}

	private static String swap(String str, int a, int b) {
		char[] arr = str.toCharArray();
		char ch = arr[a];
		arr[a] = arr[b];
		arr[b] = ch;
		return new String(arr);
	}
	//
	 public  static List<String> find_permutation(String S) {
		 List<String> list = new ArrayList<>();
		 find_permutationUtil(S, list, 0, S.length());
		 
		 return list;
	 }
	 public static void find_permutationUtil(String str,List<String> list, int left, int right) {
			if (left == right) {
				list.add(str);
				return;
			}

			for (int i = left; i < right; i++) {
				str = swap(str, left, i);
				find_permutationUtil(str, list, left+1, right);
				str = swap(str, left, i); //Back Tracking
			}
		}

	public static void main(String[] args) {
		String str="ABC";
//		solve1(str, 0, str.length());
		System.out.println(find_permutation(str));
	}

}
