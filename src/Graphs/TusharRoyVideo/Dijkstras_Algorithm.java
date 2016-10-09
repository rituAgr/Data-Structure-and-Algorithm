package Graphs.TusharRoyVideo;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * Time complexity = O(n^2)
 * Space complexity=O(n)
 */
public class Dijkstras_Algorithm {
	static int n;
	public static void main(String[] args) {
		int graph[][] = new int[][]
			{{0, 4, 0, 0, 0, 0, 0, 8, 0},
			{4, 0, 8, 0, 0, 0, 0, 11, 0},
			{0, 8, 0, 7, 0, 4, 0, 0, 2},
			{0, 0, 7, 0, 9, 14, 0, 0, 0},
			{0, 0, 0, 9, 0, 10, 0, 0, 0},
			{0, 0, 4, 0, 10, 0, 2, 0, 0},
			{0, 0, 0, 14, 0, 2, 0, 1, 6},
			{8, 11, 0, 0, 0, 0, 1, 0, 7},
			{0, 0, 2, 0, 0, 0, 6, 7, 0}
		};
		n=graph.length;
		Dijkstras_Algorithm algo=new Dijkstras_Algorithm();   
		algo.find_ShortestPaths(0, graph);
	}
	boolean[] visited;
	int[] parents;
	int[] weights;
	Dijkstras_Algorithm()
	{
		visited=new boolean[n];
		parents=new int[n];
		weights=new int[n];
		Arrays.fill(parents,-1);
		Arrays.fill(weights,Integer.MAX_VALUE-100000);
	}
	private int getMin()
	{
		int min=Integer.MAX_VALUE;
		int minIndex=-1;
		for(int i=0;i<n;i++)
			if(visited[i]==false&&weights[i]<min)
			{
				min=weights[i];
				minIndex=i;
			}
		return minIndex;
	}
	private void find_ShortestPaths(int start,int graph[][])
	{
		weights[start]=0;
		while(true)
		{
			int minVertex=getMin();
			if(minVertex==-1)
				break;
			visited[minVertex]=true;
			int i=minVertex;
			for(int j=0;j<n;j++)
			{
				if(graph[i][j]!=0&&visited[j]==false&&weights[i]+graph[i][j]<weights[j])
				{
					weights[j]=weights[i]+graph[i][j];
					parents[j]=i;
				}
			}
		}
		System.out.println("Destination        path           Weight");
		for(int k=1;k<n;k++)
		{
			ArrayList<Integer> res=new ArrayList<Integer>();
			res.add(k);
			int j=k;
			while(parents[j]!=-1)
			{
				res.add(0,parents[j]);
				j=parents[j];
			}
			System.out.println("\t"+k+"\t "+res.toString()+" \t\t"+weights[k]);
		}
	}
}
