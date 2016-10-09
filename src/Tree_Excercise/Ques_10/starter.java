package Tree_Excercise.Ques_10;

import java.util.ArrayList;

public class starter {
	public static void main(String[] args)
	{
		BinaryTreeNode root = new BinaryTreeNode(12);
		ArrayList<Integer> list = new ArrayList<Integer>();
		Tree t = new Tree();
		t.formTree(root);
		int count = t.height(root);
		System.out.println(" size of tree is  :  "+count);
		
	}

}
