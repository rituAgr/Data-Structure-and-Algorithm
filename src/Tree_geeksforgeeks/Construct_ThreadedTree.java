package Tree_geeksforgeeks;/*
 * http://www.geeksforgeeks.org/convert-binary-tree-threaded-binary-tree/
 */
import java.util.*;
public class Construct_ThreadedTree 
{
	static class Node
	{
		int data;
		Node left, right;
		boolean isThreaded;
		Node(int data)
		{
			this.data=data;
		}
	}
	public static void main(String[] args) 
	{
		/*1
        / \
       2   3
      / \ / \
     4  5 6  7   */
		Node root=new Node(1);
		root.left=new Node(2);
		root.right=new Node(3);
		root.left.left=new Node(4);
		root.left.right=new Node(5);
		root.right.left=new Node(6);
		root.right.right=new Node(7);
		ThreadedTree(root);
		inorder(root);
	}
	static void ThreadedTree(Node root)
	{
		Queue<Node> q= new LinkedList<Node>();
		formQueue(q,root);
		System.out.println("***********");
		ThreadedTreeUtil(q,root);
	}
	static void ThreadedTreeUtil(Queue<Node> q, Node node)
	{
		if(node==null)
			return;
		if(node.left!=null)		
			ThreadedTreeUtil(q,node.left);
		q.remove();		
		if(node.right!=null)
			ThreadedTreeUtil(q,node.right);
		else if(!q.isEmpty())
		{
			node.right=q.peek();
			node.isThreaded=true;
		}		
	}
	static Node leftMost(Node node) 
	{
		while (node != null && node.left != null)
			node = node.left;
		return node;
	}
	static void inorder(Node node)
	{
		if (node == null) 
			return;        
		//for this traversal we need to start with left most most of subtree.
		// Find the leftmost node in Binary Tree
		Node cur = leftMost(node);

		while (cur != null) 
		{
			System.out.print(" " + cur.data + " ");
			if (cur.isThreaded == true)
				cur = cur.right;
			else
				cur = leftMost(cur.right);
		}	
	}
	static void formQueue(Queue<Node> q, Node node)
	{
		if(node==null)
			return;
		formQueue(q,node.left);
		q.add(node);
		System.out.println(node.data);
		formQueue(q,node.right);
	}
}
