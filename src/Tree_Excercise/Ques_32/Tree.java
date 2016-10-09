package Tree_Excercise.Ques_32;

public class Tree {
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
	public boolean ancestor(BinaryTreeNode root, int pathLen, int path[],int data)
	{
		if(root==null)
			return false;
		path[pathLen]=root.getData();
		pathLen++;
		if(root.getData()==data)
		{
			for(int i=0;i<pathLen;i++)
				System.out.print(path[i]+" ");
			return true;
		}
		boolean check=ancestor(root.getLeft(), pathLen,path,data);
		if(check==false)
			check=ancestor(root.getRight(), pathLen,path,data);
		return check;
	}
}
