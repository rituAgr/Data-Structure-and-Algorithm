package Tree_Excercise.Ques_11;

public class BinaryTreeNode {

	int data;
	BinaryTreeNode left;
	BinaryTreeNode right;
	BinaryTreeNode()
	{
		int data = Integer.MIN_VALUE;
		left=null;
		right=null;
	}
	BinaryTreeNode(int data)
	{
		this.data=data;
	}
	public void setLeft(BinaryTreeNode left)
	{
		this.left=left;
	}
	public void setRight(BinaryTreeNode right)
	{
		this.right=right;
	}
	public int getData()
	{
		return data;
	}
	public BinaryTreeNode getRight()
	{
		return right;
	}
	public BinaryTreeNode getLeft()
	{
		return left;
	}


}
