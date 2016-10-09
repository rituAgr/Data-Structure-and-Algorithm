package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class AllTopologicalSorts {

	public static void main(String[] args) {
		DirectedGraph g=new DirectedGraph(6);
		g.addEdge(5, 2);
		g.addEdge(5, 0);
		g.addEdge(4, 0);
		g.addEdge(4, 1);
		g.addEdge(2, 3);
		g.addEdge(3, 1);
	}
	void topologicalSort(DirectedGraph g)
	{
		int n=g.list.length;
		//Calculating indegree of all nodes
		int inDegree[]=new int[n];
		for(int i=0;i<n;i++)
		{
			AdjNode node=g.list[i].head;
			while(node.next!=null)
			{
				node=node.next;
				inDegree[node.value]++;
			}
		}
		//Putting all zero indegree node to this arrayList
		Queue<Integer> zero_InDegree=new LinkedList<Integer>();
		for(int i=0;i<n;i++)
			if(inDegree[i]==0)
				zero_InDegree.add(i);
		//Now, forming topologically sorted arraylist
		ArrayList<Integer> result=new ArrayList<Integer>();
		int check=0;
		while(!zero_InDegree.isEmpty())
		{
			if(check==n)
				{
				check=0;
				}
			else
			{
				int i=zero_InDegree.poll();
				result.add(i);
				AdjNode node=g.list[i].head;
				while(node.next!=null)
				{
					node=node.next;		
					int x=node.value;
					inDegree[x]--;
					if(inDegree[x]==0)
						zero_InDegree.add(x);
				}
				check++;
			}
		}
		if(check<n)
		{
			System.out.println("There exist a cycle");
			return;
		}
		for(int i:result)
			System.out.print(i+"  ");
	}

}
