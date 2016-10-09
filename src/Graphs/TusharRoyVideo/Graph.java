package Graphs.TusharRoyVideo;

import java.util.ArrayList;
import java.util.HashMap;
public class Graph<T>
{	
	HashMap<T, Vertex> hm=new HashMap<T, Vertex>();
	ArrayList<Edge> EdgesList=new ArrayList<Edge>();
	boolean directed;
	Graph(boolean dir)
	{
		directed=dir;
	}
	void addEdge(T i, T j, int wt)
	{
		Vertex v1;//
		Vertex v2;//=new Vertex(j);
		if(hm.containsKey(i))
			v1=hm.get(i);
		else
		{ 
			v1=new Vertex(i);
			hm.put(i, v1);
		}
		if(hm.containsKey(j))
			v2=hm.get(j);
		else
		{ 
			v2=new Vertex(j);
			hm.put(j,v2);
		}
		Edge e=new Edge(v1,v2,directed, wt);
		EdgesList.add(e);
		v1.addVertex(v2);
		v1.addEdge(e);
		if(!directed)
		{
			v2.addVertex(v1);
			v2.addEdge(e);	
		}
	}
	ArrayList<Vertex<T>> getconnected_Vertices(int x)
	{
		Vertex v=hm.get(x);
		return v.getconnected_Vertices();
	}
	ArrayList<Vertex> getAllVertices()
	{
		ArrayList<Vertex> res=new ArrayList<Vertex>();// hm.values();
		for(Vertex v: hm.values())
			res.add(v);
		return res;
	}
}
class Vertex<T>
{
	T data;
	ArrayList<Edge<T>> adjacent_Edges=new ArrayList<Edge<T>>();
	ArrayList<Vertex<T>> connected_Vertices=new ArrayList<Vertex<T>>();
	Vertex(T data)
	{
		this.data=data;
	}
	void addEdge(Edge<T> e)
	{
		adjacent_Edges.add(e);
	}
	ArrayList<Edge<T>> getEdges()
	{
		return adjacent_Edges;
	}
	void addVertex(Vertex<T> v)
	{
		connected_Vertices.add(v);
	}
	ArrayList<Vertex<T>> getconnected_Vertices()
	{
		return connected_Vertices;
	}
	@Override
	public boolean equals(Object o)
	{
		if(o==null)
			return false;
		if(this==o)
			return true;
		if(this.getClass()!=o.getClass())
			return false;
		Vertex<T> other=(Vertex)o;
		if(this!=other)
			return false;
		return true;
	}
}
class Edge<T>
{
	Vertex<T> start;
	Vertex<T> end;
	boolean isDirected;
	int weight;
	Edge( Vertex<T> start,Vertex<T> end)
	{
		this.start=start;
		this.end=end;
	}
	Edge( Vertex<T> start,Vertex<T> end,boolean isDirected,int weight)
	{
		this.start=start;
		this.end=end;
		this.isDirected=isDirected;
		this.weight=weight;
	}
	Edge( Vertex<T> start,Vertex<T> end,boolean isDirected)
	{
		this.start=start;
		this.end=end;
		this.isDirected=isDirected;
	}
	@Override
	public boolean equals(Object o)
	{
		if(o==null)
			return false;
		if(this==o)
			return true;
		if(this.getClass()!=o.getClass())
			return false;
		Edge other=(Edge)o;
		if(!start.equals(other)||!end.equals(other.end))
			return false;
		return true;
	}
}
