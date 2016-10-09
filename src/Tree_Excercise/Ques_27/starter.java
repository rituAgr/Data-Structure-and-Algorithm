package Tree_Excercise.Ques_27;

public class starter {
	public static void main(String[] args)
	{
		//int i= 0;
		//System.out.println("Print the value of i: " + i);
		BinaryTreeNode root= new BinaryTreeNode(12);
		Tree t= new Tree();
        t.formTree(root);
        t.Level_order(root);
        System.out.println("\n");
        t.PreOrder(root);
        t.mirror_recur(root);
        System.out.println("\n\nThe mirror image of above :\n");
        t.Level_order(root);
        System.out.println("\n");
        t.PreOrder(root);
	}

}
