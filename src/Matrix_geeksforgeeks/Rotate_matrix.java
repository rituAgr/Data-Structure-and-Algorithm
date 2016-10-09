package Matrix_geeksforgeeks;

/*
 * http://www.geeksforgeeks.org/rotate-matrix-elements/
 */
public class Rotate_matrix {

	public static void main(String[] args) {
		int mat[][] = { {1,  2,  3,  4},
				{5,  6,  7,  8},
				{9,  10, 11, 12},
				{13, 14, 15, 16}  };
		rotate(mat);
		for(int i=0;i<mat.length;i++)
		{
			for(int j=0;j<mat[0].length;j++)
				System.out.print(mat[i][j]+"  ");
			System.out.println();
		}			
	}
	public static void rotate(int[][] mat)
	{
		int end_row=mat.length-1;
		int end_col=mat[0].length-1;
		int start_row=0;
		int start_col=0;
		int dir=1;
		int prev=-1;
		while(end_row-start_row!=-2&&end_col-start_col!=-2)				//start_row<=end_row&&start_col<=end_col)
		{ 
			switch (dir)
			{
			case 1 :				
				for(int i=start_col;i<=end_col;i++)
				{
					int temp=mat[start_row][i];
					mat[start_row][i]=prev;
					prev=temp;
				}
				start_row++;
				dir=2;
				break;
			case 2: 
				for(int i=start_row;i<=end_row;i++)
				{
					int temp=mat[i][end_col];
					mat[i][end_col]=prev;
					prev=temp;
				}
				end_col--;
				dir=3;
				break;
			case 3:			
				for(int i=end_col;i>=start_col;i--)
				{
					int temp=mat[end_row][i];
					mat[end_row][i]=prev;
					prev=temp;
				}
				end_row--;
				dir=4;
				break;
			case 4: 
				for(int i=end_row;i>=start_row;i--)
				{
					int temp=mat[i][start_col];
					mat[i][start_col]=prev;
					prev=temp;
				}
				start_col++;
				mat[start_row-1][start_col-1]=prev;
				dir=1;
				break;
			}

		}
	}

}
