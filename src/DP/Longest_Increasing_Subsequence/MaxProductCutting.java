/*
 * http://www.geeksforgeeks.org/dynamic-programming-set-36-cut-a-rope-to-maximize-product/
 */
package DP.Longest_Increasing_Subsequence;
public class MaxProductCutting 
{
	public static void main(String[] args) 
	{
		int n=10;
		find_maxCutProduct(n);
	}
	private static void find_maxCutProduct(int n)
	{
		int val[]=new int[n+1];
		val[0]=0;
		val[1]=1;
		for(int i=1;i<=n;i++)
		{
			int max_val=0;
			for(int j=1;j<=i/2;j++)
				max_val=Math.max(Math.max((i-j)*j, val[i-j]*j), max_val);
			val[i]=max_val;
		}
		System.out.println(val[n]);
	}
}
