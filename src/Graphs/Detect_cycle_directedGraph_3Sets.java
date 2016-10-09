package Graphs;/*
http://www.geeksforgeeks.org/detect-cycle-in-a-graph/
Time complexity : O(V+E)
Space complexity : O(V)
 */
import java.util.Arrays;

public class Detect_cycle_directedGraph_3Sets
{
	public static void main(String[] args)
	{
		DirectedGraph g=new DirectedGraph(4);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);
		System.out.println("Does cycle exist : "+detectCycle(g));
	}
	private static boolean detectCycle(DirectedGraph g)
	{
		int n=g.list.length;
		boolean[] white=new boolean[n];
		boolean[] gray=new boolean[n];
		boolean[] black=new boolean[n];
		Arrays.fill(white,true);
		boolean status=false;
		for(int i=0;i<n;i++)
		{
			if(white[i]==true)
				status=DFSUtil(white,gray,black,i, g);
			if(status)
				return true;
		}
		return false;
	}
	private static boolean DFSUtil(boolean[] white,boolean[] gray,boolean[] black,int i,DirectedGraph g)
	{
		white[i]=false;
		gray[i]=true;
		AdjNode head=g.list[i].head;
		AdjNode curr=head;
		while(curr.next!=null)
		{
			curr=curr.next;
			int val=curr.value;
			if(gray[val])
				return true;
			if(!black[val])
			{
				boolean status=DFSUtil(white,gray,black,curr.value, g);
				if(status)
					return true;
			}
		}
		gray[i]=false;
		black[i]=true;
		return false;
	}
}











