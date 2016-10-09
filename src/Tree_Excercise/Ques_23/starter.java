package Tree_Excercise.Ques_23;
//To print all the paths from root to leaf
public class starter {
	public static void main(String[] args)
	{
		int i= 0;
		//System.out.println("Print the value of i: " + i);
		BinaryTreeNode root= new BinaryTreeNode(12);
		Tree t= new Tree();
        t.formTree(root);
        BinaryTreeNode path[] = new BinaryTreeNode[20];
        t.recur_path(root, path, i);
       int sum = t.sum(root);
        System.out.println("the sum of all nodes in tree is:"+sum);
	}

}
