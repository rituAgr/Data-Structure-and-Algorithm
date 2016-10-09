package Graphs.TusharRoyVideo;

import java.util.*;

/*
 * https://www.youtube.com/watch?v=GiN3jRdgxU4&list=PLrmLmBdmIlpu2f2g8ltqaaCZiq6GJvl1j&index=13
 */
public class MaxFlow_FordFulkerson_EdmondsKarp
{
	public static void main(String[] args) 
	{
		int[][] capacity = {{0, 3, 0, 3, 0, 0, 0},
				{0, 0, 4, 0, 0, 0, 0},
				{3, 0, 0, 1, 2, 0, 0},
				{0, 0, 0, 0, 2, 6, 0},
				{0, 1, 0, 0, 0, 0, 1},
				{0, 0, 0, 0, 0, 0, 9},
				{0, 0, 0, 0, 0, 0, 0}};
		int max=MaxFlow(capacity,0,6);
		System.out.println("Max flow is "+max);
	}
	private static int MaxFlow(int[][] capacity,int source, int sink)
	{
		int row=capacity.length;
		int col=capacity[0].length;
		int[][] residualCapacity=new int[row][col];
		for(int i=0;i<row;i++)
			for(int j=0;j<col;j++)
				residualCapacity[i][j]=capacity[i][j];
		int maxflow=0;
		ArrayList<ArrayList<Integer>> paths=new ArrayList<ArrayList<Integer>>();
		while(true)
		{
			HashMap<Integer,Integer> parent=new HashMap<Integer,Integer>();
			boolean status=BFS(residualCapacity,parent,source,sink);
			if(!status)
				break;
			ArrayList<Integer> path=new ArrayList<Integer>();
			int curr=sink;
			path.add(curr);
			while(curr!=source)
			{
				path.add(0,parent.get(curr));
				curr=parent.get(curr);
			}
			paths.add(path);
			//finding minimum flow
			int flow=Integer.MAX_VALUE;
			int count=0;
			while(count<path.size()-1)
			{
				int u=path.get(count);
				int v=path.get(count+1);
				if(residualCapacity[u][v]<flow)
					flow=residualCapacity[u][v];
				count++;
			}
			//Adding the flow to maximum flow 
			maxflow=maxflow+flow;
			//reducing the flow amount in matrix;
			int v=sink;
			while(v!=source)
			{
				int u=parent.get(v);
				residualCapacity[u][v]=residualCapacity[u][v]-flow;
				residualCapacity[v][u]=residualCapacity[v][u]+flow;
				v=u;
			}
		}
		for(int i=0;i<row;i++)
		{
			for(int j=0;j<col;j++)
				System.out.print(residualCapacity[i][j]+" ");
			System.out.println();
		}

		for(ArrayList<Integer> p:paths)
			System.out.println(p);
		return maxflow;
	}
	private static boolean BFS (int[][] residualCapacity,HashMap<Integer,Integer> parent,int source,int sink)
	{
		Set<Integer> visited=new HashSet<Integer>();
		Queue<Integer> q=new LinkedList<Integer>();
		q.add(source);
		visited.add(source);
		boolean found=false;
		while(!q.isEmpty())
		{
			int curr=q.poll();
			for(int i=0;i<residualCapacity[0].length;i++)
				if(residualCapacity[curr][i]>0&&!visited.contains(i))
				{
					q.add(i);
					visited.add(i);
					parent.put(i, curr);
					if(i==sink)
					{
						found=true;
						break;
					}
				}		
		}
		return found;
	}
}
