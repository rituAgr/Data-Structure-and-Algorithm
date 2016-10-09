package Tree_Excercise.Ques_33;
public class starter {
	public static void main(String[] args)
	{

		BinaryTreeNode root= new BinaryTreeNode(12);
		Tree t= new Tree();
        t.formTree(root);
        BinaryTreeNode R3R = new BinaryTreeNode(77);
        BinaryTreeNode R1R = new BinaryTreeNode(55);
        int data=t.findLCA(root,R3R,R1R);
        //boolean check=t.ancestor(root, 0, path, data);
        System.out.println("Found LCA : "+data);
	}

}
