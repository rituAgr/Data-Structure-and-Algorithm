package Tree_geeksforgeeks;/*
 * http://www.geeksforgeeks.org/symmetric-tree-tree-which-is-mirror-image-of-itself/
 */

public class isMirror {
	static class Node
	{
		int data;
		Node left,right;
		Node(int d)
		{
			data=d;
		}
	}
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(2);
		root.left.left = new Node(3);
		root.left.right = new Node(4);
		root.right.left = new Node(4);
		root.right.right = new Node(3);
		boolean output = isSymmetric(root.left,root.right);
		System.out.println(output);
	}
	public static boolean isSymmetric(Node node1,Node node2)
	{
		if(node1==null&&node2==null)
			return true;
		if(node1.data!=node2.data)
			return false;
		boolean b1=isSymmetric(node1.left,node2.right);
		boolean b2=isSymmetric(node1.right,node2.left);
		return b1&&b2;
	}
}
