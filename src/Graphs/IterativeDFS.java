package Graphs;/*
 * http://www.geeksforgeeks.org/iterative-depth-first-traversal/
 */
import java.util.*;
public class IterativeDFS
{
	public static void main(String[] args)
	{
		DirectedGraph g=new DirectedGraph(5);
		   g.addEdge(1, 0);
		    g.addEdge(0, 2);
		    g.addEdge(2, 1);
		    g.addEdge(0, 3);
		    g.addEdge(3, 4);
		    g.addEdge(4, 0);
		DFS(g);
	}
	private static void DFS(DirectedGraph g)
	{
		int n=g.list.length;
		boolean[] visited=new boolean[n];
		//It is better to use boolean array to check if it is visited or not; because if we use set of adjNode, it will compares
		//not the node value or also its next AdjNode. This is different if the node is as head bode of a list or it is in path
		//node. There it gives false value; SO BETTER MAKE A HABBIT OF USING BOOLEAN ARRAY
		ArrayList<AdjNode> res=new ArrayList<AdjNode>();
		Stack<AdjNode> st=new Stack<AdjNode>();
		for(int i=0;i<n;i++)
		{
			AdjNode source=g.list[i].head;
			if(visited[i])
				continue;
			st.push(source);
			visited[source.value]=true;
			while(!st.isEmpty())
			{
				AdjNode curr=st.pop();
				res.add(curr);
				while(curr.next!=null)
				{
					curr=curr.next;
					if(visited[curr.value])
						continue;
					st.push(curr);
					visited[curr.value]=true;
				}
			}
		}
		for(AdjNode node:res)
			System.out.print(node.value+" ");
	}
}
