package Tree_Excercise.Ques_16;

public class starter {
	public static void main(String[] args)
	{
		//int i= 0;
		//System.out.println("Print the value of i: " + i);
		BinaryTreeNode root= new BinaryTreeNode(12);
		Tree t= new Tree();
        t.formTree(root);
        int count = t.num_leaves(root);
        System.out.println("Num of leaves in tree are : "+count);
        System.out.println("The level Order traversal is ");
         t.Level_order(root);
	}

}
