package Graphs;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * http://www.geeksforgeeks.org/greedy-algorithms-set-6-dijkstras-shortest-path-algorithm/
 */
public class DijkstrasAlgo {

	public static void main(String[] args) {
		int[][] graph=new int[][]{{0, 4, 0, 0, 0, 0, 0, 8, 0},
			{4, 0, 8, 0, 0, 0, 0, 11, 0},
			{0, 8, 0, 7, 0, 4, 0, 0, 2},
			{0, 0, 7, 0, 9, 14, 0, 0, 0},
			{0, 0, 0, 9, 0, 10, 0, 0, 0},
			{0, 0, 4, 14, 10, 0, 2, 0, 0},
			{0, 0, 0, 0, 0, 2, 0, 1, 6},
			{8, 11, 0, 0, 0, 0, 1, 0, 7},
			{0, 0, 2, 0, 0, 0, 6, 7, 0}};
			Dijkstras(graph);
	}
	private static int minKey(boolean[] isPresent, int[] weight)
	{
		int minWeight=Integer.MAX_VALUE;
		int minIndex=-1;
		for(int i=0;i<weight.length;i++)
			if(weight[i]<minWeight&&isPresent[i]==false)
			{
				minWeight=weight[i];
				minIndex=i;
			}
		return minIndex;
	}
	private static void Dijkstras(int[][] graph)
	{
		int n=graph.length;
		int weight[]=new int[n];
		Arrays.fill(weight,Integer.MAX_VALUE);
		weight[0]=0;
		int[] parent=new int[n];
		Arrays.fill(parent,-1);
		boolean[] isPresent=new boolean[n]; 
		for(int i=0;i<n;i++)
		{
			int u=minKey(isPresent, weight);
			isPresent[u]=true;
			for(int v=0;v<n;v++)
			{
				if(graph[u][v]==0||isPresent[v]||graph[u][v]+weight[u]>weight[v])
					continue;
				weight[v]=graph[u][v]+weight[u];
				parent[v]=u;
			}
		}
		//printing the paths
	/*	for(int i=1;i<n;i++)
			System.out.println(parent[i]+" -> "+i+"  = "+weight[i]);*/
		for(int i=1;i<n;i++)
		{
			int index=i;
			ArrayList<Integer> path=new ArrayList<Integer>();
			//int sum=0;
			while(parent[index]!=-1)
			{
				path.add(0,index);
				//sum=sum+weight[index];
				index=parent[index];
			}
			path.add(0,index);
			//sum=sum+weight[index];
			System.out.println(path+"    Sum is "+weight[i]);
		}
	}
}
