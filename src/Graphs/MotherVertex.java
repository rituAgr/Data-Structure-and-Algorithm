package Graphs;

import java.util.*;

/*
 * http://www.geeksforgeeks.org/find-a-mother-vertex-in-a-Graph123/
 * Time Complexity : O(V + E)
 */

public class MotherVertex
{	
	public static void main(String[] args)
	{
		DirectedGraph g=new DirectedGraph(7);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 3);
		g.addEdge(4, 1);
		g.addEdge(6, 4);
		g.addEdge(5, 6);
		g.addEdge(5, 2);
		g.addEdge(6, 0);
		MotherVertex m=new MotherVertex();
		m.find_MotherVertex(g);
	}
	private void find_MotherVertex(DirectedGraph g)
	{
		Set<AdjNode> visited=new HashSet<AdjNode>();
		for(int i=0;i<g.list.length;i++)
		{
			visited.clear();
			DFS(g,g.list[i].head,visited);
			if(visited.size()==g.list.length)
				System.out.println(g.list[i].head.value+" is a mother vertex");
		}
	}
	private void DFS(DirectedGraph g,AdjNode node,Set<AdjNode> visited)
	{
		AdjNode curr=g.list[node.value].head;
		visited.add(curr);
		while(curr.next!=null)
		{
			curr=curr.next;
			if(!visited.contains(curr))
				DFS(g,curr,visited);
		}
	}
}
