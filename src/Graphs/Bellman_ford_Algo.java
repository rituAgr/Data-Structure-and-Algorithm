package Graphs;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * http://www.geeksforgeeks.org/dynamic-programming-set-23-bellman-ford-algorithm
 * Time complexity - O(EV)
 * Space complexity - O(V)
 */
public class Bellman_ford_Algo {
	static class edge
	{
		int src,dest,weight;
		edge(int src, int dest,int weight)
		{
			this.src=src;
			this.dest=dest;
			this.weight=weight;
		}
	}
	public static void main(String[] args) {
		edge[] Edges=new edge[8];
		Edges[0]=new edge(0,1,-1);
		Edges[1]=new edge(0,2,4);
		Edges[2]=new edge(1,2,3);
		Edges[3]=new edge(1,3,2);
		Edges[4]=new edge(1,4,2);
		Edges[5]=new edge(3,2,5);
		Edges[6]=new edge(3,1,1);
		Edges[7]=new edge(4,3,-3);


		BellmanFord(Edges,5,0);
	}
	static void BellmanFord(edge[] Edges,int vertex, int start)
	{
		int[] distance=new int[vertex];
		Arrays.fill(distance,100000);
		distance[start]=0;
		int[] parent=new int[vertex];
		Arrays.fill(parent,-1);
		//Calculation the minimum distances
		for(int i=0;i<vertex-1;i++)
		{
			for(int j=0;j<Edges.length;j++)
			{
				int source=Edges[j].src;
				int dest=Edges[j].dest;
				int edgeWeight=Edges[j].weight;
				if(distance[source]+edgeWeight<distance[dest])
				{
					distance[dest]=distance[source]+edgeWeight;
					parent[dest]=source;
				}
			}
		}
		//Checking if there exist a negative weight cycle
		for(int j=0;j<Edges.length;j++)
		{
			int source=Edges[j].src;
			int dest=Edges[j].dest;
			int edgeWeight=Edges[j].weight;
			if(distance[source]+edgeWeight<distance[dest])
			{
				System.out.println("There exist a negative weight cycle");
				return;
			}
		}
		//printing the minimum path
		for(int i=0;i<vertex;i++)
		{
			if(i==start)
				continue;
			int index=i;
			ArrayList<Integer> res=new ArrayList<Integer>();

			while(index!=-1)
			{
				res.add(0,index);
				index=parent[index];
			}
			System.out.println(res+"  = "+distance[i]);
		}
	}
}
