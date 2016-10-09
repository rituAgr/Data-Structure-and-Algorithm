package Graphs;/*
* http://www.geeksforgeeks.org/depth-first-traversal-for-a-graph/
* input : 4 5
3 4
2 3
1 2
1 3
3 1
 */
import java.util.*;
public class Depth_First_Traversal 
{
	int num_ver;
	HashMap<Integer, LinkedList<Integer>> hm;
	Depth_First_Traversal(int v)
	{
		num_ver=v;
		hm=new HashMap<Integer, LinkedList<Integer>>();
		for(int i=1;i<=v;i++)
			hm.put(i,new LinkedList<Integer>());
	}
	void set_edge(int v1, int v2)
	{
		LinkedList<Integer> l1=hm.get(v1);
		LinkedList<Integer> l2=hm.get(v2);
		l1.add(v2);
		l2.add(v1);
	}
	void DFS(int start)
	{
		boolean[] visit=new boolean[num_ver+1];
		ArrayList<Integer> res= new ArrayList<Integer>();
		Stack<Integer> st= new Stack<Integer>();
		int num=start;
		st.push(start);
		visit[num]=true;
		while(!st.isEmpty())
		{
			int n=st.pop();
			res.add(n);
			LinkedList<Integer> l=hm.get(n);
			int s=0;
			while(s<l.size())
			{
				int val=l.get(s);
				if(!visit[val])
					{
					st.push(l.get(s));
					visit[val]=true;
					}
				s++;
			}
		}
		System.out.println(res.toString());
	}
	public static void main(String[] args)
	{
		System.out.println("Enter the number of vertices and edges in the graph");
		int ver,edges;
		Scanner scan = new Scanner(System.in);
		ver= scan.nextInt();
		edges= scan.nextInt();
		Depth_First_Traversal g= new Depth_First_Traversal(ver);
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
		g.DFS(3);
	}

}
