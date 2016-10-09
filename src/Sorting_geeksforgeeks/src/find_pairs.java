package Sorting_geeksforgeeks.src;

import java.util.Arrays;

/*
 * Refer this link for more explanation : http://www.geeksforgeeks.org/find-number-pairs-xy-yx/
 * I am doing the efficient method 
 * Time complexity : nlogn + mlogm
 */
public class find_pairs {

	public static void main(String[] args)
	{
		int X[] = {10, 19, 18};
		int[] Y = {11, 15, 9};
		int z=ones(Y);
		int x=pairs(X,Y);
		System.out.println(x);
	}
	public static int pairs(int X[], int Y[])
	{
		Arrays.sort(Y);
		int c=0;
		for(int i=0;i<X.length;i++)
		{
			if(X[i]==0||X[i]==1)
				continue;
			c=c+greater_binary_search(Y,X[i]);
		}
		return c;
	}
	public static int greater_binary_search(int Y[],int num)
	{
		int l=Y.length;
		int end=l-1;
		int start=0;
		int c=ones(Y);
		/*if(Y[l-1]<=num)
			return c;
		if(Y[0]==num)
			return l-1+c;
		if(Y[0]>num)
			return l+c;*/
		
		while(start<=end)
		{
			int mid=(start+end)/2;
			if(Y[mid]>num||((mid-1<0||Y[mid-1]<=num)&&Y[mid]>num))
				return (l-mid)+c;
			if(mid+1>=l&&Y[mid]<=num)
				return c;
			if(mid-1<0&&Y[0]>=num)
				return l+c;
			if(Y[mid]<num)
				start=mid+1;
			else if(Y[mid]>num)
				end=mid-1;
		}
		return c;
	}
	public static int ones(int Y[])
	{
		int l=Y.length;
		int start=0;
		int end=l-1;
		int low=-1,high=-1;
		//finding upper limit
		while(start<=end)
		{
			int mid=(start+end)/2;
			if(Y[mid]==1&&((mid+1==l)||(Y[mid+1]>1)))
			{
				high=mid;
				break;
			}
			else if(Y[mid]>1)
				end=mid-1;
			else
				start=mid+1;
		}
		//finding lower limit
		start=0;
		end=l-1;
		while(start<=end)
		{
			int mid=(start+end)/2;
			if(Y[mid]==1&&((mid-1<0)||(Y[mid-1]<1)))
			{
				low=mid;
				break;
			}
			else if(Y[mid]<1)
				start=mid+1;
			else
				end=mid-1;
		}
		if(low==-1&&high==-1)
			return 0;
		if(low==-1||high==-1)
			return 1;
		return (high-low+1);
	}
}
