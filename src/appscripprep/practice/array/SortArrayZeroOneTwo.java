package appscripprep.practice.array;

import java.util.Arrays;

public class SortArrayZeroOneTwo {
	public static void sort012(int a[], int n) {
		int left = 0;
		int mid = 0;
		int right = n - 1;
		while (mid <= right) {
			if (a[mid] == 0) {
				swap(a, left, mid);
				mid++;
				left++;
			} else if (a[mid] == 1) {
				mid++;
			} else { // mid == 2
				swap(a, mid, right);
				right--;
			}
		}

	}

	public static void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

	public static void main(String[] args) {
		int[] arr = { 0, 1, 0 };
		sort012(arr, arr.length);
		System.out.println(Arrays.toString(arr));
	}

}
