//http://www.geeksforgeeks.org/dynamic-programming-set-3-longest-increasing-subsequence/
package DP.Revision;

import java.util.ArrayList;
import java.util.Arrays;

public class LIS_n2 
{
	public static void main(String[] args) 
	{
		int arr[]={ 10, 22, 9, 33, 21, 50, 41, 60 };
		find_LIS(arr);
	}
	private static void find_LIS(int[] arr)
	{
		int n=arr.length;
		int[] parent=new int[n];
		Arrays.fill(parent,-1);
		int LIS[]=new int[n];
		Arrays.fill(LIS,1);
		for(int i=1;i<n;i++)
			for(int j=0;j<i;j++)
				if(arr[i]>arr[j]&&LIS[i]<LIS[j]+1)
				{
					LIS[i]=LIS[j]+1;
					parent[i]=j;//It is this way not parent[j]=i;
				}
		int max=0,end=-1;
		for(int i=0;i<n;i++)
			if(max<LIS[i])
			{
				max=LIS[i];
				end=i;
			}
		System.out.println("Max length is "+max);
		ArrayList<Integer> res=new ArrayList<Integer>();
		while(end!=-1)
		{
			res.add(0,arr[end]);
			end=parent[end];
		}
		System.out.println(res);
	}
}
