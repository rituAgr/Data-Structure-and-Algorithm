package DP;

import java.util.Arrays;

/*
 * http://www.geeksforgeeks.org/dynamic-programming-set-7-coin-change/
 * Time complexity = O(len(coins) * total)
 * Space complexity - O(len(coins) * total)
 * https://www.youtube.com/watch?annotation_id=annotation_2195265949&feature=iv&src_vid=Y0ZqKpToTic&v=NJuKJ8sasGk
 */
public class CoinChangeProblem {

	public static void main(String[] args) {
		int[] coins= {7,2,3,6};
		int total=13;
		MinCoinChange(coins,total);
	}
	private static void MinCoinChange(int[] coins,int total)
	{
		int len=coins.length;
		int T[]=new int[total+1];
		int R[]=new int[total+1];
		Arrays.fill(T, Integer.MAX_VALUE-1);
		T[0]=0;
		for(int i=0;i<len;i++)
		{
			for(int j=0;j<=total;j++)
			{
				if(j<coins[i])
					continue;
				if(T[j]>1+T[j-coins[i]])
				{
					T[j]=1+T[j-coins[i]];
					R[j]=i;
				}
			}
		}
		System.out.println("Minimum Number of coin is "+T[total]);
		//Printing the number combination
		while(total>0)
		{
			int coinIndex=R[total];
			System.out.print(coins[coinIndex]+" ");
			total=total-coins[coinIndex];
		}
	}
}
