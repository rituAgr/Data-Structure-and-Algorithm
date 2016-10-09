package Tree_Excercise.Ques_12r;

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
	//Calculate the height/size of binary tree recursively
	 public int q_height(BinaryTreeNode root)
	{
		Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
		q.add(root);
		q.add(null);
		int count=0;
		BinaryTreeNode curr;
		while(!q.isEmpty())
		{
			curr=q.poll();
		
			if(curr==null)
			{
				count++;
				q.add(null);
			}
			else
			{
				if(curr.getLeft()!=null)
					q.add(curr.getLeft());
				if(curr.getRight()!=null)
					q.add(curr.getRight());	
			}
			if(curr==null&&q.peek()==null)
				return count;
		}
		return count;
	}

}
