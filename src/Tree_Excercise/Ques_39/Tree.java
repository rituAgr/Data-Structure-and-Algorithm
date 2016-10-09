package Tree_Excercise.Ques_39;

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
	public void fillSibling(BinaryTreeNode root)
	{
		if(root==null)
			return;
		Queue<BinaryTreeNode> a = new LinkedList<BinaryTreeNode>();
		a.add(root);
		a.add(null);
		BinaryTreeNode temp;
		while(!a.isEmpty())
		{
			temp=a.remove();
			if(temp!=null)
			{
				temp.setNextSibling(a.peek());
				if(temp.getLeft()!=null)
					a.add(temp.getLeft());
				if(temp.getRight()!=null)
					a.add(temp.getRight());
				/*BinaryTreeNode curr=a.peek();
				if(temp!=null&&curr!=null)
					System.out.print("The node and its next sibling :"+temp.getData()+"-->"+(temp.getNextSibling()).getData()+"\n");*/
			}
			else
			{
				if(!a.isEmpty())
					a.add(null);
			}
		}
	}

}
