package DP;

/*
 * http://www.geeksforgeeks.org/dynamic-programming-set-12-longest-palindromic-subsequence/
 * Time complexity =n^2
 * Space complexity =n^2
 * https://www.youtube.com/watch?v=_nCsPn7_OgI
 */
public class LPS 
{
	public static void main(String args[])
	{
		String seq = "AGOXOGB";
		System.out.println("The length of the lps is "+ lps(seq));
	}
	private static int lps(String s)
	{
		int n=s.length();
		if(n==0)
			return 0;
		int[][] matrix=new int[n][n];
		for(int i=0;i<n;i++)
			matrix[i][i]=1;
		for(int l=2;l<=n;l++)
		{
			for(int i=0;i<=n-l;i++)
			{
				int j=i+l-1;
				if(s.charAt(i)==s.charAt(j))
					matrix[i][j]=2+matrix[i+1][j-1];
				else
					matrix[i][j]=Math.max(matrix[i][j-1], matrix[i+1][j]);
			}
		}
		return matrix[0][n-1];
	}
}
