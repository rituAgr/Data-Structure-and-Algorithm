package Binary_tree.Breadth_wise_traversal;

import java.util.ArrayList;

public class starter {
	public static void main(String[] args)
	{
		BinaryTreeNode root = new BinaryTreeNode(12);
		Tree t = new Tree();
		t.formTree(root);
		ArrayList<Integer> list = new ArrayList<Integer>();
		System.out.println("Iterative Level order Traversal:");
		list=t.level_order_traversal(root);
		for(Integer i : list)
		   System.out.println(i);
		
	}

}
