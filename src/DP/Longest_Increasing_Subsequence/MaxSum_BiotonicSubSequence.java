package DP.Longest_Increasing_Subsequence;

import java.util.ArrayList;
import java.util.Arrays;

public class MaxSum_BiotonicSubSequence {

	public static void main(String[] args) {
		int arr[] = {1, 11, 2, 10, 4, 5, 2, 1};
		find(arr);
	}
	private static void find(int[] arr)
	{
		int n=arr.length;
		if(n==0)
			return ;
		int[] buffer1=new int[n];
		int[] buffer2=new int[n];
		int[] pos1=new int[n];
		int[] pos2=new int[n];
		Arrays.fill(pos1, 1);
		Arrays.fill(pos2, 1);
		for(int k=0;k<n;k++)
		{
			buffer1[k]=arr[k];
			buffer2[k]=arr[k];
		}
		for(int i=1;i<n;i++)
		{
			for(int j=0;j<i;j++)
			{
				if(arr[j]>=arr[i])
					continue;
				if(arr[i]+buffer1[j]>buffer1[i])
					{
					buffer1[i]=arr[i]+buffer1[j];
					pos1[i]=j;
					}
			}
		}
		for(int i=n-2;i>=0;i--)
		{
			for(int j=n-1;j>i;j--)
			{
				if(arr[j]>=arr[i])
					continue;
				if(arr[i]+buffer2[j]>buffer2[i])
					{
					buffer2[i]=arr[i]+buffer2[j];
					pos2[i]=j;
					}
			}
		}
		int max=-1,position=-1;
		for(int k=0;k<n;k++)
			if(buffer1[k]+buffer2[k]>max)
				{
				max=buffer1[k]+buffer2[k];
				position=k;
				}
		ArrayList<Integer> res=new ArrayList<Integer>();
		int position1=position;
		max=max-arr[position];
		while(buffer1[position]!=arr[position])
		{
			res.add(0,arr[position]);
			position=pos1[position];
		}
		res.add(0,arr[position]);
		while(buffer2[position1]!=arr[position1])
		{
			position1=pos2[position1];
			res.add(arr[position1]);
			//position1=pos2[position1];
		}
		System.out.println("Max sum Biotonic Subsequence is "+(max));
		System.out.println("Longest Biotonic Subsequence is "+res.toString());
	}

}
