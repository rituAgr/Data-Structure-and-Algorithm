package Graphs.TusharRoyVideo;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class DetectCycle_directedGraph 
{
	public static void main(String[] args)
	{
		int vertices=7;
		Undirected_Graph graph=new Undirected_Graph(vertices);
		graph.addEdge(1, 2);
		graph.addEdge(1, 3);
		graph.addEdge(2, 3);
		graph.addEdge(4, 1);
		graph.addEdge(4, 5);
		graph.addEdge(5, 6);
		graph.addEdge(6, 4);
		boolean status=graph.isCyclic();
		System.out.println(status);
	}
}
class Undirected_Graph
{
	int vertices;		
	LinkedList[] lists;
	Undirected_Graph(int vertices)
	{
		this.vertices=vertices;
		lists=new LinkedList[vertices];
		for(int i=0;i<vertices;i++)
			lists[i]=new LinkedList<Integer>();
	}
	class Edge
	{
		int start;
		int end;
		Edge(int s,int e)
		{
			start=s;
			end=e;
		}
	}
	void addEdge(int s,int e)
	{
		LinkedList<Integer> pos=lists[s];
		pos.add(e);
	}
	boolean isCyclic()
	{
		Set<Integer> white=new HashSet<Integer>();
		Set<Integer> gray=new HashSet<Integer>();
		Set<Integer> black=new HashSet<Integer>();
		for(int i=0;i<vertices;i++)
			white.add(i);		
		Integer parent[]=new Integer[vertices];
		while(!white.isEmpty())
		{
			int element=(int)white.toArray()[0];
			if(utilDFS(white,gray,black,parent,element,null))
				return true;
		}
		return false;
	}
	boolean utilDFS(Set<Integer> white,Set<Integer> gray,Set<Integer> black,Integer[] parents,Integer element, Integer parent)
	{
		if(element==null)
			return false;
		white.remove(element);
		if(black.contains(element))
			return false;
		if(gray.contains(element))
		{
			parents[element]=parent;
			printPath(parents,element);
			return true;
		}
		parents[element]=parent;
		LinkedList<Integer> list=lists[element];
		gray.add(element);
		for(Integer num: list)
			if(utilDFS(white,gray,black,parents,num,element))
				return true;
		gray.remove(element);
		black.add(element);
		return false; 
	}
	void printPath(Integer[] parents,int parent)
	{
		ArrayList<Integer> res=new ArrayList<Integer>();
		while(!res.contains(parent))
		{
			res.add(parent);
			parent=parents[parent];
		}
		System.out.println(res);
	}
}

