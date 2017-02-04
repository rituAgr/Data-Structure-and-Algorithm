package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
/*
 * http://www.geeksforgeeks.org/greedy-algorithms-set-2-kruskals-minimum-spanning-tree-mst/
 * time complexity : O(E logn)
 */
public class KruskalsMST
{
	static class Edge implements Comparable<Edge>
	{
		int start,end, cost;
		Edge(int source, int dest, int weight)
		{
			start=source;
			end=dest;
			cost=weight;
		}
		@Override
		public int compareTo(Edge o) {
			return this.cost-o.cost;
		}
	}
	public static void main(String[] args)
	{
		/* Let us create following weighted graph
        10
   0--------1
   |  \     |
  6|   5\   |15
   |      \ |
   2--------3 */

		/*int[][] edges=new int[][]{{0,10,6,5},
			{
		}*/

		Edge[] edges=new Edge[5];
		edges[0]=new Edge(0,1,10);
		edges[1]=new Edge(0,2,6);
		edges[2]=new Edge(0,3,5);
		edges[3]=new Edge(1,3,15);
		edges[4]=new Edge(2,3,4);
		KruskalsMST m=new KruskalsMST();
		m.KruskalMST(edges,4);
	}
	 void KruskalMST(Edge[] edges,int vertices)
	{
		Arrays.sort(edges);
		ArrayList<Edge> result=new ArrayList<Edge>();
		Disjoint_Set ds=new Disjoint_Set();
		for(int i=0;i<vertices;i++)
			ds.create_set(i);
		for(int i=0;i<edges.length;i++)
		{
			if(isCyclic(ds,edges[i].start, edges[i].end))
				continue;
			result.add(edges[i]);
			if(result.size()==vertices-1)
				break;
		}
		//Printing
		for(Edge e: result)
			System.out.println(e.start+" -> "+e.end+" = "+e.cost);
	}
	 static boolean isCyclic(Disjoint_Set ds,int s, int d)
	{
		return ds.union(s, d);
	}
}
