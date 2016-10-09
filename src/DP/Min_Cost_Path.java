package DP;/*
 * http://www.geeksforgeeks.org/dynamic-programming-set-6-min-cost-path/
 * Time complexity= O(nm)
 * Space Complexity =O(nm)
 * video : https://www.youtube.com/watch?v=lBRtnuxg-gU
 */


import java.util.ArrayList;

public class Min_Cost_Path {

	public static void main(String[] args) {
		int[][] matrix={{1, 3,5,8},
                {4, 2,1,7},
                {4,3,2,3} };
		 MinPath(matrix);
	}
	private static void MinPath(int[][] mat)
	{
		int row=mat.length;
		int col=mat[0].length;
		int costs[][]=new int[row][col];
		for(int r=0;r<row;r++)
			for(int c=0;c<col;c++)
			{
				if(r==0&&c==0)
					costs[r][c]=mat[0][0];
				else if(r==0)
					costs[r][c]=costs[r][c-1]+mat[r][c];
				else if(c==0)
					costs[r][c]=costs[r-1][c]+mat[r][c];
				else
					costs[r][c]=Math.min(costs[r-1][c], costs[r][c-1])+mat[r][c];
			}
		System.out.println("Minimum cost is "+costs[row-1][col-1]);
		row--;col--;
		ArrayList<Integer> path=new ArrayList<Integer>();
		path.add(0,mat[row][col]);
		while(row>0&&col>0)
		{
			if(costs[row-1][col]<costs[row][col-1])
				{
				path.add(0,mat[row-1][col]);
				row--;
				}
			else
			{
				path.add(0,mat[row][col-1]);
				col--;
			}		
		}
		path.add(0,mat[0][0]);
		for(Integer i:path)
			System.out.println(i);
	}
}
