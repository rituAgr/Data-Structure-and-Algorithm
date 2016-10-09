package Tree_Excercise.Ques_2;

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
		root.setLeft(L1);
		root.setRight(R1);
		L1.setLeft(L1L);
		L1.setRight(L1R);
		R1.setLeft(R1L);
		R1.setRight(R1R);
	}
	//Level-order traversal
	public int findMax(BinaryTreeNode root)
	{
		int max = Integer.MIN_VALUE;
		//ArrayList<Integer> result = new ArrayList<Integer>();
		Queue<BinaryTreeNode> q= new LinkedList<BinaryTreeNode>();
		BinaryTreeNode curr = root;
		q.add(curr);
		do
		{	if(curr.getData()>max)
			  max=curr.getData();
			curr=q.remove();
			if(curr.getLeft()!=null)
			    q.add(curr.getLeft());
			if(curr.getRight()!=null)
			    q.add(curr.getRight());	
		}while(!q.isEmpty());
		return max;
	}	

}
