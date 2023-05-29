package appscripprep.javaprep.sort;

import java.util.Arrays;

public class Sorting {
	
//	Bubble sort
	public static void bubbleSort(int[] arr) {
		for (int i = 0; i < arr.length-1; i++) {
			for (int j = 0; j < arr.length-i-1; j++) {
				if(arr[j] > arr[j+1]) {
					swap(arr,j,j+1);
				}

			}
		}
		
		System.out.println(Arrays.toString(arr));
	}

	private static void swap(int[] arr, int i, int j) {
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
	
//	Insertion sort
	public static void insertionSort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			for (int j = i; j >0; j--) {
				if(arr[j] < arr[j-1]) {
					swap(arr, j, j-1);
				}
				//It means arr[j] is > all of its left side elements bcoz left side of array is sorted in ascending orderN
				else {
					break;
				}
			}
		}
		System.out.println(Arrays.toString(arr));

	}
	
	//QuickSort
	//TIme complex: O(n logn)
	public static void quickSort(int[] arr,int lo,int hi) {
		if(lo >= hi)return;
		int s=lo;
		int e=hi;
		int mid=s+(e-s)/2;
		int pivot=arr[mid];
		while(s <= e) {
			while(arr[s] < pivot) {
				s++;
			}
			while(arr[e] > pivot) {
				e--;
			}
			if(s <= e) {
				swap(arr, s, e);
				s++;
				e--;
			}
		}
		quickSort(arr, lo, e);
		quickSort(arr, s, hi);
		
	}
	//Selection sort
	public static void selectionSort(int[] arr) {
		
		for (int i = 0; i < arr.length; i++) {
			int last=arr.length - i - 1;
			int max = findMax(arr,0,last);
			swap(arr, max, last);
		}
	}

	private static int findMax(int[] arr, int start, int end) {
		int max=start;
		for(int i=start;i<= end;i++) {
			if(arr[i] > arr[max]) {
				max=i;
			}
		}
		return max;
	}

	public static void main(String[] args) {
		int[] arr=  {3,1,5,2,4};
		selectionSort(arr);
		System.out.println(Arrays.toString(arr));
	}

}
