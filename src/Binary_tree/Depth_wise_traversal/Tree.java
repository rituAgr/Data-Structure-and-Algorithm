package Binary_tree.Depth_wise_traversal;
//Recursive Indepth traversal
public class Tree {
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
	public void PreOrder(BinaryTreeNode root)
	{
		if(root!=null)
		{	
		System.out.println(root.getData());
		PreOrder(root.getLeft());
		PreOrder(root.getRight());
		}
		
	}
	public void InOrder(BinaryTreeNode root)
	{
		if(root!=null)
		{	
		InOrder(root.getLeft());
		System.out.println(root.getData());
		InOrder(root.getRight());
		}
		
	}
	public void PostOrder(BinaryTreeNode root)
	{
		if(root!=null)
		{	
		PostOrder(root.getLeft());
		PostOrder(root.getRight());
		System.out.println(root.getData());
		}
		
	}	

}
