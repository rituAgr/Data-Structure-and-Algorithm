package Backtracking;
import java.util.Arrays;

public class N_Queen_Problem 
{
	static int n=4;
	public static void main(String[] args)
	{
		//int maze[][]=new int[n][n];
		int maze[][]={{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}};
		N_Queen(maze);
		for(int i=0;i<n;i++)
			{for(int j=0;j<n;j++)
				System.out.print(maze[i][j]);
		System.out.println();}
	}	
	static void N_Queen(int maze[][])
	{
		int i=0;
		while(i<n&&N_QueenUtil(maze, 1,1)==false)
		{
			for(int k=0;k<n;k++)
				Arrays.fill(maze[k],0);
			maze[0][i]=1;
			i++;
		}
	}
	static boolean N_QueenUtil(int maze[][],int row, int count)
	{
		if(count==4&&row==4)
			return true;
		if(count==4||row==4)
			return false;
		boolean check=true;
		for(int i=0;i<n&&check;i++)
		{
			boolean check1=check_row(maze,row);
			boolean check2= check_col(maze,i);
			boolean check3=check_diagonally(maze,row,i);
			if((check1&&check2&&check3)==true)
			{
				check=false;
				maze[row][i]=1;
				return N_QueenUtil(maze, row+1,count+1);
			}
		}
		return false;
	}
	static boolean check_row(int maze[][], int i)
	{
		for(int j=0;j<n;j++)
		{
			if(maze[i][j]==1)
				return false;
		}
		return true;
	}
	static boolean check_col(int maze[][], int i)
	{
		for(int j=0;j<n;j++)
		{
			if(maze[j][i]==1)
				return false;
		}
		return true;
	}
	static boolean check_diagonally(int maze[][], int i ,int j)
	{
		int i1=i;
		int j1=j;
		while(i1>=0&&j1>=0)
		{
			if(maze[i1][j1]==1)
				return false;
			i1--;
			j1--;
		}
		i1=i+1;
		j1=j+1;
		while(i1<n&&j1<n)
		{
			if(maze[i1][j1]==1)
				return false;
			i1++;j1++;
		}
		i1=i-1;
		j1=j+1;
		while(i1>=0&&j1<n)
		{
			if(maze[i1][j1]==1)
				return false;
			i1--;
			j1++;
		}
		i1=i+1;
		j1=j-1;
		while(i1<n&&j1>=0)
		{
			if(maze[i1][j1]==1)
				return false;
			i1++;
			j1--;
		}
		return true;
	}
}
