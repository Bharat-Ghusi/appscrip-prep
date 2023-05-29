package appscripprep.javaprep.sort;

import java.util.Arrays;

public class MergeSortP {
	public static void mergeSort(int[] arr,int start,int end) {
		if(start < end) { //Base condition: when there is one element.
//			int mid=start+(end-start)/2;
			int mid=(start+end)/2;
			mergeSort(arr, start, mid);//left
			mergeSort(arr, mid+1, end);//right
			
			merge(arr,start,mid,end);
		}
	}

	private static void merge(int[] arr, int start, int mid, int end) {
		int aSize=start-mid+1;
		int bSize=end-mid;
		int[] left=new int[aSize];
		int[] right=new int[bSize];
		
		//set left array element
		for (int i = 0; i < left.length; i++) {
			left[i]=arr[start+i];
		}
		//set right array element
		for (int i = 0; i < right.length; i++) {
			right[i]=arr[mid + 1 + i];
		}
		
		//Now compare left and right and swap it original array.
		int index=start; //original array index
		int i=0;//left index
		int j=0;//right index
		
		while(i < left.length && j < right.length) {
			if(left[i] < right[j]) {
				arr[index]=left[i];
				i++;
			}
			else {
				arr[index]=right[j];
				j++;
			}
			index++;
		}
		//Check if any of the array is smaller then place remaining element in original array
		while(i < left.length) {
			arr[index]=left[i];
			i++;
			index++;
		}
		
		while( j< right.length) {
			arr[index]=right[j];
			j++;
			index++;
		}
		
		
		
	}

	public static void main(String[] args) {
		int[] arr= {12,1,13,5,6,7};
		mergeSort(arr , 0, 5);
		System.out.println(Arrays.toString(arr));
	}

}
