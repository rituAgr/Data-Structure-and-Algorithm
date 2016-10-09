package Graphs;

import java.util.Arrays;

/*
 * http://www.geeksforgeeks.org/greedy-algorithms-set-5-prims-minimum-spanning-tree-mst-2/
 * Time complexity =O(n^2)
 * Space complexity = O(n)
 */
public class primMST_N2 {

	public static void main(String[] args) {
		/* Let us create the following graph
        2    3
    (0)--(1)--(2)
     |   / \   |
    6| 8/   \5 |7
     | /     \ |
    (3)-------(4)
          9          */
		int graph[][] =new int[][]{{0, 2, 0, 6, 0},
			{2, 0, 3, 8, 5},
			{0, 3, 0, 0, 7},
			{6, 8, 0, 0, 9},
			{0, 5, 7, 9, 0},};
			primMST_N2 ob=new primMST_N2();
			ob.MST(graph);
	}
	private void MST(int[][] graph)
	{
		int n=graph.length;
		boolean mSet[]=new boolean[n];
		int[] weights=new int[n];
		int parent[]=new int[n];
		Arrays.fill(parent, -1);
		Arrays.fill(weights, Integer.MAX_VALUE);
		weights[0]=0;
		for(int i=0;i<n-1;i++)
		{
			int u =minKey(weights,mSet);
			mSet[u]=true;
			for(int v=0;v<n;v++)
			{
				if(graph[u][v]==0||mSet[v]==true||graph[u][v]>weights[v])
					continue;
				weights[v]=graph[u][v];
				parent[v]=u;
			}
		}
		
		for(int i=0;i<n;i++)
		{
			if(parent[i]==-1)
				continue;
			System.out.println(parent[i]+" -> "+i+"  =  "+graph[i][parent[i]]);
		}
	}
	private int minKey(int[] weights,boolean mSet[])
	{
		int minKey=-1,minWeight=Integer.MAX_VALUE;
		for(int i=0;i<weights.length;i++)
			if(mSet[i]==false&&minWeight>weights[i])
			{
				minKey=i;
				minWeight=weights[i];
			}
		return minKey;
	}
}
