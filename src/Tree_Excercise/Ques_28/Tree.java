package Tree_Excercise.Ques_28;

import java.util.LinkedList;
import java.util.Queue;
public class Tree {
	public  void formTree1(BinaryTreeNode root)
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
	public  void formTree2(BinaryTreeNode root)
	{
		
		BinaryTreeNode R1 = new BinaryTreeNode(34);
		BinaryTreeNode L1 = new BinaryTreeNode(55);
		BinaryTreeNode R1R = new BinaryTreeNode(22);
		BinaryTreeNode R1L = new BinaryTreeNode(13);
		BinaryTreeNode L1R= new BinaryTreeNode(77);
		BinaryTreeNode L1L = new BinaryTreeNode(45);
		BinaryTreeNode L2L = new BinaryTreeNode(5);
		BinaryTreeNode L3L = new BinaryTreeNode(105);
		root.setLeft(L1);
		root.setRight(R1);
		L1.setLeft(L1L);
		L1.setRight(L1R);
		R1.setLeft(R1L);
		R1.setRight(R1R);
		L1L.setLeft(L2L);
		L2L.setLeft(L3L);
	}
	//Proper Level-order traversal
	public void level_order_traversal(BinaryTreeNode root)
	{
		System.out.print("\n ");
		Queue<BinaryTreeNode> q= new LinkedList<BinaryTreeNode>();
		BinaryTreeNode curr = root;
		q.add(curr);
		do
		{	curr=q.remove();
			System.out.print(curr.getData()+" ");
			if(curr.getLeft()!=null)
			    q.add(curr.getLeft());
			if(curr.getRight()!=null)
			    q.add(curr.getRight());	
		}while(!q.isEmpty());
		return;
	}
	// Check if two tree are mirror image
	public boolean mirror(BinaryTreeNode root1, BinaryTreeNode root2)
	{
		if(root1==null&&root1==null)
			return true;
		if(root1==null||root2==null)
			return false;
		if(root1.getData()!=root2.getData())
			return false;
		else
			return (mirror(root1.getLeft(),root2.getRight())&&mirror(root1.getRight(),root2.getLeft()));
	}
	
	
	
	
}














