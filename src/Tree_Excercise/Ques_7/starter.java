package Tree_Excercise.Ques_7;

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
		int count = t.recursive_count(root);
		System.out.println("\nRecursive size of tree is  :  "+count);
		count = t.count(root);
		System.out.println("Non-recursive size of tree is  :  "+count);
	}

}
