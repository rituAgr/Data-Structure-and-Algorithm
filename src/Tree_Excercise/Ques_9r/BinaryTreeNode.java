package Tree_Excercise.Ques_9r;

public class BinaryTreeNode {
	private int data;
	 private BinaryTreeNode left;
	 private BinaryTreeNode right;
	public BinaryTreeNode()
	{
		int data = Integer.MIN_VALUE;
		left=null;
		right=null;
	}
	public BinaryTreeNode(int data)
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
