/*
 * http://www.geeksforgeeks.org/longest-monotonically-increasing-subsequence-size-n-log-n/
 * Time complexity = O(nlogn)
 * Space complexity = O(n)
 */
package DP.Longest_Increasing_Subsequence;

public class LongestIncreasingSubSequence_Efficent {

	public static void main(String[] args) {
		int[] arr= { 10, 22, 9, 33, 21, 50, 41, 60 };//{2, 5, 3, 7, 11, 8, 10, 13, 6 };//
		int len=find_length(arr);
		System.out.println("The length of longest subsequence is "+len);
	}
	private static int find_length(int[] arr)
	{
		int len=arr.length;
		if(len==0)
			return 0;
		int buffer[]=new int[len];
		buffer[0]=arr[0];
		int pos=1;//pos points to first empty spot
		for(int i=1;i<len;i++)
		{
			if(arr[i]<buffer[0])
				buffer[0]=arr[i];			
			else if(arr[i]>buffer[pos-1])
				buffer[pos++]=arr[i];
			else
				buffer[find_position(arr,0,pos,arr[i])]=arr[i];
		}
		for(int j=0;j<pos;j++)
		System.out.print(buffer[j]+" ");
		return pos;
	}
	private static int find_position(int[] arr, int low, int end,int key)
	{
		int mid;
		while(end-low>1)
		{
			mid=low+(end-low)/2;
			if(key<=arr[mid])
				end=mid;
			else
				low=mid;
		}
		return end;
	}
}
