package appscripprep.javaprep.sort;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class MergeMain {
	public static int[] mergeSort(int[] arr) {
		//Base Condition
		if(arr.length == 1) {
			return arr;
		}
		//Mid O(log n)
		int mid=arr.length/2;
	int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));
	int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));
	
	//O(N)
	return merge(left,right);
	}
	
	private static int[] merge(int[] left, int[] right) {
		int[] mix=new int[left.length+right.length];
		
		int i=0,j=0,k=0;//Index
		
		while(i < left.length && j < right.length) {
			if(left[i] < right[j]) {
				mix[k]=left[i];
				i++;
			}else {
				mix[k]=right[j];
				j++;
			}
			k++;
		}
		//It may be possible that one array is bigger
		//Copy remaining elements into mix
		while(i < left.length) {
			mix[k]=left[i];
			k++;
			i++;
		}
		while(j < right.length) {
			mix[k]=right[j];
			k++;
			j++;
		}
		
		return mix;
	}
	
	
	public static void main(String[] args) {
		int[] arr= {5,4,3,2,8,7,6,1};
		
		System.out.println(Arrays.toString(mergeSort(arr)));
	}

}
