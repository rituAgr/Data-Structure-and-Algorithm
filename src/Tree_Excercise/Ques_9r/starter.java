package Tree_Excercise.Ques_9r;

import java.util.ArrayList;

public class starter {
	public static void main(String[] args)
	{
		BinaryTreeNode root = new BinaryTreeNode(12);
		ArrayList<Integer> list = new ArrayList<Integer>();
		Tree tt = new Tree();
		tt.formTree(root);
		list = tt.level_order_traversal(root);
		System.out.println("Proper Level order traversing :  ");
		for(int i : list)
			System.out.print(i+" ");
		list = tt.reverse_traversal(root);
		System.out.println("\n Reverse order Level order traversing :  ");
		for(int i : list)
			System.out.print(i+" ");
		
	}

}
