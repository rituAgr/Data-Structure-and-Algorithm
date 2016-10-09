package Binary_tree.revision;

import java.util.Stack;

public class PreOrder {
	public  void formTree(BinaryTreeNode root)
	{
		
		BinaryTreeNode L1 = new BinaryTreeNode(34);
		BinaryTreeNode R1 = new BinaryTreeNode(55);
		BinaryTreeNode L1L = new BinaryTreeNode(22);
		BinaryTreeNode L1R = new BinaryTreeNode(13);
		BinaryTreeNode R1L= new BinaryTreeNode(77);
		BinaryTreeNode R1R = new BinaryTreeNode(45);
		root.setLeft(L1);
		root.setRight(R1);
		L1.setLeft(L1L);
		L1.setRight(L1R);
		R1.setLeft(R1L);
		R1.setRight(R1R);
	}
	//Recurive
	public void r_PreOrder(BinaryTreeNode root)
	{
		if(root==null)
			return;
		System.out.print(root.getData()+" ");
		r_PreOrder(root.getLeft());
		r_PreOrder(root.getRight());
	}
	//Iterative
	public void t_PreOrder(BinaryTreeNode root)
	{
		if(root==null)
			return;
		BinaryTreeNode curr;
		Stack<BinaryTreeNode> s = new Stack<BinaryTreeNode>();
		s.push(root);
		while(!s.isEmpty())
		{
			curr=s.pop();
			while(curr!=null)
			{
				System.out.print(curr.getData()+" ");
				if(curr.getRight()!=null)
					s.push(curr.getRight());
				curr=curr.getLeft();
			}
		}
	}

}
