package DP;

/*
 * http://www.geeksforgeeks.org/dice-throw-problem/
 * There is no video explanation for it
 * Time complexity =O(sum*NumberofDices*Number of faces on each dice)
 * Space complexity=O(sum*NumberofDices)
 */
public class DiceThrow {

	public static void main(String[] args) {
		int sum=8;
		int num_dices=5;
		int faces=3;
		maxSum_Dicethrow(sum, num_dices, faces);
	}
	private static void maxSum_Dicethrow(int sum,int num_dices,int faces)
	{
		int matrix[][]=new int[num_dices+1][sum+1];
		for(int i=1;i<=faces;i++)
			matrix[1][i]=1;
		for(int i=2;i<=num_dices;i++)
			for(int j=i;j<=sum;j++)
				for(int k=1;k<=faces&&(j-k)>=0;k++)
					matrix[i][j]=matrix[i][j]+matrix[i-1][j-k];
		System.out.println(matrix[num_dices][sum]);
	}
}
