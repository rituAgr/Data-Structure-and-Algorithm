package Tree_Excercise.Ques_31;
public class Tree {
	//constructing tree from inorder and level
	public BinaryTreeNode contruct_Tree(char inorder[],int instart, int inend, char levelorder[])
	{
		if(inend<instart)
			return null;
		BinaryTreeNode temp = new BinaryTreeNode(inorder[instart]);
		if(inend==instart)
			return temp;
		int k=-1;
		for(int i= instart;i<=inend;i++)
			if(inorder[i]==temp.getData())
			{
				k=i;
				break;
			}
		temp.setLeft(contruct_Tree(inorder,instart, k-1, levelorder));
		temp.setRight(contruct_Tree(inorder,k+1, inend, levelorder));
		return temp;
	}

	public void Preorder_traversal(BinaryTreeNode root)
	{
		if(root==null)
			return;
		System.out.print(root.getData()+" ");
		Preorder_traversal(root.getLeft());

		Preorder_traversal(root.getRight());
	}
	
}
