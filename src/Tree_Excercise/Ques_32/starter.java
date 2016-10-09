package Tree_Excercise.Ques_32;
public class starter {
	public static void main(String[] args)
	{

		BinaryTreeNode root= new BinaryTreeNode(12);
		Tree t= new Tree();
        t.formTree(root);
        int path[] = new int[100];
        int data=105;
        boolean check=t.ancestor(root, 0, path, data);
        System.out.println("Found : "+check);
	}

}
