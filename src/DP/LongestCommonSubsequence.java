package DP;
/*
 * For finding the length of LCS:
 * http://www.geeksforgeeks.org/dynamic-programming-set-4-longest-common-subsequence/
 * For getting the longest common subsequence
 * http://www.geeksforgeeks.org/printing-longest-common-subsequence/
 * Time complexity = O(mn); where m, n is lengths of arrays
 * Space complexity=O(mn)
 * Video: https://www.youtube.com/watch?v=NnD96abizww
 */
import java.util.Scanner;
public class LongestCommonSubsequence {

	public static void main(String[] args) {
		String s1="AGGTAB";
		String s2="GXTXAYB";
		int len=LCS(s1.toCharArray(),s2.toCharArray());
		System.out.println("The max len of LongestCommonSubsequence is "+len);
	}
	private static int LCS(char[] s1,char[] s2)
	{
		int len1,len2;
		len1=s1.length;
		len2=s2.length;
		int[][] res=new int[len1+1][len2+1];
		for(int i=0;i<=len1;i++)
		{
			for(int j=0;j<=len2;j++)
			{
				if(i==0||j==0)
					res[i][j]=0;
				else if(s1[i-1]==s2[j-1])
					res[i][j]=1+res[i-1][j-1];
				else
					res[i][j]=Math.max(res[i][j-1], res[i-1][j]);
			}
		}
		Scanner scan=new Scanner(System.in);
		System.out.println("Do you want to see the Longest Common subsequence y/n");
		char c= scan.next().charAt(0);
		scan.close();
		if(c=='y'||c=='Y')
			print_LCS(res,s1,s2);
		return res[len1][len2];
	}
	private static void print_LCS(int[][] res,char[] s1,char[] s2)
	{
		int row=res.length-1;
		int col=res[0].length-1;
		StringBuilder s=new StringBuilder();
		while(row>0&&col>0)
		{
			if(res[row][col]==res[row-1][col-1]+1)
				{
				s.append(s1[row-1]);
				row--;
				col--;
				}
			else 
			{
				if(res[row][col]==1+res[row-1][col])
					row--;
				else
					col--;
			}
		}
		s.reverse();
		System.out.println("The Longest Common subsequence is "+s);		
	}
}

