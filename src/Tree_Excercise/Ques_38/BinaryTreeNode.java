package Tree_Excercise.Ques_38;

public class BinaryTreeNode {
	private char data;
	private BinaryTreeNode left;
	private BinaryTreeNode right;
	BinaryTreeNode()
	{
		left=null;
		right=null;
	}
	BinaryTreeNode(char data)
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
	public char getData()
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
