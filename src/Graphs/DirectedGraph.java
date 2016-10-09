package Graphs;

public class DirectedGraph {
	AdjList[] list;
	DirectedGraph(int V)
	{
		list=new AdjList[V];
		for(int i=0;i<V;i++)
			list[i]=new AdjList(new AdjNode(i));
	}
	void addEdge(int s, int d)
	{
		AdjNode Node=list[s].head;
		while(Node.next!=null)
			Node=Node.next;
		Node.next=new AdjNode(d);
	}
}
//
class AdjNode
{
	int value;
	AdjNode next;
	AdjNode(int val)
	{
		value=val;
	}
}
class AdjList
{
	AdjNode head;
	AdjList(AdjNode head)
	{
		this.head=head;
	}
}

