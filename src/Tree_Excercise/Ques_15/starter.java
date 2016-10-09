package Tree_Excercise.Ques_15;

public class starter {
	public static void main(String[] args)
	{
		//int i= 0;
		//System.out.println("Print the value of i: " + i);
		BinaryTreeNode root= new BinaryTreeNode(12);
		Tree t= new Tree();
		BinaryTreeNode node =t.formTree(root);
        System.out.println("Orginal tree : ");
        t.level_order(root);
     //   BinaryTreeNode node = new BinaryTreeNode(45);
        boolean check = t.replace(root, node);
        System.out.println("\n\nThe node got replaced : "+check);
        System.out.println("\nTree after getting replaced : ");
        t.level_order(root);
	}

}
