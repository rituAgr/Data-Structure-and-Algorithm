/*
 * http://www.geeksforgeeks.org/weighted-job-scheduling-log-n-time/
 * https://www.youtube.com/watch?v=cr6Ip0J9izc
 */
package DP.Longest_Increasing_Subsequence;

import java.util.Arrays;
import java.util.HashMap;

public class WeightedJobScheduling
{
	public static void main(String[] args) 
	{
		Job[] jobs=new Job[6];
		jobs[0] = new Job(1,3,5);
		jobs[1] = new Job(2,5,6);
		jobs[2] = new Job(4,6,5);
		jobs[3] = new Job(6,7,4);
		jobs[4] = new Job(5,8,11);
		jobs[5] = new Job(7,9,2);
		jobSchedule(jobs);
	}
	private static class Job implements Comparable<Job>
	{
		int startTime,endTime,profit;
		Job(int st,int e, int p)
		{
			startTime=st;
			endTime=e;
			profit=p;
		}
		@Override
		public int compareTo(Job j) {
			return this.endTime-j.endTime;
		}
	}
	private static void jobSchedule(Job[] jobs)
	{
		int n=jobs.length;
		int maxprofit=-1;
		Arrays.sort(jobs);
		for(int i=1;i<n;i++)
		{
			int profit=jobs[i].profit;
			for(int j=0;j<i;j++)
				if(jobs[j].profit+jobs[i].profit>profit)	
				{
					profit=jobs[j].profit+jobs[i].profit;
					if(maxprofit<profit)
						maxprofit=profit;
				}
		}
		System.out.println(maxprofit);
	}
}
