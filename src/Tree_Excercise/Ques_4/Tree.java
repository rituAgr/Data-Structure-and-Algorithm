package Tree_Excercise.Ques_4;

import java.util.Stack;
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
	//My recursion format
	public boolean search(BinaryTreeNode root, int data)
	{
	Stack<BinaryTreeNode> s = new Stack<BinaryTreeNode>();
	s.push(root);
	BinaryTreeNode temp;
	while(!s.isEmpty())
	{
		temp=s.pop();
		if(temp.getData()==data)
			return true;
		if(temp.getRight()!=null)
			s.push(temp.getRight());
		if(temp.getLeft()!=null)
			s.push(temp.getLeft());
	}
	return false;
	}

}
