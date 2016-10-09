package Graphs.TusharRoyVideo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class StronglyConnectedComponent {
	public static void main(String[] args) 
	{
		int n=7;
		Vertex[] vertices=new Vertex[n];
		for(int i=0;i<n;i++)
			vertices[i]=new Vertex(i);
		vertices[0].addEdge(vertices[1]);
		vertices[1].addEdge(vertices[2]);
		vertices[2].addEdge(vertices[0]);
		vertices[1].addEdge(vertices[3]);
		vertices[3].addEdge(vertices[4]);
		vertices[4].addEdge(vertices[5]);
		vertices[5].addEdge(vertices[3]);
		vertices[5].addEdge(vertices[6]);
		StronglyConnectedComponents(vertices);
	}
	static class Vertex
	{
		int value;
		ArrayList<Vertex> connected;
		ArrayList<Vertex> reverseConnected;
		Vertex(int data)
		{
			connected=new ArrayList<>();
			reverseConnected=new ArrayList<>();
			value=data;
		}
		void addEdge(Vertex v)
		{	
			connected.add(v);
			addreverseEdge(v);
		}
		void addreverseEdge(Vertex v)
		{	
			v.reverseConnected.add(this);	
		}
		ArrayList<Vertex> getallConnectedEdges()
		{
			return connected;
		}
		ArrayList<Vertex> getReverseConnectedEdges()
		{
			return reverseConnected;
		}
	}

	static void StronglyConnectedComponents(Vertex[] vertices)
	{
		Stack<Vertex> st=new Stack<Vertex>();
		Set<Vertex> visited=new HashSet<Vertex>();
		for(Vertex ver:vertices)
			if(!visited.contains(ver))
				DFS(st,visited,ver);
		//Below code is just to see if both vertex class arraylist are wrking as it is supposed to be
		/*	for(Vertex ver:vertices)
			{
			ArrayList<Vertex> v1=ver.getReverseConnectedEdges();
			System.out.println("For vertex :"+ver.value+" connected vertices are ");
			for(Vertex v:v1)
				System.out.println(v.value);
			}*/
		visited.clear();
		ArrayList<ArrayList<Vertex>> res=new ArrayList<ArrayList<Vertex>>();
		Vertex curr=st.peek();
		while(!st.isEmpty())
		{	
			curr=st.peek();
			if(visited.contains(curr))
				st.pop();
			else
			{
				ArrayList<Vertex> res1=new ArrayList<Vertex>();
				DFS2(st,visited,curr,res1);
				res.add(res1);
			}
		}		
		for(ArrayList<Vertex> list:res)
		{
			for(Vertex v:list)
				System.out.print(v.value+"  ");	
			System.out.println();	
		}
	}

	static void DFS(Stack<Vertex> st,Set<Vertex> visited,Vertex curr)
	{
		if (visited.contains(curr))
			return;
		visited.add(curr);
		ArrayList<Vertex> l=curr.getallConnectedEdges();
		for(Vertex ver:l)
			DFS(st,visited,ver);
		st.add(curr);
	}
	static void DFS2(Stack<Vertex> st,Set<Vertex> visited,Vertex curr,ArrayList<Vertex> res)
	{
		if (visited.contains(curr))
			return;
		visited.add(curr);
		res.add(curr);
		ArrayList<Vertex> l=curr.getReverseConnectedEdges();
		for(Vertex ver:l)
			DFS2(st,visited,ver,res);
		st.add(curr);
	}
}
