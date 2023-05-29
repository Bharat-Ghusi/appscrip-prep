package appscripprep.practice.array;

public class KadaneAlgorithm {
	
	//Optimize one O(N)
	public static long maxSubarraySum(int[] arr,int n) {
		int max=Integer.MIN_VALUE;
		int sum=0;
		for (int i = 0; i < arr.length; i++) {
			sum +=arr[i];
			if(sum > max) {
				max=sum;
			}
			if(sum < 0) {
				sum=0;
			}
		}
		return max;
	}

	public static void main(String[] args) {
//		int[] arr={1,2,3,-2,5};
//		int[] arr= {-1,-2,-3,-4};
		int[] arr= {-10,5,3};
		System.out.println(maxSubarraySum(arr, arr.length));
		
		/*
		 * Given an array Arr[] of N integers. Find the contiguous 
		 * sub-array(containing at least one number) which has the maximum sum and return its sum.
		 */
	}

}
