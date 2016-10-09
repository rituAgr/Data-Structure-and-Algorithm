package Tree_Excercise.Ques_6;

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
		BinaryTreeNode R2R = new BinaryTreeNode(5);
		root.setLeft(L1);
		root.setRight(R1);
		L1.setLeft(L1L);
		L1.setRight(L1R);
		R1.setLeft(R1L);
		R1.setRight(R1R);
		R1R.setRight(R2R);
	}
	//count the size of tree recursively
	public int recursive_count(BinaryTreeNode root)
	{
		int size=1;
		if(root==null)
			return 0;
		else
		{
			size = size + recursive_count(root.getLeft());
			size = size + recursive_count(root.getRight());
		}
		return size;
	}

	//count the size of tree recursively
		public int count(BinaryTreeNode root)
		{
			int count = 0;
			Queue<BinaryTreeNode> q= new LinkedList<BinaryTreeNode>();
			BinaryTreeNode curr = root;
			q.add(curr);
			do
			{	curr=q.remove();
				count++;
				if(curr.getLeft()!=null)
				    q.add(curr.getLeft());
				if(curr.getRight()!=null)
				    q.add(curr.getRight());	
			}while(!q.isEmpty());
			return count;
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
