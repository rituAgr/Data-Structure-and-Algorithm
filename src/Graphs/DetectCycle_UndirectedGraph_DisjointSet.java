package Graphs;/*
 * Detecting cycle in undirected graph using disjoint set
 * http://www.geeksforgeeks.org/union-find/
 */
import java.util.Arrays;
//import java.util.Scanner;
public class DetectCycle_UndirectedGraph_DisjointSet
{
	int V,E;
	Edge[] edge;
	class Edge
	{
		int source,destination;
	};
	DetectCycle_UndirectedGraph_DisjointSet(int v, int e)
	{
		V=v;E=e;
		edge=new Edge[e];
		for(int i=0;i<e;i++)
			edge[i]=new Edge();
	}
	int find(int[] parent, int i)
	{
		if(parent[i]==-1)
			return i;
		return find(parent,parent[i]);
	}
	void union(int parent[], int x, int y)
	{
		int x_key=find(parent,x);
		int y_key=find(parent,y);
		if(x_key==y_key)
		parent[x_key] = y_key;
	}
	boolean isCycle(DetectCycle_UndirectedGraph_DisjointSet graph)
	{
		int[] parent=new int[graph.V];
		Arrays.fill(parent, -1);
		int x,y;
		for(int i=0;i<graph.E;i++)
		{
			x=find(parent,graph.edge[i].source);
			y=find(parent,graph.edge[i].destination);
			if(x==y)
				return true;
			graph.union(parent, x, y);
		}
		return false;
	}
	public static void main(String args[])
	{
		int V = 5, E = 4;
		DetectCycle_UndirectedGraph_DisjointSet graph = new DetectCycle_UndirectedGraph_DisjointSet(V, E);
 
        // add edge 0-1
        graph.edge[0].source = 0;
        graph.edge[0].destination = 1;
 
        // add edge 1-2
        graph.edge[1].source = 0;
        graph.edge[1].destination = 3;
 
        // add edge 0-2
        graph.edge[2].source = 2;
        graph.edge[2].destination = 3;
        
        graph.edge[3].source = 3;
        graph.edge[3].destination = 4;
        
        System.out.println(graph.isCycle(graph));
	}
}

