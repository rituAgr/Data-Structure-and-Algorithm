package Tree_Excercise.Ques_31;

public class starter {
	public static void main(String[] args)
	{
		char[] inorder={'D','B','E','A','F','C'};
		//char[] preorder={'A','B','D','E','C','F'};
		//char[] postorder={'D','E','B','F','C','A'};
		char[] levelorder = {'A','B','C','D','E','F'};
		Tree t = new Tree();
		BinaryTreeNode root = t.contruct_Tree(inorder, 0, 5, levelorder);
        System.out.println("The preorder travesal of the formed tree is : ");
        t.Preorder_traversal(root);
	}

}
