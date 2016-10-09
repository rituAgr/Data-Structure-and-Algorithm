package Tree_Excercise.Ques_34;
public class starter {
	public static void main(String[] args)
	{

		BinaryTreeNode root= new BinaryTreeNode(12);
		Tree t= new Tree();
        t.formTree(root);
        System.out.println("Spiral Traversal : ");
        t.spiral_traversal(root);
	}

}
