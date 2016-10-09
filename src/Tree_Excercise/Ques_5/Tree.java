package Tree_Excercise.Ques_5;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Tree {
	//Forming the tree
	public  void formTree(BinaryTreeNode root)
	{
		
		BinaryTreeNode L1 = new BinaryTreeNode(34);
		BinaryTreeNode R1 = new BinaryTreeNode(55);
		BinaryTreeNode L1L = new BinaryTreeNode(22);
		BinaryTreeNode L1R = new BinaryTreeNode(13);
		BinaryTreeNode R1L= new BinaryTreeNode(77);
		BinaryTreeNode R1R = new BinaryTreeNode(45);
		//BinaryTreeNode R2R = new BinaryTreeNode(5);
		root.setLeft(L1);
		root.setRight(R1);
		L1.setLeft(L1L);
		L1.setRight(L1R);
		R1.setLeft(R1L);
		R1.setRight(R1R);
		//R1R.setRight(R2R);
	}
	//Insert a node in Binary tree
	public void insert(BinaryTreeNode root, int data)
	{
		BinaryTreeNode node = new BinaryTreeNode(data);	
		if(root==null)
		{
			root=node;
			return;
		}
		Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
		q.add(root);
		BinaryTreeNode temp;
		while(!q.isEmpty())
		{
		temp=q.remove();
		if(temp.getLeft()==null)
			{
			temp.setLeft(node);
			return;
			}
		if(temp.getRight()==null)
		{
		temp.setRight(node);
		return;
		}
		q.add(temp.getLeft());
		q.add(temp.getRight());		
		}
	}
	//Recursive Insertion of Node
	public boolean recursive_insert(BinaryTreeNode root, int data)
	{
		//BinaryTreeNode node = new BinaryTreeNode(data);	
		if(root==null)
		{
			root=new BinaryTreeNode(data);
			return true;
		}
		
		boolean check1=recursive_insert(root.left, data);
		boolean check2=false;
		if(check1==false)
			check2=recursive_insert(root.right, data);
         return (check1||check2);
		
	}
	//Level-order traversal
	public ArrayList<Integer> level_order_traversal(BinaryTreeNode root)
	{
		ArrayList<Integer> result = new ArrayList<Integer>();
		Queue<BinaryTreeNode> q= new LinkedList<BinaryTreeNode>();
		BinaryTreeNode curr = root;
		q.add(curr);
		do
		{	curr=q.remove();
			result.add((curr.getData()));
			if(curr.getLeft()!=null)
			    q.add(curr.getLeft());
			if(curr.getRight()!=null)
			    q.add(curr.getRight());	
		}while(!q.isEmpty());
		return result;
	}	

}
