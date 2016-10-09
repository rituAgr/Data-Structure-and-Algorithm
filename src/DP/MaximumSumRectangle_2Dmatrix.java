package DP;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * http://www.geeksforgeeks.org/dynamic-programming-set-27-max-sum-rectangle-in-a-2d-matrix/
 * 
 */
public class MaximumSumRectangle_2Dmatrix {

	public static void main(String[] args) {
		int[][] matrix={{ 2,  1, -3, -4,  5},
				{ 0,  6,  3,  4,  1},
				{ 2, -2, -1,  4, -5},
				{-3,  3,  1,  0,  3}};
		findMaxRectangle(matrix);
	}
	private static void findMaxRectangle(int[][] matrix)
	{
		int row=matrix.length;
		int col=matrix[0].length;
		int arr[]=new int[row];
		int up=-1,down=-1,left=-1,right=-1;
		int sum=0,maxSum=0;
		for(int L=0;L<col;L++)
		{
			Arrays.fill(arr, 0);
			for(int R=L;R<col;R++)
			{
				for(int i=0;i<row;i++)
					arr[i]=matrix[i][R]+arr[i];
				ArrayList<Integer> res=Kadane_Algo.Kadane(arr);
				if(res==null)
					continue;
				sum=res.get(2);
				if(sum<=maxSum)
					continue;
				maxSum=sum;
				up=res.get(0);
				down=res.get(1);
				left=L;
				right=R;
			}
		}
		if(maxSum==0)
			return;
		System.out.println("the maximum sum is "+maxSum+"\n\nThe sub Array is below");
		for(int k1=up;k1<=down;k1++)
		{
			for(int k2=left;k2<=right;k2++)
				System.out.print(matrix[k1][k2]+"  ");
			System.out.println();
		}
		
	}
}
