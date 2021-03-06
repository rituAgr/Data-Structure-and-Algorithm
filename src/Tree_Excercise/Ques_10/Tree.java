package Tree_Excercise.Ques_10;

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
	 int height(BinaryTreeNode root)
	{
		int size=0;
		if(root == null)
			return size;
		size++;
		if(((height(root.getLeft()))!=0)||(height(root.getRight())!=0))
			 {
			if(height(root.getLeft())>height(root.getRight()))
		   	     size=size+height(root.getLeft());
			else
				size=size+height(root.getRight());
			 }
		return size;
	}
	
	

}
