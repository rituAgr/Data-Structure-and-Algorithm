package Tree_Excercise.Ques_36_37;
public class starter {
	public static void main(String[] args)
	{

		BinaryTreeNode root= new BinaryTreeNode(12);
		Tree t= new Tree();
        t.formTree(root);
        System.out.println("Verical Sum : ");
        t.VerticalSum(root);
        //Answer [0=102, -1=34, -2=22, 1=160, 2=45, 3=5]
	}

}
