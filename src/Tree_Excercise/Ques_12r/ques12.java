package Tree_Excercise.Ques_12r;


public class ques12 {
	public static void main(String[] args)
	{
		BinaryTreeNode root = new BinaryTreeNode(12);
	//	ArrayList<Integer> list = new ArrayList<Integer>();
		Tree t = new Tree();
		t.formTree(root);
		int count = t.q_height(root);
		System.out.println(" size of tree is  :  "+count);
		
	}

}
