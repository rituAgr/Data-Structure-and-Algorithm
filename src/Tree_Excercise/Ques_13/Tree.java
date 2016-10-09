package Tree_Excercise.Ques_13;

import java.util.LinkedList;
import java.util.Queue;

public class Tree {
	public  void formTree(BinaryTreeNode root)
	{
		
		BinaryTreeNode L1 = new BinaryTreeNode(34);
		BinaryTreeNode R1 = new BinaryTreeNode(55);
		BinaryTreeNode L1L = new BinaryTreeNode(22);
		BinaryTreeNode L1R = new BinaryTreeNode(13);
		BinaryTreeNode R1L= new BinaryTreeNode(77);
		BinaryTreeNode R1R = new BinaryTreeNode(45);
		BinaryTreeNode R2R = new BinaryTreeNode(5);
		BinaryTreeNode R3R = new BinaryTreeNode(105);
		root.setLeft(L1);
		root.setRight(R1);
		L1.setLeft(L1L);
		L1.setRight(L1R);
		R1.setLeft(R1L);
		R1.setRight(R1R);
		R1R.setRight(R2R);
		R2R.setRight(R3R);
	}
	//Calculate the minimum height/size of binary tree 

	 public int Min(BinaryTreeNode root)
		{
			Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
			q.add(root);
			q.add(null);
			int count = 0;// Considering root as level 0
			BinaryTreeNode curr;
			while(!q.isEmpty())
			{
				curr=q.poll();
				
				if(curr!=null)
				{
					if(curr.getLeft()==null||curr.getRight()==null)
						return count;
				//	if(curr.getLeft()!=null)
						q.add(curr.getLeft());
				//	if(curr.getRight()!=null)
						q.add(curr.getRight());
				}
				else
				{
					count++;
					q.add(null);
				}
				
				if(curr==null&&q.isEmpty())
				{
					return count;
				}

			}
			return count;
		}
	 // Maximum depth of tree
	 public int Max(BinaryTreeNode root)
		{
			Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
			q.add(root);
			q.add(null);
			int count = 0;// Considering root as level 0
			BinaryTreeNode curr;
			while(true)
			{
				curr=q.poll();
				
				if(curr!=null)
				{
					if(curr.getLeft()!=null)
						q.add(curr.getLeft());
					if(curr.getRight()!=null)
						q.add(curr.getRight());
				}
				else
				{
					if(q.peek()==null)
						return count;
					count++;
					q.add(null);
						
				}
			}
		}
	 // Returning the deepest node
	 public BinaryTreeNode lastNode(BinaryTreeNode root)
	 {
		 if(root==null)
			 return null;
		 Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
		 q.add(root);
		 BinaryTreeNode curr=null;
		 while(!q.isEmpty())
		 {
			curr=q.poll();
			if(curr.getLeft()!=null)
				q.add(curr.getLeft());
			if(curr.getRight()!=null)
				q.add(curr.getRight());
		 }
		 return curr;
	 }

}


