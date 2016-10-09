package Graphs;

import java.util.HashMap;
import java.util.Stack;

/*
 * http://www.geeksforgeeks.org/assign-directions-to-edges-so-that-the-directed-graph-remains-acyclic/
 */
public class Assign_Direction
{
	public static void main(String[] args) 
	{
		DirectedGraph g=new DirectedGraph(6);
		//The below mentioned graph is the one from GFG pictorial graph( the mixuture of directed and undirected edges
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(0, 3);
		g.addEdge(0, 5);
		g.addEdge(1,2);
		g.addEdge(1,3);
		g.addEdge(2,0);
		g.addEdge(2,3);
		g.addEdge(2,4);
		g.addEdge(3,0);
		g.addEdge(3,4);
		g.addEdge(4,5);
		g.addEdge(5,1);
		g.addEdge(5,2);
		g.addEdge(5,4);
		Assign_Direction a=new Assign_Direction();
		a.Assign_DirectionUtil(g);
	}
	void Assign_DirectionUtil(DirectedGraph g)
	{
		int l=g.list.length;
		Stack<AdjNode> st=new Stack<AdjNode>();
		boolean[] visited=new boolean[l];
		for(int i=0;i<l;i++)
		{
			AdjNode node=g.list[i].head;
			if(!visited[node.value])
				topologicalSort(g, node,st, visited);
		}
		HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();
		int pos=0;
		while(!st.isEmpty())
		{
			int val=st.pop().value;
			hm.put(val, pos++);
			System.out.print(val+"  ");
		}
		System.out.println();
		for(int i=0;i<l;i++)
		{
			AdjNode curr=g.list[i].head;
			System.out.print(curr.value);
			while(curr.next!=null)
			{
				curr=curr.next;
				if(!isUndirected(g,i,curr.value))
					System.out.print(" -> "+curr.value);
				else if(hm.get(curr.value)>hm.get(i))
					System.out.print(" -> "+curr.value);
			}
			System.out.println();
		}
	}
	void topologicalSort(DirectedGraph g,AdjNode node,Stack<AdjNode> st, boolean[] visited)
	{
		visited[node.value]=true;
		AdjNode curr=g.list[node.value].head;
		while(curr.next!=null)
		{	
			curr=curr.next;
			//for making topological sort, only directed edges are considered
			if(isUndirected(g,node.value,curr.value))
				continue;
			if(visited[curr.value])
				continue;
			topologicalSort(g, curr,st, visited);
		}
		st.push(node);
	}
	boolean isUndirected(DirectedGraph g,int s, int d)
	{
		AdjNode source=g.list[d].head;
		while(source.next!=null)
		{
			source=source.next;
			if(source.value==s)
				return true;
		}
		return false;
	}
}
