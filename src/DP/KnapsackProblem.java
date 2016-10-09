package DP;/*
 * http://www.geeksforgeeks.org/dynamic-programming-set-10-0-1-knapsack-problem/
 * Time complexity=O(n*W)
 * Space Complexity = O(n*W)
 * video : https://www.youtube.com/watch?v=8LusJS5-AGo
 */


public class KnapsackProblem {

	public static void main(String[] args) {
		int item_values[]={60, 100, 120};//1,4,5,7};
		int item_weights[]={10, 20, 30};//{1,3,4,5};
		int MaxWeight=50;
		find_Weights(item_values,item_weights,MaxWeight);
	}
	private static void find_Weights(int[] item_values,int[] item_weights, int MaxWeight)
	{
		int[][] matrix=new int[item_weights.length+1][MaxWeight+1];
		int col,row;
		for(row=0;row<=item_weights.length;row++)
		{
			for(col=0;col<=MaxWeight;col++)
			{		
				if(col==0||row==0)
				{
					matrix[row][col]=0;
					//System.out.print(matrix[row][col]+" ");
					continue;
				}
				if(col<item_weights[row-1])
					matrix[row][col]=matrix[row-1][col];
				else
					matrix[row][col]=Math.max(item_values[row-1]+matrix[row-1][col-item_weights[row-1]], matrix[row-1][col]);
				//System.out.print(matrix[row][col]+" ");
			}
			//System.out.println();
		}
		//Now, tracing back in matrix to know which items to include		
		row=item_weights.length;col=MaxWeight;
		System.out.println("Maximim weight is "+matrix[row][col]);
		while(row>0&&col>0&&MaxWeight>0)
		{
			if(matrix[row][col]==matrix[row-1][col])
			{
				row--;
				continue;
			}
			System.out.println("Include item with weight "+item_weights[row-1]+" and value "+item_values[row-1]);
			row--;
			col=MaxWeight-item_weights[row];
			MaxWeight=col;
		}
	}
}
