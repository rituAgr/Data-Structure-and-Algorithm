package Matrix_geeksforgeeks;

/*
 * http://www.geeksforgeeks.org/given-n-x-n-square-matrix-find-sum-sub-squares-size-k-x-k/
 */
public class sum_Square {

	public static void main(String[] args)
	{
		int n=5,k=3;
		int array[][]={{1, 1, 1, 1, 1},
				{2, 2, 2, 2, 2},
				{3, 3, 3, 3, 3},
				{4, 4, 4, 4, 4},
				{5, 5, 5, 5, 5},
		};
		int res[][]=find_Sum_Array(n,k,array);
		for(int i=0;i<res.length;i++)
		{
			for(int j=0;j<res[i].length;j++)
				System.out.print(res[i][j]+" ");
			System.out.println();
		}
	}
	static int[][] find_Sum_Array(int n,int k,int[][] array)
	{
		int dim=n-k+1;
		int[][] res= new int[dim][dim];
		for(int i=0;i<dim;i++)
			for(int j=0;j<dim;j++)
				res[i][j]=getSum(array, i, j, k);
		return res;

	}
	static int getSum(int[][] array, int x, int y,int k)
	{
		int sum=0;
		for(int i=x;i<x+k;i++)
			for(int j=y;j<y+k;j++)
				sum=sum+array[i][j];
		return sum;
	}
}
