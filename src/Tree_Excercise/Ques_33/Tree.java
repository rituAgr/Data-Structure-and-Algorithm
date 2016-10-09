package Tree_Excercise.Ques_33;

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
		R2R.setRight(R3R);
	}
	public BinaryTreeNode LCA(BinaryTreeNode root, BinaryTreeNode node1, BinaryTreeNode node2)
	{
		if(root==null)
			return null;
		if(root.getData()==node1.getData())
		{
			v1=true;
			return node1;
		}
		if(root.getData()==node2.getData())
		{
			v2=true;
			return node2;
		}
		BinaryTreeNode left=LCA(root.getLeft(),node1,node2);
		BinaryTreeNode right=LCA(root.getRight(),node1,node2);
		if(left!=null&&right!=null)
			return root;
		if(left!=null)
			return left;
		else
			return right;		
	}
	public int findLCA(BinaryTreeNode root,BinaryTreeNode node1,BinaryTreeNode node2)
	{
		BinaryTreeNode node=LCA(root,node1,node2);
		if(v1&&v2)
			return node.getData();
		else
			return Integer.MIN_VALUE;
	}
}
