package Tree_Excercise.Ques_2;

public class starter {
	public static void main(String[] args)
	{
		BinaryTreeNode root = new BinaryTreeNode(12);
		Tree t = new Tree();
		t.formTree(root);
		int max = t.findMax(root);
		System.out.println("The maximum value is "+max);
	}

}
