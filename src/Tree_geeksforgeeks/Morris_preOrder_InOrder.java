package Tree_geeksforgeeks;/* youTube Link : https://www.youtube.com/watch?v=wGXB9OWhPTg
 * Morris algo can work for Inorder and PreOrder but not for postOrder because of property 
 * of postorder traversal that they need to go left right and root at end it would need at atleast 
 * one stack to do it and changing links wont be enough.﻿
 */
import java.util.ArrayList;
public class Morris_preOrder_InOrder {
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
	public static void main(String[] args)
	{
		Node root=new Node(10);
		root.left=new Node(5);
		root.right=new Node(30);
		root.right.right=new Node(40);
		root.left.left=new Node(-2);
		root.left.right=new Node(6);
		root.left.right.right=new Node(8);
		root.left.left.right=new Node(2);
		root.left.left.right.left=new Node(-1);
		ArrayList<Integer> res=Morris_InOrder(root);
		System.out.println("The inorder traversal is "+res.toString());
		ArrayList<Integer> res1=Morris_PreOrder(root);
		System.out.println("The Preorder traversal is "+res1.toString());
	}
	static ArrayList<Integer> Morris_InOrder(Node root)
	{
		if(root==null)
			return null;
		ArrayList<Integer> res = new ArrayList<Integer>();
		Node curr=root;
		while(curr!=null)
		{
			if(curr.left!=null)
			{
				Node right_most=find_Predecessor(curr);
				if(right_most.right==curr)
				{
					right_most.right=null;
					res.add(curr.data);
					curr=curr.right;
				}
				else
				{
					right_most.right=curr;
					curr=curr.left;
				}
			}
			else
			{
				res.add(curr.data);
				curr=curr.right;
			}
		}
		return res;
	}
	static ArrayList<Integer> Morris_PreOrder(Node root)
	{
		if(root==null)
			return null;
		ArrayList<Integer> result=new ArrayList<>();
		Node curr=root;
		while(curr!=null)
		{
			if(curr.left!=null)
			{
				//The only catch is position of print statement in morris traversal method

				Node node=find_Predecessor(curr);
				if(node.right==null)
				{
					result.add(curr.data);
					node.right=curr;
					curr=curr.left;
				}
				else
				{
					node.right=curr;
					curr=curr.right;
				}
			}
			else
			{
				result.add(curr.data);
				curr=curr.right;
			}
		}
		return result;
	}
	static Node find_Predecessor(Node root)
	{
		Node curr=root.left;
		if(curr==null)
			return null;
		while(curr.right!=null&&curr.right!=root)
			curr=curr.right;

		return curr;
	}
}



