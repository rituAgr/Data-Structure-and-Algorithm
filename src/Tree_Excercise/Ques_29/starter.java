package Tree_Excercise.Ques_29;

public class starter {
	public static void main(String[] args)
	{
		char[] inorder={'D','B','E','A','F','C'};
		char[] preorder={'A','B','D','E','C','F'};
		char[] postorder={'D','E','B','F','C','A'};
		Tree t = new Tree();
		BinaryTreeNode root = t.contruct_Tree(inorder, 0, 5, preorder);
		//BinaryTreeNode root = t.contruct_Tree1(inorder, 0, 5, postorder);
        System.out.println("The level order travesal of the formed tree is : ");
        t.level_order_traversal(root);
       // System.out.println("\nThe post order travesal of the formed tree is : ");
        //t.PostOrder(root);
	}

}
