package Graphs.TusharRoyVideo;

import java.util.ArrayList;
import java.util.Arrays;
/*
 * Time complexity = O(n^2)
 * Space complexity=O(n)
 */
public class Bellman_Ford_Algorithm 
{
	static class Vertex
	{
		int value;
		Vertex(int v)
		{
			value=v;
		}
	}
	static class Edge
	{
		Vertex start,end;
		int weight;
		Edge(Vertex v1,Vertex v2,int wt)
		{
			start=v1;
			end=v2;
			weight=wt;
		}
	}
	public static void main(String[] args)
	{
		int n=5;
		Vertex[] ver=new Vertex[n];
		for(int i=0;i<n;i++)
			ver[i]=new Vertex(i);
		Edge[] edges=new Edge[7];
		edges[0]=new Edge(ver[0],ver[3], 8);
		edges[1]=new Edge(ver[0],ver[ 1], 4);
		edges[2]=new Edge(ver[0],ver[2], 5);
		edges[3]=new Edge(ver[1],ver[2], -3);
		edges[4]=new Edge(ver[2],ver[4], 4);
		edges[5]=new Edge(ver[3],ver[4], 2);
		edges[6]=new Edge(ver[4],ver[3], 1);
		BellmanFord(edges,n,0);
	}
	static void BellmanFord(Edge[] edges,int n,int source)
	{
		Vertex[] parent=new Vertex[n];
		int[] distance=new int[n];
		Arrays.fill(parent,null);
		Arrays.fill(distance,Integer.MAX_VALUE-10000);
		distance[source]=0;
		for(int i=1;i<n;i++)
			for(Edge e: edges)
			{
				int ver1=e.start.value;
				int ver2=e.end.value;
				if(distance[ver2]>distance[ver1]+e.weight)
				{
					distance[ver2]=distance[ver1]+e.weight;
					parent[ver2]=e.start;
				}
			}
		for(Edge e: edges)
		{
			int ver1=e.start.value;
			int ver2=e.end.value;
			if(distance[ver2]>distance[ver1]+e.weight)
			{System.out.println("There exist negative weight cycle");
			return;}
		}
		printPath(source,parent);
	}
	static void printPath(int source,Vertex[] parent)
	{
		System.out.println("Following below are paths");
		for(int k=0;k<parent.length;k++)
		{
			if(k==source)
				continue;
			int i=k;
			ArrayList<Integer> res=new ArrayList<Integer>();
			while(parent[i].value!=source)
			{
				res.add(0,i);
				i=parent[i].value;
			}
			res.add(0,i);
			res.add(0,source);
			System.out.println(res.toString());
		}
	}
}

