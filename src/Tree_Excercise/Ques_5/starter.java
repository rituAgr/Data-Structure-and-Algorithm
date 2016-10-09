package Tree_Excercise.Ques_5;

import java.util.ArrayList;

public class starter {
	public static void main(String[] args)
	{
		BinaryTreeNode root = new BinaryTreeNode(12);
		ArrayList<Integer> list = new ArrayList<Integer>();
		Tree t = new Tree();
		t.formTree(root);
		list = t.level_order_traversal(root);
		System.out.println("Before Inserting the element :  ");
		for(int i : list)
			System.out.print(i+" ");
		boolean tt =t.recursive_insert(root, 25);
		list = t.level_order_traversal(root);
		System.out.println("\nAfter Inserting the element :  "+tt);
		for(int i : list)
			System.out.print(i+" ");
	}

}
