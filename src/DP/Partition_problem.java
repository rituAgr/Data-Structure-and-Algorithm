package DP;

import java.util.Arrays;

/*
 *http://www.geeksforgeeks.org/dynamic-programming-set-18-partition-problem/
 * Time complexity = O(n)
 * Space complexity= O(n) 
 * It did this myself. No geeksforgeeks or tushar roy video. Geeksforgeeks video has O(n^2) time complexity
 */
public class Partition_problem 
{
	public static void main(String[] args)
	{
		int[] arr={3, 1, 1, 2, 2, 1};
		Arrays.sort(arr);
		find_partition(arr);
	}
	private static void find_partition(int[] arr)
	{
		int n=arr.length;
		if(n==0||n==1)
			System.out.println("Partition not possible");
		int[] sum1=new int[n];
		int sum2[]=new int[n];
		int sum=0;
		for(int i=0;i<n;i++)
		{
			sum1[i]=sum+arr[i];
			sum=sum1[i];
		}
		sum=0;
		for(int i=n-1;i>=0;i--)
		{
			sum2[i]=sum+arr[i];
			sum=sum2[i];
		}
		for(int i=0;i<n-1;i++)
			if(sum1[i]==sum2[i+1])
			{
				System.out.println("Partition 1 : ");
				printarray(arr,0,i);
				System.out.println("\nPartition 2 : ");
				printarray(arr,i+1,n-1);
				return;
			}
		System.out.println("Partition not possible");
	}
	private static void printarray(int[] arr,int i, int j)
	{
		for(int k=i;k<=j;k++)
			System.out.print(arr[k]+" ");
	}
}
