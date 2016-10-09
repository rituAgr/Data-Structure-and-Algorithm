package DP;

import java.util.ArrayList;

import javax.management.Descriptor;

/*
 * http://www.geeksforgeeks.org/dynamic-programming-set-16-floyd-warshall-algorithm/
 * Time complexity : O(n^3)
 * Space complexity : O(n^2)
 * https://www.youtube.com/watch?v=LwJdNfdLF9s
 */
public class Floyd_Warshall_Algorithm {
	static int INF=1000000;
	public static void main(String[] args) {

		int[][] graph={ {0,   3,   6,   15},
				{INF, 0,  -2,   INF},
				{INF, INF, 0,   2},
				{1,   INF, INF, 0}};
		Floyd_Warshall_Algo(graph);
	}
	private static void Floyd_Warshall_Algo(int[][] graph)
	{
		int n=graph.length;
		int[][] distance=new int[n][n];
		int[][] paths=new int[n][n];
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
			{
				distance[i][j]=graph[i][j];
				if(graph[i][j]!=INF&&i!=j)
					paths[i][j]=i;
				else
					paths[i][j]=-1;
			}
		for(int k=0;k<n;k++)
			for(int i=0;i<n;i++)
				for(int j=0;j<n;j++)
				{
					if(distance[i][k]==INF||distance[k][j]==INF)
						continue;
					if(distance[i][j]>distance[i][k]+distance[k][j])
					{
						distance[i][j]=distance[i][k]+distance[k][j];
						paths[i][j]=paths[k][j];
					}
				}
		//Below commented code is just to see matrix formed
		/*for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
				System.out.print(paths[i][j]+" ");
			System.out.println();
		}*/
		//below function print func is to get minimum weight path from source to destination
		int source=1,destination=3;
		printPath(paths,source,destination);		
	}
	private static void printPath(int[][] paths,int i,int j)
	{
		System.out.println("Route from "+i+" and "+j+" is as below :");
		ArrayList<Integer> res=new ArrayList<Integer>();
		res.add(i);
		res.add(j);
		while(paths[i][j]!=i)
		{
			j=paths[i][j];
			res.add(1,j);

		}
		System.out.println(res.toString());
	}
}
