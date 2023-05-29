package appscripprep.practice.array;

import java.util.Arrays;

public class TripletSum {
	public static  void solve1(int[] arr) {
		for (int i = 0; i < arr.length-2; i++) {
			for (int j =i+1 ; j < arr.length-1; j++) {
				for (int k = j+1; k < arr.length; k++) {
					int sum=arr[i]+arr[j]+arr[k];
					if(sum == 0) {
						System.out.println(i+" "+j+" "+ k);
					}
				}
			}
		}
	}
	
	//Sort O(N^2)
	public static void solve2(int[] arr) {
		Arrays.sort(arr); // (log n)
		for (int i = 0; i < arr.length-2; i++) { //N-3
			int j=i+1;
			int k=arr.length-1;
			while(j<k) { // (N-2)/2
				int sum=arr[i]+arr[j]+arr[k];
				if(sum == 0) {
					System.out.println(arr[i]+" "+arr[j]+" "+arr[k]);
					j++;
					k--;
					//Ignore duplicates
					while(j < k && arr[j] == arr[j-1]) {
						j++; 
					}
					while(j<k && arr[k]==arr[k+1] ) {
						k--;
					}
					
				}
				else if(sum  < 0) {
					j++;
				}
				else { //Sum > 0
					k--;
				}
				
			}
		}
	}
	
	public static void main(String[] args) {
		int[] arr= {1,-2,-1,0,3};
		solve2(arr);
		
	}

}
