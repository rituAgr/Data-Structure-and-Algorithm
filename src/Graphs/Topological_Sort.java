package Graphs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

/*
 * http://www.geeksforgeeks.org/topological-sorting/
 * Better video explanation : https://www.youtube.com/watch?v=ddTC4Zovtbc
 * input : 6 6
 * edges : 6 3
6 1
5 1
5 2
3 4
4 2
 */
public class Topological_Sort {
	int num_ver;
	HashMap<Integer, LinkedList<Integer>> hm;
	Topological_Sort(int v)
	{
		num_ver=v;
		hm=new HashMap<Integer, LinkedList<Integer>>();
		for(int i=1;i<=v;i++)
			hm.put(i,new LinkedList<Integer>());
	}
	void set_edge(int v1, int v2)
	{
		//Since, it is directed graph
		LinkedList<Integer> l1=hm.get(v1);
		l1.add(v2);
	}
	public static void main(String[] args)
	{
		System.out.println("Enter the number of vertices and edges in the graph");
		int ver,edges;
		Scanner scan = new Scanner(System.in);
		ver= scan.nextInt();
		edges= scan.nextInt();
		Topological_Sort g= new Topological_Sort(ver);
		System.out.println("Enter the pair of vertices to form edges in the graph");
		int ver1, ver2;
		for(int i=1;i<=edges;i++)
		{
			ver1=scan.nextInt();
			ver2=scan.nextInt();
			if(ver1>ver||ver2>ver)
				{
				System.out.println("Invalid entry");
				continue;
				}
			g.set_edge(ver1, ver2);

		}
		scan.close();
		g.do_TopologicalSort();
	}
	void do_TopologicalSort()
	{
		HashSet<Integer> visited= new HashSet<Integer>();
		Stack<Integer> st = new Stack<Integer>();
		Set<Integer> vertices= hm.keySet();
		for(Integer num: vertices)
		{
			if(!visited.contains(num))
				{
				visited.add(num);
				LinkedList<Integer> l= hm.get(num);
				do_TopologicalSort_Util(l, st, visited,0);
				st.push(num);
				}
		}
		while(!st.isEmpty())
			System.out.print(st.pop()+" ");
		
	}
	void do_TopologicalSort_Util(LinkedList<Integer> l, Stack<Integer> st, HashSet<Integer> visited, int pos)
	{		
		if(pos>=l.size())
			return;
		int n=l.get(pos);
		if(visited.contains(n))
			return;
		visited.add(n);
		do_TopologicalSort_Util(l,st, visited, pos++);
		st.push(n);
	}
}
