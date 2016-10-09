package Tree_geeksforgeeks;

import java.util.ArrayList;
/*
 * http://www.geeksforgeeks.org/find-all-possible-trees-with-given-inorder-traversal/
 */
public class form_Trees_fromInorderTraversal {
	static class Node 
	{
		int data;
		Node left, right;
		public Node(int item) 
		{
			data = item;
		}
	}
	public static void main(String[] args) {
		int inOrder[]={4,5,6,7};
		ArrayList<Node> res=getTree(inOrder, 0,inOrder.length-1);
		for(int i=0;i<res.size();i++)
		{
			preOrder(res.get(i));
			System.out.println();
		}
	}
	public static void preOrder(Node root)
	{
		if(root==null)
			return;
		System.out.print(root.data+" ");
		preOrder(root.left);
		preOrder(root.right);
	}
	public static ArrayList<Node> getTree(int[] inOrder, int start,int end)
	{
		ArrayList<Node> res=new ArrayList<Node>();
		if(start>end)
		{
			res.add(null);
			return res;
		}
		for(int i=start;i<=end;i++)
		{
			ArrayList<Node> ltree=getTree(inOrder, start, i-1);
			ArrayList<Node> rtree=getTree(inOrder, i+1, end);
			for(int l=0;l<ltree.size();l++)
			{
				for(int r=0;r<rtree.size();r++)
				{
					Node node =new Node(inOrder[i]);
					node.left=ltree.get(l);
					node.right=rtree.get(r);
					res.add(node);
				}
			}
		}
		return res;
	}
}
