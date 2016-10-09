/*
 * http://www.geeksforgeeks.org/longest-monotonically-increasing-subsequence-size-n-log-n/
 * Time complexity : O(nlogn)
 */
package DP.Revision;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class LIS_nlogn 
{
	public static void main(String[] args)
	{
		int[] arr={ 2, 7, 3, 5, 11, 8, 10, 13, 6 };
		//The below comment code is to show original array
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]+"   ");
		System.out.println();
		LIS(arr);
	}
	private static void LIS(int[] arr)
	{
		int n=arr.length;
		int[] parent=new int[n];
		Arrays.fill(parent, -1);
		int[] array=new int[n];//array[] is going to store result
		array[0]=0;
		int len=1;
		for(int i=1;i<n;i++)
		{
			if(arr[i]<arr[array[0]])
				array[0]=i;
			else if(arr[i]>arr[array[len-1]])
			{ 
				array[len]=i;
				parent[array[len]]=array[len-1];
				len++;
			}
			else
			{
				int ceil=ceilIndex(array,arr,len-1,arr[i]);
				array[ceil]=i;
				parent[array[ceil]]=array[ceil-1];
			}
		}
		//The below comment code is to figure out how array[] is filled
		for(int i=0;i<len;i++)
			System.out.print(array[i]+"   ");
		System.out.println();
		
		//The below comment code is to figure out how parent array is filled
		for(int i=0;i<arr.length;i++)
			System.out.println(i+" -> "+parent[i]);
		
		System.out.println("\n\nThe maximum length is "+len);
				
		//printing
		ArrayList<Integer> res=new ArrayList<Integer>();
		int curr=array[len-1];//to be precise to index manipulation further
		while(parent[curr]!=-1)
		{
			res.add(0,arr[curr]);
			curr=parent[curr];
		}
		res.add(0,arr[curr]);
		for(int i:res)
			System.out.print(i+" ");
	}
	private static int ceilIndex(int[] array,int arr[], int right,int key)
	{
		int left=0;
		int end=right;
		while(left<=right)
		{
			int mid=left+(right-left)/2;
			if(mid<end&&arr[array[mid]]<key&&arr[array[mid+1]]>=key)
				return mid+1;
			if(arr[array[mid]]<key)
				left=mid+1;
			else
				right=mid-1;
		}
		return -1;
	}
}
