package DP;

import java.util.ArrayList;

/*
 * Kadane algo : this is wise algo used to find maximum sum in 1D array in linear time
 * http://www.geeksforgeeks.org/largest-sum-contiguous-subarray/
 * Time complexity =O(n)
 */

public class Kadane_Algo {
	public static void main(String[] args)
	{
		int[] arr={-1,3,-2,5,-6,1};//{-2, -3, 4, -1, -2, 1, 5, -3,6};
		ArrayList<Integer> res=Kadane(arr);
		for(int k=res.get(0);k<=res.get(1);k++)
			System.out.print(arr[k]+"   ");
		System.out.println("\nThe maximum sum is "+res.get(2));
	}
	 static ArrayList<Integer>  Kadane(int[] arr)
	{
		int maxSum=0,currMaxSum=0;
		int start=-1,end=-1;
		for(int i=0;i<arr.length;i++)
		{
			currMaxSum=currMaxSum+arr[i];
			if(currMaxSum<0)
			{
				currMaxSum=0;
				start=-1;
				continue;
			}
			else if(start<0)
					start=i;
			if(maxSum<currMaxSum)
			{
				maxSum=currMaxSum;
				end=i;
			}
		}
		if(maxSum<=0)
			return null;
		ArrayList<Integer> res=new ArrayList<Integer>();
		res.add(start);
		res.add(end);
		res.add(maxSum);
		return res;
	}
}
