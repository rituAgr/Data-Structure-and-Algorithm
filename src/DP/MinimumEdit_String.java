package DP;/*
 * http://www.geeksforgeeks.org/dynamic-programming-set-5-edit-distance/
 * Time complexity= O(nm)
 * Space Complexity =O(nm)
 * video : https://www.youtube.com/watch?v=We3YDTzNXEk
 */


import java.util.ArrayList;
import java.util.Scanner;

public class MinimumEdit_String {

	public static void main(String[] args) {
		String s1="sunday";
		String s2="saturday";
		getNumberofEdits(s1,s2);
	}
	private static void getNumberofEdits(String s1,String s2)
	{
		int n=s1.length();
		int m=s2.length();
		int count[][]=new int[n+1][m+1];
		for(int i=0;i<=n;i++)
		{
			for(int j=0;j<=m;j++)
			{
				if(i==0)
					count[i][j]=j;
				else if(j==0)
					count[i][j]=i;
				else if(s1.charAt(i-1)==s2.charAt(j-1))
					count[i][j]=count[i-1][j-1];
				else
					count[i][j]=1+Math.min(count[i-1][j-1],(Math.min(count[i-1][j], count[i][j-1])));
			}
		}
		for(int i=0;i<=n;i++)
			{for(int j=0;j<=m;j++)
				System.out.print(count[i][j]+" ");
		System.out.println();}
		System.out.println("The number of edits are "+count[n][m]);
		System.out.println("Do want to know what edits are required (y/n)");
		Scanner scan=new Scanner(System.in);
		char c=scan.next().charAt(0);
		if(c=='y'||c=='Y')
			printEdits(count,s1,s2);
		scan.close();
	}
	private static void printEdits(int[][] count,String s1,String s2)
	{
		ArrayList<String> res=new ArrayList<String>();
		int n=s1.length();
		int m=s2.length();
		while(n>0&&m>0)
		{
			if(s1.charAt(n-1)==s2.charAt(m-1))
			{
				n--;m--;
				continue;
			}
			int min=Math.min(count[n-1][m-1],(Math.min(count[n-1][m], count[n][m-1])));
			if(min==count[n-1][m-1])
			{
				res.add(0,"Replace "+s2.charAt(m-1)+" with "+s1.charAt(n-1));
				n--;m--;
			}
			else if (min==count[n][m-1])
			{
				res.add(0,"remove "+s2.charAt(m-1));
				m--;	
			}
			else
			{
				res.add(0,"Add "+s1.charAt(n-1));
				n--;	
			}
		}
		
		for(String s:res)
			System.out.println(s);
	}
}
