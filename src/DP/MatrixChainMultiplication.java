package DP;

/*
 * http://www.geeksforgeeks.org/dynamic-programming-set-8-matrix-chain-multiplication/
Time complexity : O(n^3)
Space complexity : O(n^2)
https://www.youtube.com/watch?v=vgLJZMUfnsU
*/
public class MatrixChainMultiplication {
//The solution below I followed is of geeksforgeeks; not of of tushar roy.Below is better is better solution
	public static void main(String[] args) {
		int orders[]={1, 2, 3, 4};//4,2,3,5,3};
		int value=minCost(orders);
		System.out.println("The min cost is "+value);
	}
	private static int minCost(int[] arr)
	{
		int n=arr.length;
		int[][] matrix=new int[n][n];
		for(int l=2;l<n;l++)
			for(int i=1;i<n-l+1;i++)
			{
				int j=i+l-1;
				if(j==n)
					break;
				matrix[i][j]=Integer.MAX_VALUE;
				for(int k=i;k<j;k++)
				{
					int temp=matrix[i][k]+matrix[k+1][j]+arr[i-1]*arr[j]*arr[k];
					if(temp<matrix[i][j])
						matrix[i][j]=temp;
				}
				
			}
		return matrix[1][n-1];
	}
}
