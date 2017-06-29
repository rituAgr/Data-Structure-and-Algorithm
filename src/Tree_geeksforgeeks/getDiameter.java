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
		int l=diameter(node.left);
		int r=diameter(node.right);
		int dia=1+l+r;
		if(Max_dia<dia)
			Max_dia=dia;
		if(l>r)
			return l+1;
		return r+1;
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
