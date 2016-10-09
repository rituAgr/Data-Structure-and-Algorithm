package Matrix_geeksforgeeks;

import java.util.Arrays;

/*
 * http://www.geeksforgeeks.org/maximum-size-sub-matrix-with-all-1s-in-a-binary-matrix/
 */
public class MAx_Square_SumArray {

	public static void main(String[] args) {
		int M[][] =  {{0, 1, 1, 0, 1},
				{1, 1, 0, 1, 0}, 
				{0, 1, 1, 1, 0},
				{1, 1, 1, 1, 0},
				{1, 1, 1, 1, 1},
				{0, 0, 0, 0, 0}};
		int [][]res=getSubArray(M);
		System.out.println(Arrays.deepToString(res));
	}
	static int[][] getSubArray(int[][] M)
	{
		int row=M.length;
		int col=M[0].length;
		int S[][]=new int[row][col];
		for(int i=0;i<col;i++)
			S[0][i]=M[0][i];
		for(int i=1;i<row;i++)
			S[i][0]=M[i][0];
		int max=0;//,row_index=0,col_index=0;
		for(int i=1;i<row;i++)
			for(int j=1;j<col;j++)
				if(M[i][j]==1)
				{
					S[i][j]=Math.min(Math.min(S[i-1][j], S[i-1][j-1]),S[i][j-1])+1;	
					if(max<S[i][j])
						max=S[i][j];
				}
		int[][] res=new int[max][max];
		for(int i=0;i<max;i++)
			Arrays.fill(res[i], 1);
		return res;
	}

}
