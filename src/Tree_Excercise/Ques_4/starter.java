package Tree_Excercise.Ques_4;

public class starter {
	public static void main(String[] args)
	{
		BinaryTreeNode root = new BinaryTreeNode(12);
		Tree t = new Tree();
		t.formTree(root);
		boolean check = t.search(root,35);
		System.out.println("The value is present :  "+check);
	}

}
