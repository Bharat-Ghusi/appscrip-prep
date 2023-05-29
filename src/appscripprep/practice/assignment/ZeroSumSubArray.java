package appscripprep.practice.assignment;

import java.util.HashMap;
import java.util.Map;

public class ZeroSumSubArray {
	public static long findSubarray(long[] arr ,int n) 
    {
        //Your code here
        HashMap<Long,Integer> map = new HashMap<>();
        long sum = 0;
        for(int i =0 ; i < n ; i++){
            sum = sum + arr[i];
            if(!map.keySet().contains(sum)){
                map.put(sum,1);
            }
            else{
                map.put(sum,map.get(sum)+1);
            }
        }
        long ans = 0;
        for(Map.Entry<Long,Integer> entry : map.entrySet()){
            int val = entry.getValue();
            if(entry.getKey() == 0){
                ans = ans + ( ((val)*(val+1)) / 2 );
            }
            else{
                ans = ans + ( ((val-1)*(val)) / 2 );
            }
        }
        return ans;

    }
	
	public static int countZeroSumSubarrays(long[] arr,int n) {
    Map<Integer, Integer> sumFreq = new HashMap<>();
    int sum = 0;
    int count = 0;

    // Iterate over the array
    for (int i = 0; i < n; i++) {
        sum += arr[i]; // Calculate the cumulative sum

        // If the sum is zero, increment the count
        if (sum == 0) {
            count++;
        }

        // If the same sum is already encountered before,
        // it means there is a subarray with a sum of zero
        // between the previous index and the current index.
        // So, we increment the count by the frequency of that sum.
        if (sumFreq.containsKey(sum)) {
            count += sumFreq.get(sum);
        }

        // Increment the frequency of the current sum
        // in the map by 1.
        sumFreq.put(sum, sumFreq.getOrDefault(sum, 0) + 1);
    }

    return count;
}

	public static void main(String[] args) {
		System.out.println(countZeroSumSubarrays(new long[] {6,-1,-3,4,-2,2,4,6,-12,-7} , 10));

	}

}
