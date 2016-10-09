package Matrix_geeksforgeeks;/*
 * http://www.geeksforgeeks.org/print-a-given-matrix-in-spiral-form/
 */
import java.util.ArrayList;

public class Spiral_Matrix {

	public static void main(String[] args) {
		int matrix[][]={ {1,  2,  3,  4,  5,  6},
				{7,  8,  9,  10, 11, 12},
				{13, 14, 15, 16, 17, 18}};
		ArrayList<Integer> res=new ArrayList<Integer>();
		print_Spriral(matrix,res);
		System.out.println(res.toString());
	}
	static void print_Spriral(int[][] matrix,ArrayList<Integer> res)
	{
		int row_start=0,row_end,col_start=0,col_end;
		row_end=matrix.length-1;
		col_end=matrix[0].length-1;
		int dir=1;
		while(row_start<=row_end&&col_start<col_end)
		{
			switch(dir)
			{
			case 1: 
				for(int i=col_start;i<=col_end;i++)
					res.add(matrix[row_start][i]);
				row_start++;
				dir=2;
				break;
			case 2:
				for(int i=row_start;i<=row_end;i++)
					res.add(matrix[i][col_end]);
				col_end--;
				dir=3;
				break;
			case 3: 
				for(int i=col_end;i>=col_start;i--)
					res.add(matrix[row_end][i]);
				row_end--;
				dir=4;
				break;
			case 4:
				for(int i=row_end;i>=row_start;i--)
					res.add(matrix[i][col_start]);
				col_start++;
				dir=1;
				break;
			}
		}
	}
}
