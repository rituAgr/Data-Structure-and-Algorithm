package DP;

/*
 * http://www.geeksforgeeks.org/dynamic-programming-set-31-optimal-strategy-for-a-game/
 * video : https://www.youtube.com/watch?v=WxpIHvsu1RI
 */
public class OptimalGameStrategy {

	public static void main(String[] args) {
		int[] arr={5, 3, 7, 10};
		find(arr);
	}
	static class sums
	{
		int player1,player2;
		sums(int i, int j)
		{
			player1=i;
			player2=j;
		}
	}
	private static void find(int[] arr)
	{
		int n=arr.length;
		sums[][] matrix=new sums[n][n];
		for(int l=1;l<=n;l++)
			for(int row=0;row<n-l+1;row++)
			{
				int col=row+l-1;
				if(row==col)
				{
					matrix[row][col]=new sums(arr[row],0);
					continue;
				}
				int first,sum=0,second;
				for(int count=row;count<=col;count++)
					sum=sum+arr[count];
				int first1=arr[row]+matrix[row+1][col].player2;
				int first2=arr[col]+matrix[row][col-1].player2;
				first=Math.max(first1, first2);
				second=sum-first;
				matrix[row][col]=new sums(first,second);
			}
		/*for(int row=0;row<n;row++)
		{
			for(int col=0;col<n;col++)
			{	
				if(row<col)
				{
					System.out.print("null    ");
					continue;
				}
				System.out.print(matrix[row][col].player1+", "+matrix[row][col].player2+"   ");
			}
			System.out.println();
		}*/
		System.out.println("My moves total is "+matrix[0][n-1].player1);
		System.out.println("Opponent moves total is "+matrix[0][n-1].player2);
	}
}
