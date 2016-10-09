/*https://www.youtube.com/watch?v=NnD96abizww
http://www.geeksforgeeks.org/dynamic-programming-set-4-longest-common-subsequence/
Time complexity : O(n^2)
Points to remember :
1. Understand how the matrix value is manipulated from already calculated matrix position.
2. For tracing back; we need to match upper block and left block. Diagonal block goes last in else condition.
*/
package DP.Revision;

import java.util.ArrayList;

public class LoongestCommonSubsequence {

	public static void main(String[] args) {
		String str1 = "ABCDGHLQR";
		String str2 = "AEDPHR";
		LCS(str1,str2);
	}
	private static void LCS(String str1,String str2)
	{
		int row=str1.length();
		int col=str2.length();
		int[][] matrix=new int[row+1][col+1];
		for(int i=1;i<=row;i++)
		{
			for(int j=1;j<=col;j++)
			{
				if(str1.charAt(i-1)==str2.charAt(j-1))
					matrix[i][j]=matrix[i-1][j-1]+1;
				else
					matrix[i][j]=Math.max(matrix[i-1][j], matrix[i][j-1]);
			}
		}
		System.out.println("The length of Longest common subsequence is "+matrix[row][col]);
		ArrayList<Character> res=new ArrayList<Character>();
		while(row!=0&&col!=0)
		{
			if(matrix[row][col]==matrix[row-1][col])
				row--;
			else if(matrix[row][col]==matrix[row][col-1])
				col--;
			else
			{
				res.add(0,str1.charAt(row-1));
				row--;col--;
			}
		}
		System.out.println("The Longest common subsequence is "+res);
	}
}