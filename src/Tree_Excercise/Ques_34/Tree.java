package Tree_Excercise.Ques_34;

import java.util.*;

public class Tree {
	static boolean v1=false;
	static boolean v2=false;
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
		R1L.setRight(R3R);
	}
	public void spiral_traversal(BinaryTreeNode root)
	{
		Stack<BinaryTreeNode> s1=new Stack<BinaryTreeNode>();
		Stack<BinaryTreeNode> s2=new Stack<BinaryTreeNode>();
		s1.push(root);
		BinaryTreeNode curr;
		while(!s1.isEmpty()||!s2.isEmpty())
		{
			while(!s1.isEmpty())
			{
				curr=s1.pop();
				if(curr.getLeft()!=null)
					s2.push(curr.getLeft());
				if(curr.getRight()!=null)
					s2.push(curr.getRight());
				System.out.print(curr.getData()+" ");
			}
			while(!s2.isEmpty())
			{
				curr=s2.pop();
				if(curr.getRight()!=null)
					s1.push(curr.getRight());
				if(curr.getLeft()!=null)
					s1.push(curr.getLeft());
				System.out.print(curr.getData()+" ");
			}
		}


	}
}
