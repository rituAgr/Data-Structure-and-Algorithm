package Graphs.TusharRoyVideo;

import java.util.ArrayList;
class Edge1
{
	int vertex1,vertex2;
	public int end;
	Edge1(int ver1, int ver2)
	{
		vertex1=ver1;
		vertex2=ver2;
	}
}
public class DetectCycle_UndirectedGraph {

	public static void main(String[] args) {
		int n=6;
		DisjointSet1 ds=new DisjointSet1(n);
		ArrayList<Edge1> edges=new ArrayList<Edge1>();
		edges.add(new Edge1(0,1));
		edges.add(new Edge1(1,2));
		edges.add(new Edge1(0,3));
		edges.add(new Edge1(3,4));
		edges.add(new Edge1(4,5));
		edges.add(new Edge1(5,1));
		boolean status=ds.isCycle(edges);
		System.out.println(status);
	}

}

class DisjointSet1
{
	int set[];
	int parent[];
	//ArrayList<Edge> edges=new ArrayList<Edge>();
	DisjointSet1(int ver)
	{
		set=new int[ver];
		parent=new int[ver];
		for(int i=0;i<ver;i++)
		{
			set[i]=i;
			parent[i]=i;
		}
	}
	int getParent(int element)
	{
		while(element!=parent[element])
			element=parent[element];
		return element;
	}
	boolean union(int ver1, int ver2)
	{
		int parent1=getParent(ver1);
		int parent2=getParent(ver2);
		if(parent1==parent2)
			return false;
		parent[parent2]=parent1;
		return true;
	}
	boolean isCycle(ArrayList<Edge1> edges)
	{
		for(Edge1 e:edges)
			if(union(e.vertex1,e.vertex2)==false)
				return true;
		return false;
	}
}
