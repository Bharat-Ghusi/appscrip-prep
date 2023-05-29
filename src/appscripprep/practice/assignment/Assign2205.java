package appscripprep.practice.assignment;

import java.util.Arrays;

public class Assign2205 {
	public static int[] solve1(int[] arr,int n) {
		int currSum=0;
		int origSum=0;
		int result[] =new int[2];
		for (int i = 0; i < n; i++) {
			int currNum=Math.abs(arr[i]);
			int origIndex=currNum-1;
			if(arr[origIndex] < 0 ) {
				result[0]=currNum;//rep
			}
			arr[origIndex]=-arr[origIndex];
			currSum+=currNum;
			origSum +=i+1;
		}
		result[1]=origSum-(currSum-result[0]);
		return result;
	}
	public static void main(String[] args) {
		int[] arr= {1,2,3,4,6,7,8,9,4};
		System.out.println(Arrays.toString(solve1(arr, arr.length)));
	}

}
