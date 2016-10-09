package Binary_tree.revision;

public class starter {
	public static void main(String[] args)
	{

		BinaryTreeNode root= new BinaryTreeNode(10);
		PreOrder t= new PreOrder();
		t.formTree(root);
		t.r_PreOrder(root);
		System.out.println();
		t.t_PreOrder(root);
	}
}
