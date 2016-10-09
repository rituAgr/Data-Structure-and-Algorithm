package Graphs;/*
* To detect cycle in undirected graph by using DFS
* I will using DFS method in this program.
*/
import java.util.*;
public class Detect_cycle_UndirectedGraph_DFS
{
	public static void main(String args[])
	{
		UndirectedGraph graph=new UndirectedGraph(6);
		graph.addEdge(0, 1);
		graph.addEdge(1, 2);
		graph.addEdge(0, 3);
		graph.addEdge(3, 4);
		graph.addEdge(4, 5);
		graph.addEdge(5, 1);
		Detect_cycle_UndirectedGraph_DFS d=new Detect_cycle_UndirectedGraph_DFS();
		System.out.println("Does cycle exist : "+d.isCyclic(graph));
	}
	private boolean isCyclic(UndirectedGraph graph)
	{
		boolean status=false;
		int n=graph.list.length;
		boolean[] visited=new boolean[n];
		Stack<AdjNode> st=new Stack<AdjNode>();
		for(int i=0;i<n;i++)
		{
			if(!visited[graph.list[i].head.value])
				status=DFS(st,visited,graph.list[i].head,graph);
			if(status)
				return true;
		}
		return status;
	}
	private boolean DFS(Stack<AdjNode> st,boolean[] visited,AdjNode node,UndirectedGraph graph)
	{
		visited[node.value]=true;
		AdjNode curr=graph.list[node.value].head;
		while(curr.next!=null)
		{
			curr=curr.next;
			if(!visited[curr.value])
				DFS(st,visited,curr,graph);
			else
				return true;
		}
		st.push(node);	
		return false;
	}
}

