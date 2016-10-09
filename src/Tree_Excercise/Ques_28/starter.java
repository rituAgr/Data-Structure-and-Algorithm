package Tree_Excercise.Ques_28;

public class starter {
	public static void main(String[] args)
	{
		//int i= 0;
		//System.out.println("Print the value of i: " + i);
		BinaryTreeNode root1= new BinaryTreeNode(12);
		BinaryTreeNode root2= new BinaryTreeNode(12);
		Tree t= new Tree();
        t.formTree1(root1);
        t.formTree2(root2);
        t.level_order_traversal(root1);
        t.level_order_traversal(root2);
        boolean check=t.mirror(root1, root2);
        System.out.println("\n\nAre both tree mirror image : "+check);
	}

}
