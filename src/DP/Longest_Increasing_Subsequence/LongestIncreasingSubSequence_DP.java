/*
 * http://www.geeksforgeeks.org/dynamic-programming-set-3-longest-increasing-subsequence/
 * Time complexity= O(n^2)
 * Space complexity= O(n)
 */
package DP.Longest_Increasing_Subsequence;

import java.util.Arrays;

public class LongestIncreasingSubSequence_DP {

	public static void main(String[] args) {
		int[] arr={ 10, 22, 9, 33, 21, 50, 41, 60 };
		int len=find_length(arr);
		System.out.println("The length of longest subsequence is "+len);
	}
	private static int find_length(int[] arr)
	{
		int len=arr.length,max=0;
		if(len==0)
			return 0;
		int[] buffer=new int[len];
		Arrays.fill(buffer, 1);
		for(int i=1;i<len;i++)
			for(int j=0;j<i;j++)
			{
				//here in buffer array, we are adding 1 to the position, because we are just interested
				//in finding in longest subsequence length rather than sum.If in we need to find max sum
				//we will put max sum in buffer array
				if(arr[j]<arr[i]&&buffer[i]<buffer[j]+1)
				{
					buffer[i]=buffer[j]+1;
					if(buffer[i]>max)
						max=buffer[i];
				}
			}
		for(int j=0;j<len;j++)
			System.out.print(buffer[j]+" ");
		return max;
	}
}
