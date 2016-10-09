package Hashing_geekforgeeks;

import java.util.HashSet;

/*
 * http://www.geeksforgeeks.org/length-largest-subarray-contiguous-elements-set-2/
 * Time complexity : O(n2)
 */
public class Max_subArray_with_Repitition {
	public static void main(String args[])
	{
		int arr[]={10, 12, 12, 10, 10, 11, 10};
		System.out.println("The longest continuguious array is "+ find(arr));
	}
	static int find(int[] arr)
	{
		int n= arr.length;
		int MaxLen=0;
		for(int i=0;i<n-1;i++)
		{
			HashSet<Integer> hs=new HashSet<Integer>();
			hs.add(arr[i]);
			int mn=arr[i];
			int mx=arr[i];
			for(int j=i+1;j<n;j++)
			{			
				if(hs.contains(arr[j]))
					break;
				hs.add(arr[j]);
				mn=Math.min(mn,arr[j]);
				mx=Math.max(mx,arr[j]);
				if((mx-mn)==j-i)
					MaxLen=Math.max(MaxLen, j-i+1);
			}
		}
		return MaxLen;
	}

}
