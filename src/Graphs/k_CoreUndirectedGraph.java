package Graphs;

import java.util.Arrays;
public class k_CoreUndirectedGraph {

	public static void main(String[] args) {
		UndirectedGraph g1=new UndirectedGraph(9);
		g1.addEdge(0, 1);
		g1.addEdge(0, 2);
		g1.addEdge(1, 2);
		g1.addEdge(1, 5);
		g1.addEdge(2, 3);
		g1.addEdge(2, 4);
		g1.addEdge(2, 5);
		g1.addEdge(2, 6);
		g1.addEdge(3, 4);
		g1.addEdge(3, 6);
		g1.addEdge(3, 7);
		g1.addEdge(4, 6);
		g1.addEdge(4, 7);
		g1.addEdge(5, 6);
		g1.addEdge(5, 8);
		g1.addEdge(6, 7);
		g1.addEdge(6, 8);
		k_CoreUndirectedGraph k=new k_CoreUndirectedGraph();
		k.k_coreGraph(g1,3);	
	}
	private void k_coreGraph(UndirectedGraph g1,int k)
	{
		int n=g1.list.length;
		//creating and filling in isPresent array.
		boolean isPresent[]=new boolean[n];
		Arrays.fill(isPresent, true);
		//creating and filling in length array. It stores the length of each list (excluding head)
		int lisLen[]=new int[n];
		for(int i=0;i<n;i++)
		{
			AdjNode curr=g1.list[i].head;
			int len=0;
			while(curr.next!=null)
			{
				len++;
				curr=curr.next;
			}
			lisLen[i]=len;
		}
		int count;
		for(int i=0;i<n;i++)
		{
			count=0;
			while(count<n)
			{
				if(!isPresent[count]||lisLen[count]>=k)
				{
					count++;
					continue;
				}
				lisLen[count]=-1;
				isPresent[count]=false;
				AdjNode curr=g1.list[count].head;					
				while(curr.next!=null)
				{						
					curr=curr.next;
					int val=curr.value;
					lisLen[val]--;
				}
				count++;
			}
		}
		//printing the vertex which is still present
		for(int i=0;i<n;i++)
		{
			if(isPresent[i]==false)
				continue;
			AdjNode curr=g1.list[i].head;
			System.out.print("\n"+curr.value+" -> ");
			while(curr.next!=null)
			{
				curr=curr.next;
				int val=curr.value;
				if(isPresent[val])
					System.out.print(curr.value+" ");
			}
		}
	}

}
