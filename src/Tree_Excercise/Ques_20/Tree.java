package Tree_Excercise.Ques_20;

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
	//Ques 20
	public int diameterOfTree(BinaryTreeNode root)
	{
		if(root==null)
			return 0;
		int lHeight=height(root.getLeft());
		int rHeight=height(root.getRight());
		return Math.max(lHeight+rHeight+1, Math.max(diameterOfTree(root.getLeft()), diameterOfTree(root.getRight())));
	}
	public int height(BinaryTreeNode node)
	{
		if(node==null)
			return 0;
		return 1+Math.max(height(node.getLeft()), height(node.getRight()));
	}
	//Ques 21
	public int width_of_tree(BinaryTreeNode root)
	{
		Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
		q.add(root);
		q.add(null);
		int prev=0;
		int count=0;
		BinaryTreeNode curr;
		while(!q.isEmpty())
		{
			curr=q.remove();
			if(curr==null)
			{
				q.add(null);
			 if(prev<count)
				 prev=count;
			 count=0;
			}
			else
			{
				if(curr.getLeft()!=null)
				{
					q.add(curr.getLeft());
					count++;
				}
				if(curr.getRight()!=null)
				{
					q.add(curr.getRight());
					count++;
				}
			}
			if(curr==null&&q.peek()==null)
				break;
		}
	    if(prev>count)
	    	return prev;
	    else
	    	return count;
	}
}
