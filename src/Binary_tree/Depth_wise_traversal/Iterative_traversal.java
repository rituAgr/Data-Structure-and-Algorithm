package Binary_tree.Depth_wise_traversal;

import java.util.ArrayList;
import java.util.Stack;

public class Iterative_traversal {
	//Preorder
	public ArrayList<Integer> PreOrder(BinaryTreeNode root)
	{
		ArrayList<Integer> result = new ArrayList<Integer>();
		if(root==null)
			return result;
		Stack<BinaryTreeNode> s= new Stack<BinaryTreeNode>();
		s.push(root);
		while(s.isEmpty()==false)
		{
		BinaryTreeNode temp = s.pop();
		result.add(temp.getData());
		if(temp.getRight()!=null)
			s.push(temp.getRight());
		if(temp.getLeft()!=null)
			s.push(temp.getLeft());		
		}
		return result;		
	}
	//Inorder
	public ArrayList<Integer> InOrder(BinaryTreeNode root)
	{
		ArrayList<Integer> result = new ArrayList<Integer>();
		if(root==null)
			return result;
		Stack<BinaryTreeNode> s = new Stack<BinaryTreeNode>();
		BinaryTreeNode curr = root;
		do
		{
			if(curr!=null)
			{
				s.push(curr);
				curr=curr.getLeft();
			}
			else
			{
				curr=s.pop();
				result.add(curr.getData());
			    curr=curr.getRight();	
			}
		}while(s.isEmpty()==false||curr!=null);
		return result;
	}
	//post-order traversal
	public ArrayList<Integer> PostOrder(BinaryTreeNode root)
	{
		ArrayList<Integer> result = new ArrayList<Integer>();
		if(root==null)
			return result;
		Stack<BinaryTreeNode> s1 = new Stack<BinaryTreeNode>();
		Stack<BinaryTreeNode> s2 = new Stack<BinaryTreeNode>();
		s1.push(root);
		BinaryTreeNode curr = root;
		while(!s1.isEmpty())
		{
			curr=s1.pop();
			s2.push(curr);
			if(curr.getLeft()!=null)
				s1.push(curr.getLeft());
			if(curr.getRight()!=null)
				s1.push(curr.getRight());
		}
		while(!s2.isEmpty())
			result.add(s2.pop().getData());
		return result;
	}

}
