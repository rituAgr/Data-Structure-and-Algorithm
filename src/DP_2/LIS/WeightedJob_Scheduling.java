package DP_2.LIS;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Ritu on 3/9/17.
 * http://www.geeksforgeeks.org/weighted-job-scheduling/
 * https://www.youtube.com/watch?v=cr6Ip0J9izc
 */
public class WeightedJob_Scheduling
{
    static class Job implements Comparable<Job>
    {
        int startTime;
        int EndTime;
        int profit;
        Job(int startTime,int EndTime,int profit)
        {
            this.startTime=startTime;
            this.EndTime=EndTime;
            this.profit=profit;
        }

        @Override
        public int compareTo(Job o) {
            return this.EndTime-o.EndTime;
        }
    }
    public static void main(String[] args)
    {
        //Job arr[] = {new Job(3, 10, 20), new Job(1, 2, 50), new Job(6, 19, 100), new Job(2, 100, 200)};
        Job jobs[] = new Job[6];
        jobs[0] = new Job(1,3,5);
        jobs[1] = new Job(2,5,6);
        jobs[2] = new Job(4,6,5);
        jobs[3] = new Job(6,7,4);
        jobs[4] = new Job(5,8,11);
        jobs[5] = new Job(7,9,2);
        find(jobs);
    }
    private static void find(Job[] arr)
    {
        Arrays.sort(arr);
        int l=arr.length;

        int[] parent=new int[l];
        Arrays.fill(parent,-1);

        int[] maxProfit=new int[l];
        for(int i=0;i<l;i++)
            maxProfit[i]=arr[i].profit;

        for(int i=1;i<l;i++)
            for(int j=0;j<i;j++)
            {
                if(arr[j].EndTime>arr[i].startTime)
                    continue;
                if((maxProfit[j]+arr[i].profit)>maxProfit[i])
                {
                    maxProfit[i]=maxProfit[j]+arr[i].profit;
                    parent[i]=j;
                }
            }
        int index=0;
        for(int i=1;i<l;i++)
            if(maxProfit[i]>maxProfit[index])
                index=i;
        System.out.println("Maximum profit is "+maxProfit[index]);
        ArrayList<Job> task=new ArrayList<>();

        while(index!=-1)
        {
            task.add(0,arr[index]);
            index=parent[index];
        }
        for(Job j:task)
            System.out.println("Job with start Time : "+j.startTime+", EndTime : "+j.EndTime+"; and the profit : "+j.profit);

    }
}
