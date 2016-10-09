package Tree_Excercise.Ques_38;
public class starter {
	public static void main(String[] args)
	{
		Tree t= new Tree();
		char A[]={'I','L','I','L','L'};
		BinaryTreeNode root=t.BulidTree(A,0);
        t.inOrder(root);;
	}

}
