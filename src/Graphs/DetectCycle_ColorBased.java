package Graphs;

import java.util.*;

/*
 * http://www.geeksforgeeks.org/detect-cycle-direct-graph-using-colors/
 */
public class DetectCycle_ColorBased
{
	int V,E;
	HashMap<Integer,Set<Integer>> hm;
	DetectCycle_ColorBased(int v)
	{
		V=v;
		hm=new HashMap<Integer,Set<Integer>>();
		for(int i=0;i<v;i++)
		{
			Set<Integer> s = new HashSet<Integer>();
			hm.put(i, s);
		}
	}
	void set_edge(int a,int b)
	{
		Set<Integer> s=hm.get(a);
		s.add(b);
		hm.put(a, s);
	}
	boolean isCyclic()
	{
		String color[] =new String[V];
		Arrays.fill(color, "white");
		for(int i=0;i<V;i++)
			if(isCyclicUtil(color,i))
				return true;
		return false;
	}
	boolean isCyclicUtil(String[] color, int u)
	{
		color[u]="gray";
		Set<Integer> s= hm.get(u);
		for(Integer i:s)
		{
			if(color[i].equals("gray"))
				return true;
			if(isCyclicUtil(color,i))
				return true;
		}
		color[u]="black";
		return false;
	}
	public static void main(String[] args) 
	{
		int e,v;
		System.out.println("Enter the number of vertices and num of edges of graph" );
		Scanner scan= new Scanner(System.in);
		v=scan.nextInt();
		e=scan.nextInt();
		DetectCycle_ColorBased g = new DetectCycle_ColorBased(v);
		System.out.println("Enter the edges");
		for(int i=0;i<e;i++)
		{
			int a=scan.nextInt();
			int b=scan.nextInt();
			g.set_edge(a,b);
		}
		scan.close();		
		System.out.println(g.isCyclic());
	}

}
