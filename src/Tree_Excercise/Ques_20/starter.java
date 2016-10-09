package Tree_Excercise.Ques_20;

public class starter {
	public static void main(String[] args)
	{
		//int i= 0;
		//System.out.println("Print the value of i: " + i);
		BinaryTreeNode root= new BinaryTreeNode(12);
		Tree t= new Tree();
        t.formTree(root);
        int count = t.width_of_tree(root);
        System.out.println("Width of tree is : "+count);
        count = t.diameterOfTree(root);
        System.out.println("dia of tree is : "+count);
	}

}
