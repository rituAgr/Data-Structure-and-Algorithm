package Graphs;

public class UndirectedGraph {
	AdjList[] list;
	UndirectedGraph(int v)
	{
		list=new AdjList[v];
		for(int i=0;i<v;i++)
			list[i]=new AdjList(new AdjNode(i));
	}
	void addEdge(int u, int v)
	{
		AdjList l1=list[u];
		AdjList l2=list[v];
		AdjNode curr1=l1.head;
		AdjNode curr2=l2.head;
		while(curr1.next!=null)
			curr1=curr1.next;
		curr1.next=new AdjNode(v);
		while(curr2.next!=null)
			curr2=curr2.next;
		curr2.next=new AdjNode(u);
	}
}
