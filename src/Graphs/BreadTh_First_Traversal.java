package Graphs;/*
 * http://www.geeksforgeeks.org/breadth-first-traversal-for-a-graph/
 *  * input : 4 5
3 4
2 3
1 2
1 3
3 1
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class BreadTh_First_Traversal {
	HashMap<Integer, LinkedList<Integer>> hm;
	BreadTh_First_Traversal(int v)
	{
		hm= new HashMap<Integer, LinkedList<Integer>>();
		for(int i=1;i<=v;i++)
			hm.put(i,new LinkedList<Integer>());
	}
	void set_edge(int s, int d)
	{
		if(s>hm.size()||d>hm.size())
			{
			System.out.println("The value is invlid");
			return;
			}
		LinkedList<Integer> l1=hm.get(s);
		LinkedList<Integer> l2=hm.get(d);
		l1.add(d);
		l2.add(s);
	}
	void BFS(int start)
	{
		Queue<Integer> q = new LinkedList<Integer>();
		ArrayList<Integer> res= new ArrayList<Integer>();
		q.add(start);
		//boolean[] check= new boolean[hm.size()+];
		while(!q.isEmpty())
		{
			int num=q.poll();
			res.add(num);
			LinkedList<Integer> l=hm.get(num);
			int count=0;
			while(count<l.size())
			{
				int x= l.get(count);
				if(!res.contains(x)&&!q.contains(x))
					q.add(x);
				count++;
			}
		}
		System.out.println(res.toString());
	}
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the number of vertices and edges");
		int vertices= scan.nextInt();
		int edges=scan.nextInt();
		System.out.println("Enter the pair of vertices as edge");
		BreadTh_First_Traversal ob= new BreadTh_First_Traversal(vertices);
		int count=0;
		while(count<edges)
		{
			int s=scan.nextInt();
			int d=scan.nextInt();
			if(s>vertices||d>vertices)
			{
				System.out.println("This pair is invalid");
				continue;
			}
			ob.set_edge(s, d);
			count++;
		}
		scan.close();
		ob.BFS(3);
	}

}
