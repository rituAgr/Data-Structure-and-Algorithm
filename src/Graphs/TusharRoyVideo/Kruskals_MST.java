package Graphs.TusharRoyVideo;

import java.util.ArrayList;
import java.util.Arrays;

public class Kruskals_MST {
	static class edge implements Comparable<edge>
	{
		int start;
		int end;
		int weight;
		edge(int s,int e, int wt)
		{
			start=s;
			end=e;
			weight=wt;
		}
		public int compareTo(edge e2)
		{
			return this.weight-e2.weight;
		}

	}
	public static void main(String[] args)
	{
		int n=4;
		ArrayList<edge> res=new ArrayList<edge>();
		Kruskals_MST mst=new Kruskals_MST(n);
		edge[] edges=new edge[n+1];
		edges[0]=new edge(0,1,10);
		edges[1]=new edge(0,2,6);
		edges[2]=new edge(0,3,5);
		edges[3]=new edge(1,3,15);
		edges[4]=new edge(2,3,4);
		Arrays.sort(edges);
		for(int i=0;i<(n+1);i++)
			if(mst.union(edges[i].start,edges[i].end))
				res.add(edges[i]);
		for(edge e: res)
			System.out.println(e.start+" "+e.end+" -> "+e.weight);
	}
	int[] arr;
	int parent[];
	Kruskals_MST(int n)
	{
		arr=new int[n];
		parent=new int[n];
		for(int i=0;i<n;i++)
			makeSet(i);
	}
	void makeSet(int i)
	{
		arr[i]=i;
		parent[i]=i;
	}
	int findSet(int j)
	{
		while(j!=parent[j])
			j=parent[j];
		return j;
	}
	boolean union(int a, int b)
	{
		int first=findSet(a);
		int sec=findSet(b);
		if(first==sec)
			return false;
		parent[sec]=first;
		return true;
	}
	
}
