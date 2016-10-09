package Tree_Excercise.Ques_13;

public class Starter {
	public static void main(String[] args)
	{
		//int i= 0;
		//System.out.println("Print the value of i: " + i);
		BinaryTreeNode root= new BinaryTreeNode(12);
		Tree t= new Tree();
        t.formTree(root);
        int count = t.Min(root);
        System.out.println("Minimum height is : "+count);
        count = t.Max(root);
        System.out.println("Maximum height is : "+count);
         BinaryTreeNode curr =  t.lastNode(root);
         System.out.println("The deepest node is : "+curr.getData());
	}
}
