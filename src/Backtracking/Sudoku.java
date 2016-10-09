package Backtracking;
public class Sudoku 
{
	public static void main(String args[])
	{
		int grid[][] = {{3, 0, 6, 5, 0, 8, 4, 0, 0},
				{5, 2, 0, 0, 0, 0, 0, 0, 0},
				{0, 8, 7, 0, 0, 0, 0, 3, 1},
				{0, 0, 3, 0, 1, 0, 0, 8, 0},
				{9, 0, 0, 8, 6, 3, 0, 0, 5},
				{0, 5, 0, 0, 9, 0, 6, 0, 0},
				{1, 3, 0, 0, 0, 0, 2, 5, 0},
				{0, 0, 0, 0, 0, 0, 0, 7, 4},
				{0, 0, 5, 2, 0, 6, 3, 0, 0}};
		if(isValid(grid))
		{
			if(solve(grid))
				printGrid(grid);
			else
				System.out.println("The solution is not posible");
		}
		else
			System.out.println("The solution is not posible");
	}
	public static boolean solve(int[][] grid)
	{
		int [][]FreeCells=getEmptyCell(grid);
		boolean found=false;
		int k=0;
		while(!found)
		{
			int i=FreeCells[k][0];
			int j=FreeCells[k][1];
			if(grid[i][j]==0)
			    grid[i][j]=1;
			if(isValid(i,j,grid))
			{
				if(k==FreeCells.length-1)
					found=true;
				else
					k++;
			}
			else if(grid[i][j]<9)
				grid[i][j]=grid[i][j]+1;
			else
			{
				while(grid[i][j]==9)
				{
					grid[i][j]=0;
					if(k==0)
						return false;
					k--;
					i=FreeCells[k][0];
					j=FreeCells[k][1];
				}
				grid[i][j]=grid[i][j]+1;
			}
		}
		return true;
	}
	public static void printGrid(int[][] grid)
	{
		for(int i=0;i<9;i++)
		{
			for(int j=0;j<9;j++)
				System.out.print(grid[i][j]+"  ");
			System.out.println();
		}
	}
	public static int[][] getEmptyCell(int[][] grid)
	{
		int count=0;
		for(int i=0;i<9;i++)
			for(int j=0;j<9;j++)
				if(grid[i][j]==0)
					count++;
		int cells[][]= new int[count][2];
		count=0;
		for(int i=0;i<9;i++)
			for(int j=0;j<9;j++)
				if(grid[i][j]==0)
				{
					cells[count][0]=i;
					cells[count++][1]=j;
				}
		return cells;
	}
	// for validating a value in the the sudoku matrix
	public static boolean isValid( int row, int col, int[][] grid)
	{
		int val=grid[row][col];
		//checking row
		for(int i=0;i<9;i++)
			if(i!=col&&grid[row][i]==val)
				return false;
		// checking column
		for(int i=0;i<9;i++)
			if(i!=row&&grid[i][col]==val)
				return false;
		//checking block
		for(int i=(row/3)*3;i<((row/3)*3+3);i++)
		{
			for(int j=(col/3)*3;j<((col/3)*3+3);j++)
				if(i!=row&&j!=col&&grid[i][j]==val)
					return false;		
		}
		return true;
	}
	// for validating the input sudoku matrix entries before starting to solve it
	public static boolean isValid(int[][] grid)
	{
		for(int i=0;i<9;i++)
			for(int j=0;j<9;j++)
				if(grid[i][j]!=0&&!isValid( i, j, grid))
					return false;
		return true;
	}
}














