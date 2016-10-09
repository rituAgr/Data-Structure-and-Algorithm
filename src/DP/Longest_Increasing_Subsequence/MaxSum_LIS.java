/*
 * http:http://www.geeksforgeeks.org/dynamic-programming-set-14-maximum-sum-increasing-subsequence/
 * Time complexity = O(n^2)
 * Space complexity = O(n)
 * video : https://www.youtube.com/watch?v=99ssGWhLPUE
 */
package DP.Longest_Increasing_Subsequence;
import java.util.ArrayList;
public class MaxSum_LIS {

	public static void main(String[] args) {
		int[] arr={1, 101, 2, 3, 100, 4, 5};
		find(arr);
	}
	private static void find(int[] arr)
	{
		int n=arr.length;
		int buffer[]=new int[n];
		int pos[]=new int[n];//this array is just to tract down the elements that form MaxSum Subsequence
		for(int i=0;i<n;i++)
		{
			buffer[i]=arr[i];
			pos[i]=i;
		}
		int maxSum=Integer.MIN_VALUE;
		int maxSumPos=Integer.MIN_VALUE;
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<i;j++)
			{
				if(arr[j]>=arr[i])
					continue;
				if(arr[i]+buffer[j]>buffer[i])
				{
					buffer[i]=arr[i]+buffer[j];
					pos[i]=j;
				}
			}
			if(buffer[i]>maxSum)
			{
				maxSum=buffer[i];
				maxSumPos=i;
			}
		}	
		ArrayList<Integer> res=new ArrayList<Integer>();
		while(buffer[maxSumPos]!=arr[maxSumPos])
		{
			int s=arr[maxSumPos];
			res.add(0,s);
			maxSumPos=pos[maxSumPos];
		}
		res.add(0,arr[maxSumPos]);
		System.out.println("Sum is "+maxSum);
		System.out.println("Elements are "+res.toString());
	}
}
