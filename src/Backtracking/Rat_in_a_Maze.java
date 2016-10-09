package Backtracking;
import java.util.ArrayList;

// Refer the link for more explaination : http://www.geeksforgeeks.org/backttracking-set-2-rat-in-a-maze/
public class Rat_in_a_Maze 
{
	public static void main(String[] args)
	{
		int maze[][]={{1, 1, 0, 0},{0, 1, 0, 0},{0, 1, 0, 0},{0, 1, 1, 1}};
		ArrayList<String> finalPath= path(maze);
		for(String s : finalPath)
			System.out.print(s+" -> ");
	}
	public static ArrayList<String> path(int maze[][])
	{
		ArrayList<String> pathList = new ArrayList<String>();
		pathUtil(maze,0,0,maze.length-1, pathList);
		return pathList;
	}
	public static void pathUtil(int maze[][], int row,int col,int n,ArrayList<String> pathList)
	{
		if(row==n&&col==n)
			return ;
		if(isSafe(maze, row, col+1))
			{
			pathList.add("Straight");
			pathUtil(maze,row, col+1,n,pathList);
			}
		else if(isSafe(maze, row+1, col))
		{
			pathList.add("Down");
			pathUtil(maze,row+1, col,n,pathList);
		}
		else
		{
			pathList.remove(pathList.size()-1);
		}
	}
	public static boolean isSafe(int maze[][], int row,int col)
	{
		if(row==maze.length||col==maze.length)
			return false;
		if(maze[row][col]==1)
			return true;
		else
			return false;
	}
}
