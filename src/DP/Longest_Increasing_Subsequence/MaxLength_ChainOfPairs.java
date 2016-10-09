/*
 * http://www.geeksforgeeks.org/dynamic-programming-set-20-maximum-length-chain-of-pairs/
 * Time complexity =O(n)
 * Space complexity =O(n)
 */
package DP.Longest_Increasing_Subsequence;

import java.util.ArrayList;
import java.util.Arrays;

public class MaxLength_ChainOfPairs {
	static class Pairs
	{
		int first,second;
		Pairs(int f, int s)
		{
			first=f;
			second=s;
		}
	}
	public static void main(String[] args) 
	{
		Pairs[] pairs={new Pairs(5, 24), new Pairs(39, 60),new Pairs(15, 28), new Pairs(27, 40),new Pairs(50, 90)};
		LIS(pairs);
	}
	private static void LIS(Pairs[] pairs)
	{
		int n=pairs.length;
		int MaxLen[]=new int[n];
		int parent[]=new int[n];
		Arrays.fill(MaxLen, 1);
		Arrays.fill(parent,-1);
		for(int i=1;i<n;i++)
			for(int j=0;j<i;j++)
			{
				if(pairs[j].second>=pairs[i].first)
					continue;
				if(MaxLen[j]+1>MaxLen[i])
				{
					MaxLen[i]=MaxLen[j]+1;
					parent[i]=j;
				}				
			}
		int maxlen=0,index=-1;
		for(int i=1;i<n;i++)
			if(MaxLen[i]>maxlen)
			{
				maxlen=MaxLen[i];
				index=i;
			}
		ArrayList<Pairs> res=new ArrayList<Pairs>();
		while(parent[index]!=-1)
		{
			res.add(0,pairs[index]);
			index=parent[index];
		}
		res.add(0,pairs[index]);
		System.out.println("MAximum length is "+maxlen);
		for(Pairs pair: res)
			System.out.println(pair.first+" "+pair.second);
	}
}
