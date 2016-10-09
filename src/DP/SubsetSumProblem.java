package DP;/*
 * http://www.geeksforgeeks.org/dynamic-programming-subset-sum-problem/
 */


import java.util.ArrayList;
public class SubsetSumProblem {

	public static void main(String[] args)
	{
		int[] arr={2,3,7,8,10};//={3, 34, 4, 12, 5, 2};//
		int sum=11;
		boolean status =isPrsent(arr,sum);
		System.out.println(status);
	}
	private static boolean isPrsent(int[] arr,int sum)
	{
		int n=arr.length;
		if(n==0)
			return false;
		boolean sumArray[][]=new boolean[n][sum+1];
		for(int i=0;i<n;i++)
			sumArray[i][0]=true;
		sumArray[0][arr[0]]=true;
		for(int i=1;i<n;i++)
		{
			for(int j=1;j<=sum;j++)
			{
				if(arr[i]>j)
					sumArray[i][j]=sumArray[i-1][j];
				else if(arr[i]==j)
					sumArray[i][j]=true;
				else
					sumArray[i][j]=sumArray[i-1][j]||sumArray[i-1][j-arr[i]];
			}
		}
		if(sumArray[n-1][sum])
			printPath(sumArray,arr);
		return sumArray[n-1][sum];
	}
	private static void printPath(boolean[][] sumArray,int arr[])
	{
		ArrayList<Integer> num=new ArrayList<Integer>();
		int col=sumArray[0].length-1;
		int row=sumArray.length-1;
		while(col>0&&row>0)
		{
			if(sumArray[row][col]==sumArray[row-1][col])
				row--;
			else
			{
				num.add(0,arr[row]);
				col=col-arr[row];
				row--;
			}
		}
		System.out.println(num);
	}
}
