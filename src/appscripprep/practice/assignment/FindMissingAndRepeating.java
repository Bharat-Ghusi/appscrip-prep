package appscripprep.practice.assignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class FindMissingAndRepeating {
	static int[] findTwoElement(int arr[], int n) {
		if(arr.length < 2) {
			return new int[] {-1,-1};
		}
		for (int i = 0; i < n; i++) {
			int check=arr[i]-1;
			if(arr[i] != i+1) {
				if(arr[check] != arr[i]) {
					swap(arr,i,check);
				}
				else {
					return new int[] {arr[i],i+1};
				}
			}
		}
		return new int[] {-1,-1};
    }
	
	//TC: O(N)
	//SC: O(-1)
	public static void solve1(int arr[], int n) {
		int currSum=0; 
		int origSum=0; // N * (N-1)/2
		for (int i = 0; i < arr.length; i++) {
			
		}
	}

	private static void swap(int[] arr, int a, int b) {
		int temp=arr[a];
		arr[a]=arr[b];
		arr[b]=temp;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(findTwoElement(new int[] {13, 33 ,43 ,16 ,25 ,19 ,23 ,31 ,29 ,
				35 ,10 ,2 ,32 ,11 ,47 ,15 ,34 ,46 ,30 ,26 ,41 ,18 ,5 ,17 ,37 ,39 ,6 ,4 ,20 ,27 ,9 ,3 ,8 ,40 ,24 ,44 ,
				14 ,36 ,7 ,38 ,12 ,1 ,42 ,12 ,28 ,22 ,45}, 47)));
		
		int[]arr={13, 33 ,43 ,16 ,25 ,19 ,23 ,31 ,29 ,
				35 ,10 ,2 ,32 ,11 ,47 ,15 ,34 ,46 ,30 ,26 ,41 ,18 ,5 ,17 ,37 ,39 ,6 ,4 ,20 ,27 ,9 ,3 ,8 ,40 ,24 ,44 ,
				14 ,36 ,7 ,38 ,12 ,1 ,42 ,12 ,28 ,22 ,45};
		
		List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
		Collections.sort(list);
		System.out.println(list);
		
	}

}
