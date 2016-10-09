package Tree_geeksforgeeks;

class Node
	{
		int data;
		Node left, right;

		public Node(int item)
		{
			data = item;
			left = right = null;
		}
	}
public class getDiameter {
	int Max_dia=0;
	 int diameter(Node node)
	{
		if(node==null)
			return 0;
		int left_tree=diameter(node.left);
		int right_tree=diameter(node.right);
		int dia;
		if(left_tree>right_tree)
			dia=1+left_tree;
		else
			dia=1+right_tree;
		if(Max_dia<(1+left_tree+right_tree))
			Max_dia=1+left_tree+right_tree;
		return dia;
	}


	public static void main(String[] args) {
		getDiameter tree = new getDiameter();
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.left.right.right=new Node(6);
		root.left.right.right.right=new Node(7);	
		root.left.left.left=new Node(16);
		root.left.left.left.left=new Node(17);
		tree.diameter(root);
		System.out.println(tree.Max_dia);
	}

}
