package Graphs;

import java.util.*;

/*
 * http://www.geeksforgeeks.org/transitive-closure-of-a-graph-using-dfs/
 */
public class TransitiveClosure {

	public static void main(String[] args)
	{
		DirectedGraph g=new DirectedGraph(4);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);
		TransitiveClosure t=new TransitiveClosure();
		t.transitiveClosure(g);
	}
	private void transitiveClosure(DirectedGraph g)
	{
		int n=g.list.length;
		boolean matrix[][]=new boolean[n][n];
		for(int i=0;i<n;i++)
		{
			Stack<AdjNode> st=new Stack<AdjNode>();
			Set<AdjNode> visited=new HashSet<AdjNode>();
			AdjNode node=g.list[i].head;
			DFS(g,node,st,visited);
			while(!st.isEmpty())
			{
				int val=st.pop().value;
				matrix[i][val]=true;
			}
		}
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
				System.out.print(matrix[i][j]+"  ");
			System.out.println();
		}
	}
	private void DFS(DirectedGraph g,AdjNode n,Stack<AdjNode> st,Set<AdjNode> visited)
	{	
		visited.add(n);
		AdjList list=g.list[n.value];
		AdjNode node=list.head;		
		while(node.next!=null)
		{
			node=node.next;
			if(!visited.contains(node))
				DFS(g,node,st,visited);
		}
		st.add(n);
	}
}
