package DP.Longest_Increasing_Subsequence;

import java.util.Arrays;

public class LongestBiotonicSubsequence {

	public static void main(String[] args)
	{
		int arr[] = {1, 11, 2, 10, 4, 5, 2, 1};
		int len=find(arr);
		System.out.println("Longest Biotonic Subsequence is "+len);
	}
	private static int find(int[] arr)
	{
		int n=arr.length;
		if(n==0)
			return 0;
		int[] buffer1=new int[n];
		int[] buffer2=new int[n];
		Arrays.fill(buffer1, 1);
		Arrays.fill(buffer2, 1);
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<i;j++)
			{
				if(arr[j]>=arr[i])
					continue;
				if(1+buffer1[j]>buffer1[i])
					buffer1[i]=1+buffer1[j];
			}
		}
		for(int i=n-1;i>=0;i--)
		{
			for(int j=n-1;j>i;j--)
			{
				if(arr[j]>=arr[i])
					continue;
				if(1+buffer2[j]>buffer2[i])
					buffer2[i]=1+buffer2[j];
			}
		}
		int max=-1;
		for(int k=0;k<n;k++)
			if(buffer1[k]+buffer2[k]>max)
				max=buffer1[k]+buffer2[k];
		return max-1;
	}
	
}
