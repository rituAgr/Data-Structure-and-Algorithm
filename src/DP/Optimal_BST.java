package DP;

/*
 * http://www.geeksforgeeks.org/dynamic-programming-set-24-optimal-binary-search-tree/
 */
public class Optimal_BST {

	public static void main(String[] args) {
		int[] nodes={10,12,16,21};//{10,12,20,35,46};
		int[] frequency={4,2,6,3};//{34,8,50,21,16};
		Dynamic_Optimal_BST(nodes,frequency);
	}
	static class block
	{
		int rootPos;
		int cost;
		block(int c,int r)
		{
			rootPos=r;
			cost=c;
		}
	}
	private static void Dynamic_Optimal_BST(int[] node,int[] frequency)
	{
		int n=node.length;
		block matrix[][]=new block[n][n];
		for(int i=0;i<n;i++)
			matrix[i][i]=new block(frequency[i],i);
		for(int l=2;l<=n;l++)
		{
			for(int i=0;i<n-l+1;i++)
			{
				int j=i+l-1;
				int minRootPos=-1;
				int minCost=Integer.MAX_VALUE;
				int sum=0;//matrix[i][j-1].cost+matrix[j][j].cost;
				for(int k=i;k<=j;k++)
					sum=sum+frequency[k];
				int split_root=i;
				for(int k=i;k<=j;k++)
				{
					int sum_min;
					if(split_root==i)
						sum_min=matrix[i+1][j].cost;
					else if(split_root==j)
						sum_min=matrix[i][j-1].cost;
					else
						sum_min=matrix[i][k-1].cost+matrix[k+1][j].cost;
					if(minCost>sum_min)
						{
						minCost=sum_min;
						minRootPos=k;
						}
				}
				matrix[i][j]=new block(sum+minCost,minRootPos);				
			}
		}
		for(int i=0;i<n;i++)
		{for(int j=i;j<n;j++)
			System.out.print(matrix[i][j].cost+"  ");
		System.out.println();}
		System.out.println("Min cost is "+matrix[0][n-1].cost);
		System.out.println("the tree is as follows");
		Node r=formTree(node,matrix,0,n-1);
		printTree(r);
	}
	static class Node
	{
		int data;
		Node left,right;
		Node(int v)
		{
			data=v;
		}
	}
	static void printTree(Node r)
	{
		if(r==null)
			return;
		System.out.println(r.data);
		printTree(r.left);
		
		printTree(r.right);
	}
	static Node formTree(int[] n,block matrix[][],int start,int end)
	{
		if(start>end)
			return null;
		int pos=matrix[start][end].rootPos;
		Node root=new Node(n[pos]);
		root.left=formTree(n, matrix, start,pos-1);
		root.right=formTree(n, matrix, pos+1,end);
		return root;
	}
}
