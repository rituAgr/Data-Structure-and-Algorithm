package DP;/*
 * http://www.geeksforgeeks.org/dynamic-programming-set-9-binomial-coefficient/
 * Time complexity=O(n*k)
 * Space Complexity = O(n*k)
 * Video: https://www.youtube.com/watch?v=F0N2bpduU1I
 */


public class BinomialCoefficient {

	public static void main(String[] args) 
	{
		int n=5,k=2;
		find_BinomialCoefficient(n,k);
	}
	private static void find_BinomialCoefficient(int n,int k)
	{
		int matrix[][]=new int[n+1][k+1];
		for(int row=0;row<=n;row++)
			for(int col=0;col<=k;col++)
			{
				if(col>row)
					break;
				if(col==0||row==col)
				{
					matrix[row][col]=1;
					continue;
				}
				matrix[row][col]=matrix[row-1][col-1]+matrix[row-1][col];				
			}
		System.out.println(matrix[n][k]);
	}
}
