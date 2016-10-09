package Binary_tree.Depth_wise_traversal;

import java.util.ArrayList;

public class starter {
	public static void main(String[] args)
	{
		BinaryTreeNode root = new BinaryTreeNode(12);
		Tree t = new Tree();
		t.formTree(root);
		//recursive Traversal
		System.out.println("Recursive Preorder:");
		t.PreOrder(root);
		System.out.println("Recursive Inorder : ");
		t.InOrder(root);
		System.out.println("Recursive Postorder : ");
		t.PostOrder(root);
		//Iterative transversal
		Iterative_traversal iter = new Iterative_traversal();
		ArrayList<Integer> list = new ArrayList<Integer>();
		System.out.println("Iterative Preorder:");
		list=iter.PreOrder(root);
		for(Integer i : list)
		   System.out.println(i);
		System.out.println("Iterative Inorder : ");
		list=iter.InOrder(root);
		for(Integer i : list)
			   System.out.println(i);
		System.out.println("Iterative Postorder : ");
		list=iter.PostOrder(root);
		for(Integer i : list)
			   System.out.println(i);
	}

}
