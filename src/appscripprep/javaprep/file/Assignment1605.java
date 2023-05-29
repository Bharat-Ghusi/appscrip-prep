package appscripprep.javaprep.file;

import java.io.File;
import java.util.Arrays;

public class Assignment1605 {
//	2)program to print all the files and directories name for a give path
	public static void solve1() {
		File file = new File("C:\\Users\\3Embed\\eclipse-workspace\\appscripprep");
		System.out.println(Arrays.toString(file.list()));
	}
	
	//Insertion sort
		public static void insertionSort(int[] nums) {
			for (int i = 1; i < nums.length; i++) {
				for (int j = i; j > 0; j--) {
					if(nums[j] < nums[j-1]) {
						swap(nums, j, j-1);
					}
					else {
						break;
					}
				}
			}
		}

//	1)Selection sort
	public static void solve2(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			int last = nums.length - i - 1;
			int maxIndex = findMaxIndex(nums, 0, last);
			swap(nums,maxIndex, last);
		}
	}

	private static void swap(int[] nums, int i, int maxIndex) {
		int temp=nums[i];
		nums[i]=nums[maxIndex];
		nums[maxIndex]=temp;
	}

	private static int findMaxIndex(int[] nums, int lo, int hi) {
		int max = lo;
		while (lo < hi) {
			if (nums[lo] > nums[max]) {
				max = lo;
			}
			lo++;
		}
		return max;
	}
	

	public static void main(String[] args) {
		int[] arr= {5,3,1,4,2,0,-3,2,10};
		insertionSort(arr);
		System.out.println(Arrays.toString(arr));
	}
}
