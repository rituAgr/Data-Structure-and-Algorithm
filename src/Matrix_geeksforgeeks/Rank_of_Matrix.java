package Matrix_geeksforgeeks;

/*
 * http://www.geeksforgeeks.org/program-for-rank-of-matrix/
 */
public class Rank_of_Matrix {
	public static void main(String[] args) {
		int[][] mat={{10,   20,   10},
				{20,   40,   20},
				{30,   50,   0}};
		int rank=getRank(mat);
		System.out.println("Rank of matrix is "+rank);
	}
	static int getRank(int[][] mat)
	{
		int rows=mat.length;
		int cols=mat[0].length;
		int rank=(rows<cols)?rows:cols;
		for(int row=0;row<rows;row++)
		{
			int val=mat[row][row];
			if(val!=0)
				makeZero(mat,row,row);
			else
			{
				boolean check = false;
				for(int r=row+1;r<mat.length;r++)
				{
					if(mat[r][row]!=0)
					{
						swapRow(mat, row, r);
						check=true;
						break;
					}
				}
				if(check==false)
				{
					swapCol(mat, row, mat[0].length-1);
					rank--;
				}
			}
		}
		return rank;
	}
	static void swapRow(int[][] mat, int row1, int row2)
	{
		for(int col=0;col<mat[0].length;col++)
		{
			int temp =mat[row1][col];
			mat[row1][col]=mat[row2][col];
			mat[row2][col]=temp;
		}
	}
	static void swapCol(int[][] mat, int col1, int col2)
	{
		for(int row=0;row<mat.length;row++)
		{
			int temp =mat[row][col1];
			mat[row][col1]=mat[row][col2];
			mat[row][col2]=temp;
		}
	}
	static void makeZero(int[][] mat, int row,int col)
	{
		for(int r=row+1;r<mat.length;r++)
		{
			if(mat[r][col]==0)
				continue;
			int multiple=mat[row][col]/mat[r][col];
			for(int c=0;c<mat[0].length;c++)
				mat[r][c]=mat[r][c]*multiple-mat[row][c];
		}
	}

}
