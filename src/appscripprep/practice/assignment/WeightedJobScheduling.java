package appscripprep.practice.assignment;

import java.util.Arrays;

class Job implements Comparable<Job>{
	 int sTime;
	 int fTime;
	 int profit;
	public Job() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Job(int sTime, int fTime, int profit) {
		super();
		this.sTime = sTime;
		this.fTime = fTime;
		this.profit = profit;
	}
	@Override
	public int compareTo(Job o) {
		return this.fTime-o.fTime;
	}
}

//-------------//
public class WeightedJobScheduling {
	//Method to get not overlapped job
	public static int getNotOverlappedJob(Job[] jobs,int end) {
		for (int start = 0; start < end; start++) {
			if(jobs[start].fTime <= jobs[end].sTime) return start;
		}
		return -1;
	}
	
	public static int findMaxProifit(Job[] jobs,int size) {
		//Case-1 Sort in ascending order
		Arrays.sort(jobs);
		int maxProfit=0;
		for (int i = jobs.length-1; i > 0; i--) {
			int notOverlappedJob = getNotOverlappedJob(jobs, i);
			if(notOverlappedJob != -1) {
				int sum=jobs[notOverlappedJob].profit + jobs[i].profit ;
				if(sum > maxProfit) {
					maxProfit=sum;
				}
			}
			
		}
		return maxProfit;
	}

	public static void main(String[] args) {
		Job[] jobs=new Job[4];
		jobs[0]=new Job(1, 2, 50);
		jobs[1]=new Job(3, 5, 20);
		jobs[2]=new Job(6, 19, 100);
		jobs[3]=new Job(2, 100, 200);
		
		findMaxProifit(jobs,jobs.length);
	}

}
