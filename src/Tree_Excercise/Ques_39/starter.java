package Tree_Excercise.Ques_39;
public class starter {
	public static void main(String[] args)
	{
		Tree t= new Tree();
		BinaryTreeNode root = new BinaryTreeNode(12);
		t.formTree(root);
		t.fillSibling(root);
	}

}
