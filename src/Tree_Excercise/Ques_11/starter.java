package Tree_Excercise.Ques_11;
public class starter {
	public static void main(String[] args)
	{
		BinaryTreeNode root = new BinaryTreeNode(12);
		Tree t = new Tree();
		t.formTree(root);
		int count = t.maxHeight(root);
		int min=t.minHeight(root);
		System.out.println(" Max height of tree is : "+count);
		System.out.println(" min height of tree is : "+min);
	}

}

