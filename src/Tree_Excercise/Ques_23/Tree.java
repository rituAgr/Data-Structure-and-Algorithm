package Tree_Excercise.Ques_23;
//To print all the paths from root to leaf
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
		//BinaryTreeNode check = new BinaryTreeNode(0);
		//R2R.setLeft(check);
	}
	//Ques 23
	public void display(BinaryTreeNode path[], int i)
	{
		for(int j=0;j<i;j++)
			System.out.print(path[j].getData()+" ");
		System.out.print("\n\n");
	}
	public void recur_path(BinaryTreeNode root, BinaryTreeNode path[], int i)
	{
		if(root==null)
		   return;
		if(root.getLeft()==null&&root.getRight()==null)
		{
			path[i++]=root;
			display(path,i);
			return;
		}
		path[i++]=root;
		recur_path(root.getLeft(),path,i);
		recur_path(root.getRight(),path,i);	
	}
	//Ques24
	public boolean check_sum(BinaryTreeNode root, int sum)
	{
		if(root==null)
			return false;
		if(root.getLeft()==null&&root.getRight()==null&&root.getData()==sum)
			return true;
		boolean check1=check_sum(root.getLeft(), sum-root.getData());
		boolean check2=check_sum(root.getRight(), sum-root.getData());
		return (check1||check2);
	}
  //Ques 25; sum of all the elements recursively
	public int sum(BinaryTreeNode root)
	{
		if(root==null)
			return 0;
		return sum(root.getLeft())+sum(root.getRight())+root.getData();
		
	}
}
