package Tree_Excercise.Ques_38;
public class Tree {
	public BinaryTreeNode BulidTree(char A[],int pos)
	{
		if(A==null||A.length==1||pos>A.length-1)
			return null;
		BinaryTreeNode node = new BinaryTreeNode(A[pos]);
		if(A[pos]=='L')
			return node;
		node.setLeft(BulidTree(A,++pos));
		node.setRight(BulidTree(A,++pos));
		return node;
	}
	public void inOrder(BinaryTreeNode root)
	{
		if(root==null)
			return;
		inOrder(root.getLeft());
		System.out.print(root.getData()+" ");
		inOrder(root.getRight());
	}
}
