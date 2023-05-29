package appscripprep.javaprep.general;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class UnionOfTwoArrays {
//	Using Map 
//	Expected Time Complexity : O(n+m)
//	Expected Auxiliary Space : O(n+m)
	public static int solve1(int[] a,int n,int[] b,int m) {
		HashMap<Integer, Integer> map = new HashMap<>();
		//O(M)
		for (int i = 0; i < n; i++) {
			if(! map.containsKey(a[i])) {
				map.put(a[i], 1);
			}
			
		}
		//O(N)
		for (int i = 0; i < m; i++) {
			if(! map.containsKey(b[i])) {
				map.put(b[i],1);
			}
			
		}
		//logic
		return map.size();
	}
	//Merge sort O(n logn)
	public static int[] mergeSort(int[] arr) {
		//Base case
		if(arr.length == 1) {
			return arr;
		}
		int mid=arr.length/2;
		int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));
		int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));
		return merge(left,right);
	}
	
	//Merge sort O(n)
	public static int[] merge(int[] left,int[] right) {
		int[] mix=new int[left.length + right.length];
		int i=0,j=0,k=0;
		while(i < left.length && j < right.length) {
			if(left[i] < right[j]) {
				mix[k]=left[i];
				i++;
			}
			else {
				mix[k]=right[j];
				j++;
			}
			k++;
		}
		//It may be possible that one array is grater, run above loop one more time
		while(i < left.length) {
			mix[k]=left[i];
			i++;
			k++;
		}
		while(j < right.length) {
			mix[k]=right[j];
			j++;
			k++;
		}
		return mix;
	}
	//Using merge Sorting O(n+m log n+m)
	public static int doUnion(int[] a,int n, int[] b,int m) {
		a=mergeSort(a); // O(n logn)
		b=mergeSort(b); //O(n logn)
		int i=0,j=0,count=0;
		while(i < n && j < m) { // O(M+N)
			if(i+1 < n && a[i] == a[i+1]) {
				i++;
				continue;
			}
			if(j+1 < m && b[j] == b[j+1]) {
				j++;
				continue;
			}
			if(a[i] < b[j]) {
				count++;
				i++;
			}
			else if(a[i] > b[j]) {
				count++;
				j++;
			}
			else {// a[i] == b[j]
				i++;
				j++;
				count++;
			}
		}
		if(i < n) {
			count +=n-i;
		}
		if(j<m) {
			count +=m-j;
		}
		
		return count;
	}
	
	
	//Using Set
	// O(N+M)
	public static int  solve3(int[] a,int n,int[] b,int m) {
		Set<Integer> set = new HashSet<>();
		for(int num:a) { //O(N)
			set.add(num);
		}
		for(int num:b) {//O(N+M)
			set.add(num);
		}
		return set.size();
		
	}
	//Without using collection,sorting
//	Expected Time Complexity : O(N*M)
//	Expected Auxilliary Space : O(n+m)
	public static int solve4(int[] a,int n,int[] b,int m) {
		int[] union=new int[n+m];
		boolean isPresent=false;
		int index=0;
		for (int i = 0; i < a.length; i++) {//O(N)
			union[index++]=a[i];
		}
		for (int i = 0; i < b.length; i++) {//O(N*M)
			isPresent=false;
			for (int j = 0; j < a.length; j++) {
				if(b[i] == a[j]) {
					isPresent=true;
					break;
				}
			}
			if(! isPresent) {
				union[index++]=b[i];
			}
		}
		return index;
		
	}
	
	public static void main(String[] args) {
		int[] arr1= {85 ,25, 1, 32, 54, 6};
		int[] arr2= {85,2};
//		//1-Using map
//		System.out.println(solve1(arr1, arr2));
		
		//2- Using merge sort O(mlogn)
//		System.out.println(doUnion(arr1,6, arr2,2));
		
		//3-Using set
//		System.out.println(solve3(arr1, 7, arr2, 2));
		
		//Without using collection
		System.out.println(solve4(arr1, 5, arr2, 3));
		
	}

}
