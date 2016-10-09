/*
 * http://www.geeksforgeeks.org/greedy-algorithms-set-5-prims-minimum-spanning-tree-mst-2/
 * Time complexity=O(V^2)
 * Space complexity=O(Elog(V))
 * https://www.youtube.com/watch?v=oP2-8ysT3QQ&list=PLrmLmBdmIlpu2f2g8ltqaaCZiq6GJvl1j&index=3
 */
package Graphs.TusharRoyVideo;
public class PrimMST {
	static int n;

	public static void main(String[] args) {
		int graph[][]={{0, 2, 0, 6, 0},
				{2, 0, 3, 8, 5},
				{0, 3, 0, 0, 7},
				{6, 8, 0, 0, 9},
				{0, 5, 7, 9, 0}};
		n=graph.length;
		PrimMST mst=new PrimMST();
		mst.Minimum_Spanning_Tree(graph);
	}
	int[] parent;
	int[] weight;
	boolean[] mSet;
	PrimMST()
	{
		parent=new int[n];
		weight=new int[n];
		mSet=new boolean[n];
	}
	int getMin()
	{
		int min=Integer.MAX_VALUE;
		int minIndex=-1;
		for(int i=0;i<n;i++)
			if(weight[i]<min&&!mSet[i])
			{
				min=weight[i];
				minIndex=i;
			}
		return minIndex;
	}
	public void Minimum_Spanning_Tree(int[][] graph)
	{
		for(int i=0;i<n;i++)
		{
			parent[i]=-1;
			weight[i]=Integer.MAX_VALUE;
		}
		weight[0]=0;
		for(int i=0;i<n-1;i++)
		{
			int v=getMin();
			mSet[v]=true;
			for(int j=0;j<n;j++)
			{
				if(graph[i][j]!=0&&mSet[j]==false&&graph[i][j]<weight[j])
				{
					weight[j]=	graph[i][j];
					parent[j]=i;
				}
			}
		}
		printMST();
	}
	public void printMST()
	{
		System.out.println("Edge    weight");
		for(int i=1;i<n;i++)
			System.out.println(parent[i]+" - "+i+"   "+weight[i]);
	}
}
