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
		int[] arr={-2, -3, 4, -1, -5, 2, -1,5, -3,-10};//{-1,-3,-2,-2, -3};//5,-6,1};//{-1,-1,-1,-1};//)
		ArrayList<Integer> res=Kadane(arr);
		if(res==null)
			System.out.println("\nno element ");
		else {
			for (int k = res.get(0); k <= res.get(1); k++)
				System.out.print(arr[k] + "   ");
			System.out.println("\nThe maximum sum is " + res.get(2));
		}
	}
	static ArrayList<Integer>  Kadane(int[] arr)
	{
		int maxSum=0,currMaxSum=0;
		int start=-1,max_end=-1,max_start=-1;
		for(int i=0;i<arr.length;i++)
		{
			currMaxSum=currMaxSum+arr[i];
			if(currMaxSum<0)
			{
				currMaxSum=0;
				start=-1;
			}
			else if(start<0)
				start=i;
			if(maxSum<currMaxSum)
			{
				max_start=start;
				maxSum=currMaxSum;
				max_end=i;
			}
		}
		if(maxSum<=0)
			return null;
		ArrayList<Integer> res=new ArrayList<Integer>();
		res.add(max_start);
		res.add(max_end);
		res.add(maxSum);
		return res;
	}
}
