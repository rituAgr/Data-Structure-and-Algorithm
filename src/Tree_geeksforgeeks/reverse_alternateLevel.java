package Tree_geeksforgeeks;

import java.util.*;

/*
 * http://www.geeksforgeeks.org/reverse-alternate-levels-binary-tree/
 */
public class reverse_alternateLevel {
	static class Node
	{
		char data;
		Node left,right;
		Node(char data)
		{
			this.data=data;
		}
	}
	public static void main(String[] args)
	{		
		Node root = new Node('a');
		root.left = new Node('b');
		root.right = new Node('c');
		root.left.left = new Node('d');
		root.left.right = new Node('e');
		root.right.left = new Node('f');
		root.right.right = new Node('g');
		root.left.left.left = new Node('h');
		root.left.left.right = new Node('i');
		root.left.right.left = new Node('j');
		root.left.right.right = new Node('k');
		root.right.left.left = new Node('l');
		root.right.left.right = new Node('m');
		root.right.right.left = new Node('n');
		root.right.right.right = new Node('o');
		char[] levelOrder=getLevelOrder(root);
		char[] inorder=new char[levelOrder.length];
		ArrayList<Character> res= new ArrayList<Character>();
		inOrder(root,res);
		for(int i=0;i<res.size();i++)
			inorder[i]=res.get(i);
	}
	static char[] getLevelOrder(Node root)
	{
		ArrayList<Character> res=new ArrayList<Character>();
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		while(!q.isEmpty())
		{
			Node temp=q.poll();
			if(temp.left!=null)
				q.add(temp.left);
			if(temp.right!=null)
				q.add(temp.right);
			res.add(temp.data);
		}
		char array[]=new char[res.size()];
		for(int i=0;i<res.size();i++)
			array[i]=res.get(i);
		 return array;
	}
	static void inOrder(Node root, ArrayList<Character> res)
	{
		if(root!=null)
		{
			inOrder(root.left,res);
			res.add(root.data);
			inOrder(root.right,res);
		}
	}
	static void reverseAlternateLevel(Node root)
	{
		boolean reverse=true;
		//Stack<Node> st=new Stack<Node>();
		Deque<Node> q1 = new LinkedList<Node>();
		Deque<Node> q2 = new LinkedList<Node>();
		q1.add(root);
		//q.add(null);!st.isEmpty()&&
		while(!q1.isEmpty()&&!q2.isEmpty())
		{
		if(reverse)
		{
			while(!q1.isEmpty())
				q2.addLast(q1.pollFirst());
			
		}
		}
	}

}
