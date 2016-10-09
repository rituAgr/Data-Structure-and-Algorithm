package Tree_Excercise.Ques_39;

public class BinaryTreeNode {
	private int data;
	private BinaryTreeNode left;
	private BinaryTreeNode right;
	private BinaryTreeNode nextSibling;
	BinaryTreeNode()
	{
		left=null;
		right=null;
		nextSibling=null;
	}
	public BinaryTreeNode(int data)
	{
		this.data=data;
	}
	public void setNextSibling(BinaryTreeNode next)
	{
		nextSibling=next;
	}
	public BinaryTreeNode getNextSibling()
	{
		return nextSibling;
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
