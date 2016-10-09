
package Graphs.TusharRoyVideo;

import java.util.*;

public class Articulation_Point
{
	static int time=0;
	public static void main(String[] args)
	{
		Graph<Integer> graph=new Graph(false);
		graph.addEdge(1, 2,0);
		graph.addEdge(2, 3,0);
		graph.addEdge(1, 3,0);
		graph.addEdge(1, 4,0);
		graph.addEdge(4, 5,0);
		graph.addEdge(5, 6,0);
		graph.addEdge(6, 7,0);
		graph.addEdge(7, 5,0);
		graph.addEdge(6, 8,0);
		ArticulationPoint(graph);
	}
	private static void ArticulationPoint(Graph graph)
	{
		Set<Vertex> visited=new HashSet<Vertex>();
		Set<Vertex> AP=new HashSet<Vertex>();
		HashMap<Vertex,Vertex> parents =new HashMap<Vertex,Vertex>();
		HashMap<Vertex,Integer> visitedTime=new HashMap<Vertex,Integer>();
		HashMap<Vertex,Integer> lowTime=new HashMap<Vertex,Integer>();
		Vertex start=(Vertex) graph.getAllVertices().get(0);
		DFS(visited,AP,parents,null,start,visitedTime,lowTime);
		for(Vertex v: AP)
			System.out.println(v.data);
	}
	private static void DFS(Set<Vertex> visited,Set<Vertex> AP,HashMap<Vertex,Vertex> parents,Vertex parent,Vertex startVertex,HashMap<Vertex,Integer> visitedTime,HashMap<Vertex,Integer> lowTime)
	{
		visited.add(startVertex);
		parents.put(startVertex, parent);
		visitedTime.put(startVertex, time);
		lowTime.put(startVertex, time);
		time++;
		int child=0;
		ArrayList<Vertex> connected=startVertex.getconnected_Vertices();
		for(int i=0;i<connected.size();i++)
		{
			child++;
			Vertex v=connected.get(i);
			if(v.equals(parent))
				continue;
			if(!visited.contains(v))
			{
				DFS(visited,AP,parents,startVertex,v,visitedTime,lowTime);
				if(visitedTime.get(startVertex)<=lowTime.get(v))
					AP.add(startVertex);
				else
				{
					int t = Math.min(lowTime.get(startVertex),lowTime.get(v));
					lowTime.put(startVertex, t);
				}
			}
			else
			{
				int t = Math.min(lowTime.get(startVertex),visitedTime.get(v));
				lowTime.put(startVertex, t);
			}
		}
		if(parents.get(startVertex)==(null)&&child>=2)
			AP.add(startVertex);
	}
}
