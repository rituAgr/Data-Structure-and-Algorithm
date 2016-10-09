package DP;

/*
 * http://www.geeksforgeeks.org/dynamic-programming-set-11-egg-dropping-puzzle/
 * Time complexity = O(Number of floor*No of eggs)
 * Space complexity = O(Number of floor*No of eggs)
 * https://www.youtube.com/watch?v=3hcaVyX00_4
 */
public class EggDropping_Problem {

	public static void main(String[] args) {
		int floor=20;
		int eggs=4;
		MinEggDropping(eggs,floor);
	}
	private static void MinEggDropping(int eggs,int floors)
	{
		int[][] matrix=new int[eggs+1][floors+1];
		for(int i=1;i<=floors;i++)
			matrix[1][i]=i;
		for(int egg=2;egg<=eggs;egg++)
		{

			for(int floor=1;floor<=floors;floor++)
			{
				int min=Integer.MAX_VALUE;
				matrix[egg][floor]=min;
				if(egg>floor)
					matrix[egg][floor]=matrix[egg-1][floor];
				else 
				{
					for(int i=1;i<=floor;i++)
						min=Math.min(min,Math.max(matrix[egg-1][i-1],matrix[egg][floor-i]));
					matrix[egg][floor]=min+1;
				}
			}
		}
		System.out.println("Min egg required : "+matrix[eggs][floors]);
		System.out.println("Here is the constructed matrix (just for reference");
		for(int egg=0;egg<=eggs;egg++)
		{
			for(int floor=0;floor<=floors;floor++)
				System.out.print(matrix[egg][floor]+" ");
			System.out.println();
		}
	}
}
