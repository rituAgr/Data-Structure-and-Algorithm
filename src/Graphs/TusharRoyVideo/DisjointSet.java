package Graphs.TusharRoyVideo;
/*
 * https://www.youtube.com/watch?v=ID00PMy0-vE&index=5&list=PLrmLmBdmIlpu2f2g8ltqaaCZiq6GJvl1j
 */
public class DisjointSet 
{
	class Node
	{
		int data;
		Node parent;
		int rank;
		Node(int data, int rank)
		{
			this.data=data;
			this.parent=this;
			this.rank=rank;
		}
	}
	Node[] Nodes;
	DisjointSet(int n)
	{
		Nodes=new Node[n];
		for(int i=0;i<n;i++)
			Nodes[i]=new Node(i,0);
	}
	Node findSet(int data)
	{
		Node n=Nodes[data];
		while(n.parent!=n)
			n=n.parent;
		return n;
	}
	boolean union(int data1, int data2)
	{
		Node parent1=findSet(data1);
		Node parent2=findSet(data2);
		if(parent1==parent2)
			return false;
		if(parent1.rank==parent2.rank)
		{
			parent1.rank=1+parent1.rank;
			parent2.parent=parent1;
		}
		else if(parent1.rank>parent2.rank)
			parent2.parent=parent1;
		else
			parent1.parent=parent2;
		return true;
	}
	public static void main(String[] args) 
	{
		DisjointSet ds=new DisjointSet(8);
		 ds.union(1, 2);
	        ds.union(2, 3);
	        ds.union(4, 5);
	        ds.union(6, 7);
	        ds.union(5, 6);
	        ds.union(3, 7);
	        System.out.println(ds.findSet(0).data);
	        System.out.println(ds.findSet(1).data);
	        System.out.println(ds.findSet(2).data);
	        System.out.println(ds.findSet(3).data);
	        System.out.println(ds.findSet(4).data);
	        System.out.println(ds.findSet(5).data);
	        System.out.println(ds.findSet(6).data);
	        System.out.println(ds.findSet(7).data);
	}

}

