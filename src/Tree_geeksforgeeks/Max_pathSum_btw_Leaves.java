package Tree_geeksforgeeks;

import java.util.ArrayList;

/*
 * http://www.geeksforgeeks.org/find-maximum-path-sum-two-leaves-binary-tree/
 */
public class Max_pathSum_btw_Leaves {
	static class Node
	{
		Node left;
		Node right;
		int data;
		Node(int d)
		{
			data=d;
		}
	}

	public static void main(String[] args) {
		Node root=new Node(-15);
		root.left=new Node(5);
		root.left.right=new Node(1);
		root.left.left=new Node(-8);
		root.left.left.left=new Node(2);
		root.left.left.right=new Node(6);
		root.right=new Node(6);
		root.right.right=new Node(9);
		root.right.left=new Node(3);
		Node h=root.right.right;
		h.right=new Node(0);
		h.right.left=new Node(4);
		h.right.right=new Node(-1);
		h.right.right.left=new Node(10);
		ArrayList<Integer> res=new ArrayList<Integer>();
		getSum(root,res);
		System.out.println(res.get(0));
	}
	public static int getSum(Node root, ArrayList<Integer> res)
	{
		if(root==null)
			return 0;
		int l=getSum(root.left,res);
		int r=getSum(root.right,res);
		int sum=l+r+root.data;
		if(res.isEmpty()||res.get(0)<sum)
			res.add(0,sum);
		if(l>r)
			return l+root.data;
		return r+root.data;
		
	}
}
