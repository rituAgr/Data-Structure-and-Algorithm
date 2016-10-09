package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
/*
 * http://www.geeksforgeeks.org/find-longest-path-directed-acyclic-graph/
 * Time complexity : O(V+E)
 */
public class LongestPath_DirectedAcyclicGraph
{
	static int INF=Integer.MIN_VALUE;
	public static void main(String[] args)
	{
		int[][] graph={{0,5,3,0,0,0},
				{0,0,2,6,0,0},
				{0,0,0,7,4,2},
				{0,0,0,0,-1,1},
				{0,0,0,0,0,-2},
				{0,0,0,0,0,0}};
		longestPath(graph,1);
	}
	private static void longestPath(int[][] graph,int source)
	{
		int n=graph.length;
		Stack<Integer> st=new Stack<Integer>();
		Set<Integer> visited=new HashSet<Integer>();
		for(int i=0;i<n;i++)
			if(!visited.contains(i))
				topologicalSort(st,graph,visited,i);
		int[] dis=new int[n];
		Arrays.fill(dis, INF);
		dis[source]=0;
		int[] parent=new int[n];
		Arrays.fill(parent, -1);
		while(!st.isEmpty())
		{
			int curr=st.pop();
			if(dis[curr]==INF)
				continue;
			for(int col=0;col<n;col++)
			{
				if(graph[curr][col]==0)
					continue;
				if(dis[col]<graph[curr][col]+dis[curr])
				{
					dis[col]=graph[curr][col]+dis[curr];
					parent[col]=curr;
				}
			}		
		}
		int MaxLen=-1;
		int destination=-1;
		for(int col=0;col<n;col++)
		{
			System.out.print(dis[col]+" ");
			if(dis[col]>MaxLen)
			{
				MaxLen=dis[col];
				destination=col;
			}
		}
		int curr=destination;
		System.out.println("\n\nMaximum length/cost is :"+MaxLen);
		System.out.println("The path is as follows : ");
		ArrayList<Integer> result=new ArrayList<Integer>();
		while(parent[curr]!=-1)
		{
			result.add(0,curr);
			curr=parent[curr];
		}
		result.add(0,curr);
		System.out.println(result);

	}
	private static void topologicalSort(Stack<Integer> st, int[][] graph, Set<Integer> visited, int source)
	{		
		visited.add(source);
		for(int col=0;col<graph[0].length;col++)
		{
			if(graph[source][col]==0||visited.contains(col))
				continue;
			topologicalSort(st,graph,visited,col);			
		}
		st.add(source);
	}
}


