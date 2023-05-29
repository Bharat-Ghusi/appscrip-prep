package appscripprep.practice.array;

import java.util.Arrays;
import java.util.Iterator;
import java.util.TreeSet;

public class KthSmallestElement {
	//Using TreeSet
//	Expected Time Complexity: O(n)
//	Expected Auxiliary Space: O(n)
	 public static int kthSmallest(int[] arr, int l, int r, int k) 
	    { 
		 	TreeSet<Integer> treeSet = new TreeSet<>();
		 	for (int i = 0; i < arr.length; i++) { //O(N)
				treeSet.add(arr[i]);
			}
		 	Iterator<Integer> itr = treeSet.iterator();
		 	while(k > 1) {
		 		itr.next();
		 		k--;
		 	}
		 	
			return itr.next();
	    } 
	 
	 //Using Quick select
//	Expected Time Complexity: O(n)
//	Expected Auxiliary Space: O(1)
	 /*
	  * Initialize the left pointer (l) as 0 and the right pointer (r) as the size of the array minus 1: l = 0, r = N - 1.
Repeat the following steps until l is less than or equal to r:
a. Select a pivot element from the array. You can choose the pivot randomly or use any other strategy.
b. Partition the array by rearranging its elements such that all elements smaller than the pivot are on the left side, and all elements greater than the pivot are on the right side. Let the index of the pivot element after partition be pi.
c. If pi is equal to K - 1, return the element at index pi (arr[pi]) as the Kth smallest element.
d. If pi is less than K - 1, set l = pi + 1 and go to step 2.
e. If pi is greater than K - 1, set r = pi - 1 and go to step 2.
If the algorithm reaches this point, return -1 or any other appropriate value to indicate that the Kth smallest element was not found.
	  */
	 public static int kthSmallest1(int[] arr, int l, int r, int k) 
	 { 
		while(l <= r) {
			int position = findPivotSortedPosition(arr, l, r);
			if(position < k-1) {
				l=position+1;
			}
			else if(position > k-1) {
				r=position-1;
			}
			else {
				return arr[position];
			}
		}
		 return -1;
	 } 
	 public static int findPivotSortedPosition(int[] arr,int left,int right) {
		int pivotIndex=left+(right-left)/2;
		int pivot=arr[pivotIndex];
		//Swap pivot with last item
		swap(arr,pivotIndex , right);
		int index=left;
		for (int i = left; i < right; i++) {
			if(arr[i] < pivot) {
				swap(arr, index, i);
				index++;
			}
		}
		//At the end we will get partition index, swap with right element
		// Move pivot to its sorted position
		swap(arr, index, right);
		return index;
	}
	 
	 public static void swap(int[] arr,int a,int b) {
		int temp=arr[a];
		arr[a]=arr[b];
		arr[b]=temp;
		
	}
	 
	public static void main(String[] args) {
		int arr[]= {7 ,10 ,4 ,3 ,20 ,15};
		System.out.println(kthSmallest(arr, 0, arr.length-1, 3));
	}

}
