package Tree_Excercise.Ques_60;

public class BSTNode {
	private int data;
	private BSTNode left;
	private BSTNode right;
	BSTNode()
	{
		left=null;
		right=null;
	}
	BSTNode(int data)
	{
		this.data=data;
	}
	public void setLeft(BSTNode left)
	{
		this.left=left;
	}
	public void setRight(BSTNode right)
	{
		this.right=right;
	}
	public int getData()
	{
		return data;
	}
	public BSTNode getRight()
	{
		return right;
	}
	public BSTNode getLeft()
	{
		return left;
	}

}
